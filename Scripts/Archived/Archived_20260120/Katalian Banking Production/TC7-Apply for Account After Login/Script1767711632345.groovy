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

"Step 3: Click on button applyNow (applyNow) -> Navigate to page '/apply/*'"

// Bind values to the variables in the locators of "Archived/Archived_20260120/Katalian Banking Production/Dynamic Objects/Page_dashboard/button_applyNow"
WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Dynamic Objects/Page_dashboard/button_applyNow', ['button_applyNow_divInternalHasText_1': button_applyNow_divInternalHasText_1]))

// WebUI.takeScreenshot(reportLocation + '/TC7/Step 3-Click on button applyNow applyNow - Navigate to page apply.png')

"Step 4: Click on input firstName -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_apply/input_firstName'))

// WebUI.takeScreenshot(reportLocation + '/TC7/Step 4-Click on input firstName - Navigate to page .png')

"Step 5: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC7-Apply for Account After Login_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}