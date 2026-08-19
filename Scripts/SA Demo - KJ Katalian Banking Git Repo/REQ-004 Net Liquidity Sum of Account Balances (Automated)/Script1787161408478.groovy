import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

WebUI.openBrowser('')
try {
    WebUI.navigateToUrl(targetUrl)
    WebUI.setText(findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/Page_Login/input_secureId'), userId)
    WebUI.setText(findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/Page_Login/input_accessCode'), GlobalVariable.Katalian_Banking_Password)
    WebUI.click(findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/Page_Login/button_enterVaultAccess'))
    WebUI.verifyElementVisible(findTestObject('Object Repository/SA Demo - KJ Katalian Banking Git Repo/Page_Dashboard/dashboard_main'))
} finally {
    WebUI.closeBrowser()
}