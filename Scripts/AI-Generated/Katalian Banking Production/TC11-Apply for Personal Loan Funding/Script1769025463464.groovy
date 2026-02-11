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

"Step 5: Click on button requestLending -> Navigate to page '/loans'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_requestLending'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 5-Click on button requestLending - Navigate to page loans.png')

"Step 6: Click on button applyForFunding -> Navigate to page '/apply-loan/Personal'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_loans/button_applyForFunding'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 6-Click on button applyForFunding - Navigate to page apply-loanPersonal.png')

"Step 7: Click on input firstName"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_firstName'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 7-Click on input firstName.png')

"Step 8: Enter input value in input firstName"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_firstName'), input_firstName)

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 8-Enter input value in input firstName.png')

"Step 9: Click on input lastName"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_lastName'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 9-Click on input lastName.png')

"Step 10: Enter input value in input lastName"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_lastName'), input_lastName)

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 10-Enter input value in input lastName.png')

"Step 11: Enter input value in input dateOfBirth"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_dateOfBirth'), input_dateOfBirth)

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 11-Enter input value in input dateOfBirth.png')

"Step 12: Click on input primaryResidence"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_primaryResidence'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 12-Click on input primaryResidence.png')

"Step 13: Enter input value in input primaryResidence"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_primaryResidence'), input_primaryResidence)

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 13-Enter input value in input primaryResidence.png')

"Step 14: Click on button continue"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/button_continue'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 14-Click on button continue.png')

"Step 15: Click on input currentEmployer"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_currentEmployer'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 15-Click on input currentEmployer.png')

"Step 16: Enter input value in input currentEmployer"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_currentEmployer'), input_currentEmployer)

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 16-Enter input value in input currentEmployer.png')

"Step 17: Click on input jobTitle"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_jobTitle'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 17-Click on input jobTitle.png')

"Step 18: Enter input value in input jobTitle"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_jobTitle'), input_jobTitle)

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 18-Enter input value in input jobTitle.png')

"Step 19: Click on input annualIncome"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_annualIncome'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 19-Click on input annualIncome.png')

"Step 20: Enter input value in input annualIncome"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/input_annualIncome'), input_annualIncome)

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 20-Enter input value in input annualIncome.png')

"Step 21: Click on button continue2 -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_apply_loan_Personal/button_continue'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 21-Click on button continue2 - Navigate to page dashboard.png')

"Step 22: Click on button signOut -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_signOut'))

// WebUI.takeScreenshot(reportLocation + '/TC11/Step 22-Click on button signOut - Navigate to page .png')

"Step 23: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC11-Apply for Personal Loan Funding_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}