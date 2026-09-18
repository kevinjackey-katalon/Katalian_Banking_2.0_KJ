import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

String loginUrl = 'https://katalian-banking.vercel.app/login'
String username = 'bankinguser123'

WebUI.openBrowser(loginUrl)
WebUI.waitForPageLoad(15)

WebUI.setText(
    findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/TC19608466_LoginUsername'),
    username,
    FailureHandling.STOP_ON_FAILURE
)
WebUI.setText(
    findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/TC19608466_LoginPassword'),
    GlobalVariable.Katalian_Banking_Password,
    FailureHandling.STOP_ON_FAILURE
)
WebUI.enhancedClick(
    findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/TC19608466_EnterVaultAccess'),
    FailureHandling.STOP_ON_FAILURE
)

WebUI.waitForPageLoad(15)
WebUI.waitForElementVisible(
    findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/TC19608466_NetLiquidityLabel'),
    15,
    FailureHandling.STOP_ON_FAILURE
)
WebUI.verifyElementVisible(
    findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/TC19608466_NetLiquidityLabel'),
    FailureHandling.STOP_ON_FAILURE
)

String displayedNetLiquidity = WebUI.getText(
    findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/TC19608466_NetLiquidityAmount'),
    FailureHandling.STOP_ON_FAILURE
)
BigDecimal displayedTotal = new BigDecimal(displayedNetLiquidity.replaceAll('[^0-9.-]', ''))

List<String> currencyTexts = WebUI.executeJavaScript('''
    return Array.from(document.querySelectorAll('body *'))
        .filter(e => e.children.length === 0)
        .map(e => (e.innerText || e.textContent || '').trim())
        .filter(t => /^-?\\$[0-9,]+(?:\\.[0-9]{1,2})?$/.test(t));
''', []) as List<String>

assert !currencyTexts.isEmpty() : 'No currency-formatted account balances were found on the dashboard.'

List<BigDecimal> displayedAmounts = currencyTexts.collect {
    new BigDecimal(it.replaceAll('[^0-9.-]', ''))
}
int totalIndex = displayedAmounts.indexOf(displayedTotal)
assert totalIndex >= 0 : "Displayed Net Liquidity amount was not found among dashboard currency values: ${displayedNetLiquidity}"
displayedAmounts.remove(totalIndex)

BigDecimal calculatedSum = displayedAmounts.inject(BigDecimal.ZERO) { BigDecimal sum, BigDecimal value ->
    sum + value
}

WebUI.verifyEqual(calculatedSum.setScale(2), displayedTotal.setScale(2), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()
