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

"Step 2: Login into Application"

TrueTestScripts.login()

"Step 3: Click on button applyNow (applyNow2) -> Navigate to page '/apply/*'"

// Bind values to the variables in the locators of "Archived/Archived_20260120/Katalian Banking Production/Dynamic Objects/Page_dashboard/button_applyNow"
WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Dynamic Objects/Page_dashboard/button_applyNow', ['button_applyNow_divInternalHasText_1': button_applyNow_divInternalHasText_1]))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 3-Click on button applyNow applyNow2 - Navigate to page apply.png')

"Step 4: Click on input firstName"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_firstName'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 4-Click on input firstName.png')

"Step 5: Enter input value in input firstName"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_firstName'), input_firstName)

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 5-Enter input value in input firstName.png')

"Step 6: Click on input lastName"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_lastName'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 6-Click on input lastName.png')

"Step 7: Enter input value in input lastName"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_lastName'), input_lastName)

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 7-Enter input value in input lastName.png')

"Step 8: Enter input value in input dateOfBirth"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_dateOfBirth'), input_dateOfBirth)

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 8-Enter input value in input dateOfBirth.png')

"Step 9: Click on button next"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/button_next'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 9-Click on button next.png')

"Step 10: Click on input addressLine"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_addressLine'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 10-Click on input addressLine.png')

"Step 11: Enter input value in input addressLine"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_addressLine'), input_addressLine)

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 11-Enter input value in input addressLine.png')

"Step 12: Click on input city"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_city'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 12-Click on input city.png')

"Step 13: Enter input value in input city"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_city'), input_city)

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 13-Enter input value in input city.png')

"Step 14: Select option with input value from select state"

TrueTestScripts.selectOption(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/select_state'), select_state, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 14-Select option with input value from select state.png')

"Step 15: Click on input zipCode"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_zipCode'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 15-Click on input zipCode.png')

"Step 16: Enter input value in input zipCode"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_zipCode'), input_zipCode)

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 16-Enter input value in input zipCode.png')

"Step 17: Click on button submitApplication"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/button_submitApplication'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 17-Click on button submitApplication.png')

"Step 18: Click on button returnToDashboard -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/button_returnToDashboard'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 18-Click on button returnToDashboard - Navigate to page dashboard.png')

"Step 19: Click on span pending"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_dashboard/span_pending'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 19-Click on span pending.png')

"Step 20: Click on button logout -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_dashboard/button_logout'))

// WebUI.takeScreenshot(reportLocation + '/TC6/Step 20-Click on button logout - Navigate to page .png')

"Step 21: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC6-Submit Application and Logout from Dashboard_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}