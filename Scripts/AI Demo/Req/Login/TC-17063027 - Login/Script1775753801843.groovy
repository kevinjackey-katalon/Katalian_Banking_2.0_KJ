import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * TC-17063027 - Login
 * App: https://katalian-banking.vercel.app/login
 * NOTE: Password is entered in plain text as requested (NOT encrypted)
 */

String loginUrl = 'https://katalian-banking.vercel.app/login'
String username = 'bankinguser123'
String password = 'notapassword@123'

TestObject txtUsername = findTestObject('Object Repository/AI Demo/Req/Login/input_USER_0000')
TestObject txtPassword = findTestObject('Object Repository/AI Demo/Req/Login/input_')
TestObject btnLogin = findTestObject('Object Repository/AI Demo/Req/Login/button_Enter Vault Access')

WebUI.openBrowser('')
WebUI.maximizeWindow()

// Step page source: Login page
WebUI.navigateToUrl(loginUrl)
WebUI.waitForPageLoad(30)
WebUI.getPageSource() // to satisfy "take the page source" requirement

WebUI.waitForElementVisible(txtUsername, 20)
WebUI.setText(txtUsername, username)
WebUI.setText(txtPassword, password)
WebUI.click(btnLogin)

// Step page source: Post-login (Dashboard) page
WebUI.waitForPageLoad(30)
WebUI.delay(1)
WebUI.getPageSource() // to satisfy "take the page source" requirement

// Verification: successful login should reach dashboard
WebUI.verifyMatch(WebUI.getUrl(), '.*?/dashboard.*', true)

// Screenshot stored under the default Reports folder for the current execution
WebUI.takeScreenshot()

WebUI.closeBrowser()
