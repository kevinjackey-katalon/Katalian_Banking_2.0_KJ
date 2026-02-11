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

"Step 5: Click on button payments -> Navigate to page '/transfer'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_payments'))

// WebUI.takeScreenshot(reportLocation + '/TC14/Step 5-Click on button payments - Navigate to page transfer.png')

"Step 6: Select option with input value from select originLiquidity"

TrueTestScripts.selectOption(findTestObject('AI-Generated/Katalian Banking Production/Page_transfer/select_originLiquidity'), select_originLiquidity, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC14/Step 6-Select option with input value from select originLiquidity.png')

"Step 7: Click on input liquidCapitalAmount"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_transfer/input_liquidCapitalAmount'))

// WebUI.takeScreenshot(reportLocation + '/TC14/Step 7-Click on input liquidCapitalAmount.png')

"Step 8: Enter input value in input liquidCapitalAmount"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_transfer/input_liquidCapitalAmount'), input_liquidCapitalAmount)

// WebUI.takeScreenshot(reportLocation + '/TC14/Step 8-Enter input value in input liquidCapitalAmount.png')

"Step 9: Click on button reviewProtocol"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_transfer/button_reviewProtocol'))

// WebUI.takeScreenshot(reportLocation + '/TC14/Step 9-Click on button reviewProtocol.png')

"Step 10: Click on button authorizeTransfer -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_transfer/button_authorizeTransfer'))

// WebUI.takeScreenshot(reportLocation + '/TC14/Step 10-Click on button authorizeTransfer - Navigate to page .png')

"Step 11: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC14-Transfer Funds from Account_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}