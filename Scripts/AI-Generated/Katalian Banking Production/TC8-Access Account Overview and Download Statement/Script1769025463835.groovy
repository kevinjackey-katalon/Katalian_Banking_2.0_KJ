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
	WebUI.setViewPortSize(732, 762)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to https://katalian-banking.vercel.app/"

TrueTestScripts.navigate("/")

"Step 2: Login into Application"

TrueTestScripts.login()

"Step 3: Navigate to /login"

TrueTestScripts.navigate("login")

"Step 4: Click on input secureId"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 4-Click on input secureId.png')

"Step 5: Click on input accessCode"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 5-Click on input accessCode.png')

"Step 6: Click on input secureId"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 6-Click on input secureId.png')

"Step 7: Enter input value in input secureId"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'), input_secureId)

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 7-Enter input value in input secureId.png')

"Step 8: Click on input accessCode"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 8-Click on input accessCode.png')

"Step 9: Click on input secureId"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 9-Click on input secureId.png')

"Step 10: Enter input value in input secureId"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'), input_secureId_1)

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 10-Enter input value in input secureId.png')

"Step 11: Click on input accessCode"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 11-Click on input accessCode.png')

"Step 12: Enter input value in input accessCode"

WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'), input_accessCode)

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 12-Enter input value in input accessCode.png')

"Step 13: Click on button enterVaultAccess -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/button_enterVaultAccess'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 13-Click on button enterVaultAccess - Navigate to page dashboard.png')

"Step 14: Click on div accountOverview -> Navigate to page '/account/*'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/div_accountOverview'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 14-Click on div accountOverview - Navigate to page account.png')

"Step 15: Click on button dateTime"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_account/button_dateTime'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 15-Click on button dateTime.png')

"Step 16: Click on button downloadStatement"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_account/button_downloadStatement'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 16-Click on button downloadStatement.png')

"Step 17: Click on button backToPortfolio -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_account/button_backToPortfolio'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 17-Click on button backToPortfolio - Navigate to page dashboard.png')

"Step 18: Click on button signOut -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_dashboard/button_signOut'))

// WebUI.takeScreenshot(reportLocation + '/TC8/Step 18-Click on button signOut - Navigate to page .png')

"Step 19: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC8-Access Account Overview and Download Statement_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}