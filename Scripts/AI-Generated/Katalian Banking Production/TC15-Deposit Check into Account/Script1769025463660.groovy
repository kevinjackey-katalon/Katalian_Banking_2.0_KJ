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

"Step 5: Click on button deposit -> Navigate to page '/deposit'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_deposit'))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 5-Click on button deposit - Navigate to page deposit.png')

"Step 6: Click on button checkDeposit"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_deposit/button_checkDeposit'))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 6-Click on button checkDeposit.png')

"Step 7: Select option with input value from select accountSelection"

TrueTestScripts.selectOption(findTestObject('AI-Generated/Katalian Banking Production/Page_deposit/select_accountSelection'), select_accountSelection, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 7-Select option with input value from select accountSelection.png')

"Step 8: Click on input provisionAmount"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_deposit/input_provisionAmount'))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 8-Click on input provisionAmount.png')

"Step 9: Enter input value in input provisionAmount"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_deposit/input_provisionAmount'), input_provisionAmount)

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 9-Enter input value in input provisionAmount.png')

"Step 10: Click on div continue"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_deposit/div_continue'))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 10-Click on div continue.png')

"Step 11: Click on button depositAuthorization (continue)"

// Bind values to the variables in the locators of "AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositAuthorization"
WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositAuthorization', ['button_depositAuthorization_ButtonInternalText_1': button_depositAuthorization_ButtonInternalText]))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 11-Click on button depositAuthorization continue.png')

"Step 12: Click on div captureFront"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_deposit/div_captureFront'))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 12-Click on div captureFront.png')

"Step 13: Click on span camera"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_deposit/span_camera'))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 13-Click on span camera.png')

"Step 14: Click on button depositNavigation (continue2)"

// Bind values to the variables in the locators of "AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositNavigation"
WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositNavigation', ['button_depositNavigation_ButtonInternalText_1': button_depositNavigation_ButtonInternalText]))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 14-Click on button depositNavigation continue2.png')

"Step 15: Click on button depositAuthorization (authorizeDeposit)"

// Bind values to the variables in the locators of "AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositAuthorization"
WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositAuthorization', ['button_depositAuthorization_ButtonInternalText_1': button_depositAuthorization_ButtonInternalText_1]))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 15-Click on button depositAuthorization authorizeDeposit.png')

"Step 16: Click on button depositNavigation (returnToPortfolio) -> Navigate to page '/dashboard'"

// Bind values to the variables in the locators of "AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositNavigation"
WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Dynamic Objects/Page_deposit/button_depositNavigation', ['button_depositNavigation_ButtonInternalText_1': button_depositNavigation_ButtonInternalText_1]))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 16-Click on button depositNavigation returnToPortfolio - Navigate to page dashboard.png')

"Step 17: Click on div savingsCard2 -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/div_savingsCard2'))

// WebUI.takeScreenshot(reportLocation + '/TC15/Step 17-Click on div savingsCard2 - Navigate to page .png')

"Step 18: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC15-Deposit Check into Account_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}