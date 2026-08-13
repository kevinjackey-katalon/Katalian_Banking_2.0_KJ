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

"Step 5: Click on button savings -> Navigate to page '/apply/Savings'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_dashboard/button_savings'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 5-Click on button savings - Navigate to page applySavings.png')

"Step 6: Click on input legalFirstName"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_legalFirstName'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 6-Click on input legalFirstName.png')

"Step 7: Enter input value in input legalFirstName"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_legalFirstName'), input_legalFirstName)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 7-Enter input value in input legalFirstName.png')

"Step 8: Click on input middleName"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_middleName'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 8-Click on input middleName.png')

"Step 9: Enter input value in input middleName"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_middleName'), input_middleName)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 9-Enter input value in input middleName.png')

"Step 10: Click on input legalLastName"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_legalLastName'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 10-Click on input legalLastName.png')

"Step 11: Enter input value in input legalLastName"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_legalLastName'), input_legalLastName)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 11-Enter input value in input legalLastName.png')

"Step 12: Enter input value in input dateOfBirth"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_dateOfBirth'), input_dateOfBirth)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 12-Enter input value in input dateOfBirth.png')

"Step 13: Click on button continue"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/button_continue'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 13-Click on button continue.png')

"Step 14: Click on input primaryAddressLine"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_primaryAddressLine'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 14-Click on input primaryAddressLine.png')

"Step 15: Enter input value in input primaryAddressLine"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_primaryAddressLine'), input_primaryAddressLine)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 15-Enter input value in input primaryAddressLine.png')

"Step 16: Click on input city"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_city'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 16-Click on input city.png')

"Step 17: Enter input value in input city"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_city'), input_city)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 17-Enter input value in input city.png')

"Step 18: Select option with input value from select state"

TrueTestScripts.selectOption(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/select_state'), select_state, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 18-Select option with input value from select state.png')

"Step 19: Click on input zipCode"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_zipCode'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 19-Click on input zipCode.png')

"Step 20: Enter input value in input zipCode"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/input_zipCode'), input_zipCode)

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 20-Enter input value in input zipCode.png')

"Step 21: Click on button continue2"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/button_continue'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 21-Click on button continue2.png')

"Step 22: Click on button enterFacilityDashboard"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/button_enterFacilityDashboard'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 22-Click on button enterFacilityDashboard.png')

"Step 23: Click on button enterFacilityDashboard -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_apply_Savings/button_enterFacilityDashboard'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 23-Click on button enterFacilityDashboard - Navigate to page dashboard.png')

"Step 24: Click on div savingsCard -> Navigate to page '/account/*'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_dashboard/div_savingsCard'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 24-Click on div savingsCard - Navigate to page account.png')

"Step 25: Click on button signOut -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_account/button_signOut'))

// WebUI.takeScreenshot(reportLocation + '/TC13/Step 25-Click on button signOut - Navigate to page .png')

"Step 26: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC13-Apply for Savings Account with Personal Information_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}