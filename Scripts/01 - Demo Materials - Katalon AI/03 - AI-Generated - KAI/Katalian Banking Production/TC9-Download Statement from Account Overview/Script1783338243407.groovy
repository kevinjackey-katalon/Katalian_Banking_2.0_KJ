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
	WebUI.setViewPortSize(1192, 712)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to https://katalian-banking.vercel.app/"

TrueTestScripts.navigate("/")

"Step 2: Login into Application"

TrueTestScripts.login()

"Step 3: Navigate to /login"

TrueTestScripts.navigate("login")

"Step 4: Enter input value in input secureId -> Navigate to page '/dashboard'"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_secureId'), input_secureId)

// WebUI.takeScreenshot(reportLocation + '/TC9/Step 4-Enter input value in input secureId - Navigate to page dashboard.png')

"Step 5: Enter input value in input accessCode"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_dashboard/input_accessCode'), input_accessCode)

// WebUI.takeScreenshot(reportLocation + '/TC9/Step 5-Enter input value in input accessCode.png')

"Step 6: Click on div accountOverview -> Navigate to page '/account/*'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_dashboard/div_accountOverview'))

// WebUI.takeScreenshot(reportLocation + '/TC9/Step 6-Click on div accountOverview - Navigate to page account.png')

"Step 7: Click on button dateTime2"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_account/button_dateTime2'))

// WebUI.takeScreenshot(reportLocation + '/TC9/Step 7-Click on button dateTime2.png')

"Step 8: Click on button downloadStatement -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_account/button_downloadStatement'))

// WebUI.takeScreenshot(reportLocation + '/TC9/Step 8-Click on button downloadStatement - Navigate to page .png')

"Step 9: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC9-Download Statement from Account Overview_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}