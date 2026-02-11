import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Katalian_Banking_QA.custom.TrueTestScripts

def reportLocation = RunConfiguration.getReportFolder()

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1133, 762)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to /login"

TrueTestScripts.navigate("login")

"Step 2: Click on input secureId"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 2-Click on input secureId.png')

"Step 3: Enter input value in input secureId"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_login/input_secureId'), input_secureId)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 3-Enter input value in input secureId.png')

"Step 4: Click on input accessCode"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_login/input_accessCode'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 4-Click on input accessCode.png')

"Step 5: Enter input value in input accessCode"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_login/input_accessCode'), input_accessCode)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 5-Enter input value in input accessCode.png')

"Step 6: Click on button enterVaultAccess -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_login/button_enterVaultAccess'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 6-Click on button enterVaultAccess - Navigate to page dashboard.png')

"Step 7: Click on button savings -> Navigate to page '/apply/Savings'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_dashboard/button_savings'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 7-Click on button savings - Navigate to page applySavings.png')

"Step 8: Click on input legalFirstName"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_legalFirstName'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 8-Click on input legalFirstName.png')

"Step 9: Enter input value in input legalFirstName"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_legalFirstName'), input_legalFirstName)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 9-Enter input value in input legalFirstName.png')

"Step 10: Click on input legalLastName"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_legalLastName'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 10-Click on input legalLastName.png')

"Step 11: Enter input value in input legalLastName"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_legalLastName'), input_legalLastName)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 11-Enter input value in input legalLastName.png')

"Step 12: Enter input value in input dateOfBirth"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_dateOfBirth'), input_dateOfBirth)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 12-Enter input value in input dateOfBirth.png')

"Step 13: Click on button continue"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/button_continue'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 13-Click on button continue.png')

"Step 14: Click on input primaryAddressLine"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_primaryAddressLine'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 14-Click on input primaryAddressLine.png')

"Step 15: Enter input value in input primaryAddressLine"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_primaryAddressLine'), input_primaryAddressLine)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 15-Enter input value in input primaryAddressLine.png')

"Step 16: Click on input city"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_city'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 16-Click on input city.png')

"Step 17: Enter input value in input city"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_city'), input_city)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 17-Enter input value in input city.png')

"Step 18: Select option with input value from select state"

TrueTestScripts.selectOption(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/select_state'), select_state, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 18-Select option with input value from select state.png')

"Step 19: Click on input zipCode"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_zipCode'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 19-Click on input zipCode.png')

"Step 20: Enter input value in input zipCode"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/input_zipCode'), input_zipCode)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 20-Enter input value in input zipCode.png')

"Step 21: Click on button continue2"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/button_continue'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 21-Click on button continue2.png')

"Step 22: Click on button enterFacilityDashboard -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_apply_Savings/button_enterFacilityDashboard'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 22-Click on button enterFacilityDashboard - Navigate to page .png')

"Step 23: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('Apply for New Savings Account_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}