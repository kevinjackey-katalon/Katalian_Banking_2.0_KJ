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

"Step 5: Click on button moveFunds -> Navigate to page '/transfer'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_dashboard/button_moveFunds'))

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 5-Click on button moveFunds - Navigate to page transfer.png')

"Step 6: Select option with input value from select originLiquidity"

TrueTestScripts.selectOption(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_transfer/select_originLiquidity'), select_originLiquidity, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 6-Select option with input value from select originLiquidity.png')

"Step 7: Select option with input value from select recipientFacility"

TrueTestScripts.selectOption(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_transfer/select_recipientFacility'), select_recipientFacility, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 7-Select option with input value from select recipientFacility.png')

"Step 8: Click on button payFullBalance"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_transfer/button_payFullBalance'))

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 8-Click on button payFullBalance.png')

"Step 9: Click on button reviewProtocol2"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_transfer/button_reviewProtocol2'))

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 9-Click on button reviewProtocol2.png')

"Step 10: Click on button authorizePayment -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_transfer/button_authorizePayment'))

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 10-Click on button authorizePayment - Navigate to page dashboard.png')

"Step 11: Click on div creditCard -> Navigate to page '/account/*'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_dashboard/div_creditCard'))

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 11-Click on div creditCard - Navigate to page account.png')

"Step 12: Click on button signOut -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_account/button_signOut'))

// WebUI.takeScreenshot(reportLocation + '/TC16/Step 12-Click on button signOut - Navigate to page .png')

"Step 13: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC16-Verify Secure Fund Transfer and Logout Process_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}