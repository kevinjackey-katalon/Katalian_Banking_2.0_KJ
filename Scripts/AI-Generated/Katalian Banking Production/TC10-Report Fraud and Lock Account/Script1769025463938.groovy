import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Katalian_Banking_Production.common.enterSecureIdAndAccessCode
import truetest.Katalian_Banking_Production.custom.TrueTestScripts

def reportLocation = RunConfiguration.getReportFolder()

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1512, 762)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to https://katalian-banking.vercel.app/"

TrueTestScripts.navigate("/")

"Step 2: Login into Application"

TrueTestScripts.login()

"Step 3: Navigate to /login"

TrueTestScripts.navigate("login")

"Step 4: Enter secure ID and access code to access vault"

enterSecureIdAndAccessCode.execute(input_accessCode, input_secureId)

"Step 5: Click on button fraudReporting -> Navigate to page '/contact'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_fraudReporting'))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 5-Click on button fraudReporting - Navigate to page contact.png')

"Step 6: Click on button accountLockdown -> Navigate to page '/security/lockdown'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_contact/button_accountLockdown'))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 6-Click on button accountLockdown - Navigate to page securitylockdown.png')

"Step 7: Click on button globalLockdown (initiateGlobalLockdown)"

// Bind values to the variables in the locators of "AI-Generated/Katalian Banking Production/Dynamic Objects/Page_security_lockdown/button_globalLockdown"
WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Dynamic Objects/Page_security_lockdown/button_globalLockdown', ['button_globalLockdown_ButtonInternalText_1': button_globalLockdown_ButtonInternalText]))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 7-Click on button globalLockdown initiateGlobalLockdown.png')

"Step 8: Click on button globalLockdown (confirmGlobalFreeze) -> Navigate to page '/login'"

// Bind values to the variables in the locators of "AI-Generated/Katalian Banking Production/Dynamic Objects/Page_security_lockdown/button_globalLockdown"
WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Dynamic Objects/Page_security_lockdown/button_globalLockdown', ['button_globalLockdown_ButtonInternalText_1': button_globalLockdown_ButtonInternalText_1]))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 8-Click on button globalLockdown confirmGlobalFreeze - Navigate to page login.png')

"Step 9: Click on input secureId"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 9-Click on input secureId.png')

"Step 10: Enter input value in input secureId"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'), input_secureId_1)

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 10-Enter input value in input secureId.png')

"Step 11: Click on input accessCode"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 11-Click on input accessCode.png')

"Step 12: Enter input value in input accessCode"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'), input_accessCode_1)

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 12-Enter input value in input accessCode.png')

"Step 13: Click on button enterVaultAccess"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/button_enterVaultAccess'))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 13-Click on button enterVaultAccess.png')

"Step 14: Click on button enterVaultAccess -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/button_enterVaultAccess'))

// WebUI.takeScreenshot(reportLocation + '/TC10/Step 14-Click on button enterVaultAccess - Navigate to page .png')

"Step 15: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC10-Report Fraud and Lock Account_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}