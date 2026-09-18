import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import java.util.regex.Pattern
import org.openqa.selenium.WebElement

try {
    WebUI.openBrowser("https://katalian-banking.vercel.app/login")
    WebUI.waitForPageLoad(10)
    WebUI.setText(findTestObject("Sept 2026 TO Demo/login_username"), "bankinguser123")
    WebUI.setText(findTestObject("Sept 2026 TO Demo/login_password"), GlobalVariable.Katalian_Banking_Password)
    WebUI.click(findTestObject("Sept 2026 TO Demo/btn_enter_vault_access"))
    WebUI.waitForPageLoad(10)

    boolean labelVisible = WebUI.verifyElementVisible(findTestObject("Sept 2026 TO Demo/lbl_net_liquidity"))
    assert labelVisible : "[NL-001] Net Liquidity label is not visible on the dashboard"
    String labelText = WebUI.getText(findTestObject("Sept 2026 TO Demo/lbl_net_liquidity"))
    assert labelText.trim().equalsIgnoreCase("Net Liquidity") : "[NL-001] Label text mismatch. Expected: Net Liquidity, Actual: ${labelText}"

    boolean activeAssetsBadgeVisible = WebUI.verifyElementVisible(findTestObject("Sept 2026 TO Demo/badge_active_assets"))
    assert activeAssetsBadgeVisible : "[NL-004] Active Assets badge is not visible"
    String activeAssetsText = WebUI.getText(findTestObject("Sept 2026 TO Demo/badge_active_assets"))
    assert activeAssetsText.toLowerCase().contains("active assets") : "[NL-004] Active Assets badge text mismatch. Actual: ${activeAssetsText}"

    boolean memberBadgeVisible = WebUI.verifyElementVisible(findTestObject("Sept 2026 TO Demo/badge_member_since"))
    assert memberBadgeVisible : "[NL-005] Member since 2021 badge is not visible"
    String memberBadgeText = WebUI.getText(findTestObject("Sept 2026 TO Demo/badge_member_since"))
    assert memberBadgeText.toLowerCase().contains("member since 2021") : "[NL-005] Member since badge text mismatch. Actual: ${memberBadgeText}"

    String balanceText = WebUI.getText(findTestObject("Sept 2026 TO Demo/lbl_net_liquidity_balance"))
    String normalizedBalanceText = balanceText.replaceAll("\\s+", "").trim()
    Pattern currencyPattern = Pattern.compile('^\\$[0-9]{1,3}(,[0-9]{3})*\\.[0-9]{2}$')
    assert currencyPattern.matcher(normalizedBalanceText).matches() : "[NL-003] Balance has an invalid currency format. Actual: ${balanceText}"

    List<WebElement> accountBalanceElements = WebUI.findWebElements(findTestObject("Sept 2026 TO Demo/list_account_balances"), 10)
    double computedSum = 0.0
    accountBalanceElements.each { el ->
        String rawText = el.getText().replaceAll("[^0-9.]", "")
        if (rawText) computedSum += Double.parseDouble(rawText)
    }
    double displayedTotal = Double.parseDouble(normalizedBalanceText.replaceAll("[^0-9.]", ""))
    assert Math.abs(displayedTotal - computedSum) < 0.01 : "[NL-002/FR-001] Net Liquidity total mismatch. Displayed: ${displayedTotal}, Computed sum: ${computedSum}"

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

    KeywordUtil.logInfo("TC-20111565 PASSED: All Net Liquidity display items verified successfully.")
} finally {
    try {
        WebUI.closeBrowser()
    } catch (Exception ignored) {
        // Preserve the original test failure if cleanup also fails.
    }
}
