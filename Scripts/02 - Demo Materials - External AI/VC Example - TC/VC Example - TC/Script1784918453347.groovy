import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

try {
    WebUI.navigateToUrl(targetUrl)

    WebUI.setText(findTestObject('VC Example - TC/txt_SecureID'), userId)
    WebUI.setText(findTestObject('VC Example - TC/txt_AccessCode'), password)
    WebUI.click(findTestObject('VC Example - TC/btn_EnterVaultAccess'))

    WebUI.waitForElementVisible(findTestObject('VC Example - TC/lbl_NetLiquidity'), 15)
    String netLiquidityLabel = WebUI.getText(findTestObject('VC Example - TC/lbl_NetLiquidity')).trim()
    WebUI.verifyMatch(netLiquidityLabel, '(?i)^Net Liquidity$', true)

    String amountText = WebUI.getText(findTestObject('VC Example - TC/txt_NetLiquidityAmount')).trim()
    WebUI.verifyMatch(amountText, /^\$\s?\d{1,3}(,\d{3})*\.\d{2}$/, true)

    WebUI.verifyElementPresent(findTestObject('VC Example - TC/badge_ActiveAssets'), 10)
    WebUI.verifyElementPresent(findTestObject('VC Example - TC/badge_MemberSince2021'), 10)
    WebUI.verifyElementVisible(findTestObject('VC Example - TC/btn_MoveFunds'))
    WebUI.verifyElementVisible(findTestObject('VC Example - TC/btn_Deposit'))

    WebUI.click(findTestObject('VC Example - TC/btn_MoveFunds'))
    WebUI.verifyMatch(WebUI.getUrl(), '.*/transfer$', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.back()
    WebUI.waitForElementVisible(findTestObject('VC Example - TC/btn_Deposit'), 10)

    WebUI.click(findTestObject('VC Example - TC/btn_Deposit'))
    WebUI.verifyMatch(WebUI.getUrl(), '.*/deposit$', true, FailureHandling.CONTINUE_ON_FAILURE)
} finally {
    WebUI.closeBrowser()
}