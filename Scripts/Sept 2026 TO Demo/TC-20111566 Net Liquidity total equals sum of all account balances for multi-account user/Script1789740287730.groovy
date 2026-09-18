import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.regex.Pattern

import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.openBrowser("https://katalian-banking.vercel.app/login")
WebUI.waitForPageLoad(10)
WebUI.setText(findTestObject("Sept 2026 TO Demo/login_username"), "bankinguser123")

// setEncryptedText requires a Katalon-encrypted Base64 value; this global variable is the usable password value.
WebUI.setText(findTestObject("Sept 2026 TO Demo/login_password"), GlobalVariable.Katalian_Banking_Password)
WebUI.click(findTestObject("Sept 2026 TO Demo/btn_enter_vault_access"))
WebUI.waitForPageLoad(10)

WebUI.verifyElementVisible(findTestObject("Sept 2026 TO Demo/lbl_net_liquidity"))
List<WebElement> accountBalanceElements = WebUI.findWebElements(findTestObject("Sept 2026 TO Demo/list_account_balances"), 10)
assert accountBalanceElements.size() > 0 : "No account balance elements found in Accounts and Cards section"

double computedSum = 0.0
accountBalanceElements.each { el ->
    String rawText = el.getText().replaceAll("[^0-9.]", "")
    if (rawText) {
        computedSum += Double.parseDouble(rawText)
        KeywordUtil.logInfo("Account balance found: ${el.getText().trim()} -> parsed: ${rawText}")
    }
}
KeywordUtil.logInfo("Computed sum of all account balances: ${computedSum}")
String balanceText = WebUI.getText(findTestObject("Sept 2026 TO Demo/lbl_net_liquidity_balance")).replaceAll("\\s+", "")
KeywordUtil.logInfo("Displayed Net Liquidity total: ${balanceText}")
double displayedTotal = Double.parseDouble(balanceText.replaceAll("[^0-9.]", ""))
assert Math.abs(displayedTotal - computedSum) < 0.01 : "[NL-002/FR-001] Net Liquidity total mismatch. Displayed: ${displayedTotal}, Computed sum from accounts: ${computedSum}"

Pattern currencyPattern = Pattern.compile('^\\$[0-9]{1,3}(,[0-9]{3})*\\.[0-9]{2}$')
assert currencyPattern.matcher(balanceText).matches() : "[NL-003] Balance has an invalid currency format. Actual: ${balanceText}"
WebUI.verifyElementVisible(findTestObject("Sept 2026 TO Demo/badge_active_assets"))
String activeAssetsText = WebUI.getText(findTestObject("Sept 2026 TO Demo/badge_active_assets")).trim()
assert activeAssetsText.equalsIgnoreCase("Active Assets") : "[NL-004] Active Assets badge text mismatch. Actual: ${activeAssetsText}"
WebUI.verifyElementVisible(findTestObject("Sept 2026 TO Demo/badge_member_since"))
String memberBadgeText = WebUI.getText(findTestObject("Sept 2026 TO Demo/badge_member_since")).trim()
assert memberBadgeText.equalsIgnoreCase("Member since 2021") : "[NL-005] Member since badge text mismatch. Actual: ${memberBadgeText}"

WebUI.click(findTestObject("Sept 2026 TO Demo/btn_move_funds"))
WebUI.waitForPageLoad(10)
String transferUrl = WebUI.getUrl()
assert transferUrl.endsWith("/transfer") : "[NL-006] Move Funds did not navigate to /transfer. Actual URL: ${transferUrl}"
WebUI.back()
WebUI.waitForPageLoad(10)
WebUI.verifyElementVisible(findTestObject("Sept 2026 TO Demo/lbl_net_liquidity"))
WebUI.click(findTestObject("Sept 2026 TO Demo/btn_deposit"))
WebUI.waitForPageLoad(10)
String depositUrl = WebUI.getUrl()
assert depositUrl.endsWith("/deposit") : "[NL-007] Deposit did not navigate to /deposit. Actual URL: ${depositUrl}"
WebUI.closeBrowser()
KeywordUtil.logInfo("TC-20111566 PASSED: Net Liquidity total verified against computed sum of all account balances.")
