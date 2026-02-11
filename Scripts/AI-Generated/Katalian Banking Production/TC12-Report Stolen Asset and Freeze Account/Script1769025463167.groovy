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

"Step 5: Click on button helpCenter -> Navigate to page '/contact'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_helpCenter'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 5-Click on button helpCenter - Navigate to page contact.png')

"Step 6: Click on input messageConcierge"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_contact/input_messageConcierge'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 6-Click on input messageConcierge.png')

"Step 7: Enter input value in input messageConcierge"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_contact/input_messageConcierge'), input_messageConcierge)

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 7-Enter input value in input messageConcierge.png')

"Step 8: Click on button submit"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_contact/button_submit'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 8-Click on button submit.png')

"Step 9: Click on button reportStolenAsset -> Navigate to page '/security/report'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_contact/button_reportStolenAsset'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 9-Click on button reportStolenAsset - Navigate to page securityreport.png')

"Step 10: Select option with input value from select accountType"

TrueTestScripts.selectOption(findTestObject('AI-Generated/Katalian Banking Production/Page_security_report/select_accountType'), select_accountType, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 10-Select option with input value from select accountType.png')

"Step 11: Click on textarea compromiseDescription"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_security_report/textarea_compromiseDescription'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 11-Click on textarea compromiseDescription.png')

"Step 12: Enter input value in textarea compromiseDescription"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_security_report/textarea_compromiseDescription'), textarea_compromiseDescription)

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 12-Enter input value in textarea compromiseDescription.png')

"Step 13: Click on button authorizeAssetFreeze"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_security_report/button_authorizeAssetFreeze'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 13-Click on button authorizeAssetFreeze.png')

"Step 14: Click on button executeFreezeProtocol"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_security_report/button_executeFreezeProtocol'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 14-Click on button executeFreezeProtocol.png')

"Step 15: Click on button backToPortfolio -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_security_report/button_backToPortfolio'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 15-Click on button backToPortfolio - Navigate to page dashboard.png')

"Step 16: Click on button signOut -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_signOut'))

// WebUI.takeScreenshot(reportLocation + '/TC12/Step 16-Click on button signOut - Navigate to page .png')

"Step 17: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC12-Report Stolen Asset and Freeze Account_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}