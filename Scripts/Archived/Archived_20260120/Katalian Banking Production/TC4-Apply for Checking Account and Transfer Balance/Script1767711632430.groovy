import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Katalian_Banking_Production.custom.TrueTestScripts

def reportLocation = RunConfiguration.getReportFolder()

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1512, 823)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to /login"

TrueTestScripts.navigate("")

"Step 2: Click on div username"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_login/div_username'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 2-Click on div username.png')

"Step 3: Login into Application"

TrueTestScripts.login()

"Step 4: Click on button applyNow3 -> Navigate to page '/apply/Checking'"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_dashboard/button_applyNow3'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 4-Click on button applyNow3 - Navigate to page applyChecking.png')

"Step 5: Click on input firstName"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_firstName'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 5-Click on input firstName.png')

"Step 6: Enter input value in input firstName"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_firstName'), input_firstName)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 6-Enter input value in input firstName.png')

"Step 7: Click on input lastName"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_lastName'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 7-Click on input lastName.png')

"Step 8: Enter input value in input lastName"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_lastName'), input_lastName)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 8-Enter input value in input lastName.png')

"Step 9: Enter input value in input dateOfBirth"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_dateOfBirth'), input_dateOfBirth)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 9-Enter input value in input dateOfBirth.png')

"Step 10: Click on button next"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/button_next'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 10-Click on button next.png')

"Step 11: Click on input addressLine"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_addressLine'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 11-Click on input addressLine.png')

"Step 12: Enter input value in input addressLine"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_addressLine'), input_addressLine)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 12-Enter input value in input addressLine.png')

"Step 13: Click on input city"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_city'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 13-Click on input city.png')

"Step 14: Enter input value in input city"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_city'), input_city)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 14-Enter input value in input city.png')

"Step 15: Select option with input value from select state"

TrueTestScripts.selectOption(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/select_state'), select_state, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 15-Select option with input value from select state.png')

"Step 16: Click on input zipCode"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_zipCode'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 16-Click on input zipCode.png')

"Step 17: Enter input value in input zipCode"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_zipCode'), input_zipCode)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 17-Enter input value in input zipCode.png')

"Step 18: Click on button next"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/button_next'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 18-Click on button next.png')

"Step 19: Click on input amount"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_amount'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 19-Click on input amount.png')

"Step 20: Enter input value in input amount"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/input_amount'), input_amount)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 20-Enter input value in input amount.png')

"Step 21: Select option with input value from select transferFrom"

TrueTestScripts.selectOption(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/select_transferFrom'), select_transferFrom, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 21-Select option with input value from select transferFrom.png')

"Step 22: Click on button submitApplication"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/button_submitApplication'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 22-Click on button submitApplication.png')

"Step 23: Click on button returnToDashboard -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply_Checking/button_returnToDashboard'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 23-Click on button returnToDashboard - Navigate to page dashboard.png')

"Step 24: Click on button transferBalance -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_dashboard/button_transferBalance'))

// WebUI.takeScreenshot(reportLocation + '/TC4/Step 24-Click on button transferBalance - Navigate to page .png')

"Step 25: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC4-Apply for Checking Account and Transfer Balance_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}