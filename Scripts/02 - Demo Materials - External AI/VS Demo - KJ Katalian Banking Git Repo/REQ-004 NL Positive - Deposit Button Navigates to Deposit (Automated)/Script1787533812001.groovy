import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

try {
    WebUI.navigateToUrl(targetUrl)

    WebUI.setText(findTestObject('VS Demo - KJ Katalian Banking Git Repo/Page_Login/input_secureId'), userId)
    WebUI.setText(findTestObject('VS Demo - KJ Katalian Banking Git Repo/Page_Login/input_accessCode'), password)
    WebUI.click(findTestObject('VS Demo - KJ Katalian Banking Git Repo/Page_Login/button_enterVaultAccess'))

    WebUI.waitForElementVisible(findTestObject('VS Demo - KJ Katalian Banking Git Repo/Page_Dashboard/button_deposit'), 15)
    WebUI.click(findTestObject('VS Demo - KJ Katalian Banking Git Repo/Page_Dashboard/button_deposit'))

    WebUI.verifyMatch(WebUI.getUrl(), '.*/deposit$', true, FailureHandling.STOP_ON_FAILURE)
} finally {
    WebUI.closeBrowser()
}
