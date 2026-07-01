import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement

/*
 * Test Case: CD Example - TC
 * Requirement: REQ-004 Subtask 1 - Validate Page Display Items - Net Liquidity (Jira: KB-32)
 *
 * Validates the Dashboard Net Liquidity section:
 *   NL-001 - "Net Liquidity" label is displayed
 *   FR-001 / NL-002 - Total balance equals the sum of all account balances
 *   NL-003 - Balance is formatted as currency ($ sign, thousands separator, 2 decimals)
 *   NL-004 - "Active Assets" status badge is displayed
 *   NL-005 - "Member since 2021" badge is displayed
 *   NL-006 - "Move Funds" button is displayed
 *   NL-007 - "Deposit" button is displayed
 */

// Step 1: Open browser and navigate to the login page
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(targetUrl)

// Step 2: Authenticate with Secure ID and Access Code
WebUI.setText(findTestObject('CD Example - TC/input_Secure ID_username'), userId)

WebUI.setText(findTestObject('CD Example - TC/input_Access Code_password'), password)

WebUI.click(findTestObject('CD Example - TC/btn_Enter Vault Access'))

// Step 3: NL-001 - Verify the "Net Liquidity" label is displayed on the dashboard
WebUI.verifyElementPresent(findTestObject('CD Example - TC/lbl_Net Liquidity'), 15)

WebUI.verifyElementText(findTestObject('CD Example - TC/lbl_Net Liquidity'), 'Net Liquidity')

// Step 4: FR-001 / NL-003 - Verify total balance is displayed and formatted as currency
String totalBalanceRaw = WebUI.getText(findTestObject('CD Example - TC/txt_Total Balance'))

String totalBalanceText = totalBalanceRaw.replaceAll('\\s+', '')

WebUI.comment('Displayed Net Liquidity total: ' + totalBalanceText)

WebUI.verifyMatch(totalBalanceText, '\\$\\d{1,3}(,\\d{3})*\\.\\d{2}', true)

// Step 5: NL-002 - Verify total balance equals the sum of all account balances
List<WebElement> accountBalanceElements = WebUI.findWebElements(findTestObject('CD Example - TC/txt_Account Balances'), 10)

BigDecimal expectedSum = 0.0G

for (WebElement balanceElement : accountBalanceElements) {
    String balanceText = balanceElement.getText().replaceAll('[\\$,\\s]', '')

    expectedSum = expectedSum.add(new BigDecimal(balanceText))
}

BigDecimal displayedTotal = new BigDecimal(totalBalanceText.replaceAll('[\\$,]', ''))

WebUI.comment('Sum of ' + accountBalanceElements.size() + ' account balances: ' + expectedSum.toPlainString())

assert displayedTotal.compareTo(expectedSum) == 0 : ('Net Liquidity total (' + displayedTotal.toPlainString() + ') does not equal the sum of account balances (' + expectedSum.toPlainString() + ')')

// Step 6: NL-004 - Verify "Active Assets" status badge is displayed
WebUI.verifyElementVisible(findTestObject('CD Example - TC/badge_Active Assets'))

WebUI.verifyElementText(findTestObject('CD Example - TC/badge_Active Assets'), 'Active Assets')

// Step 7: NL-005 - Verify "Member since 2021" badge is displayed
WebUI.verifyElementVisible(findTestObject('CD Example - TC/badge_Member since 2021'))

WebUI.verifyElementText(findTestObject('CD Example - TC/badge_Member since 2021'), 'Member since 2021')

// Step 8: NL-006 - Verify "Move Funds" button is displayed
WebUI.verifyElementVisible(findTestObject('CD Example - TC/btn_Move Funds'))

// Step 9: NL-007 - Verify "Deposit" button is displayed
WebUI.verifyElementVisible(findTestObject('CD Example - TC/btn_Deposit'))

// Step 10: Close the browser
WebUI.closeBrowser()
