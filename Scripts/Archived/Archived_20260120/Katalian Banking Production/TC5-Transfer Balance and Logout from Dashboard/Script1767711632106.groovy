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

"Step 3: Click on button transferBalance -> Navigate to page '/transfer'"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_dashboard/button_transferBalance'))

// WebUI.takeScreenshot(reportLocation + '/TC5/Step 3-Click on button transferBalance - Navigate to page transfer.png')

"Step 4: Click on input amount"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/input_amount'))

// WebUI.takeScreenshot(reportLocation + '/TC5/Step 4-Click on input amount.png')

"Step 5: Enter input value in input amount"

WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/input_amount'), input_amount)

// WebUI.takeScreenshot(reportLocation + '/TC5/Step 5-Enter input value in input amount.png')

"Step 6: Click on button reviewTransfer"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/button_reviewTransfer'))

// WebUI.takeScreenshot(reportLocation + '/TC5/Step 6-Click on button reviewTransfer.png')

"Step 7: Click on button confirmTransfer -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/button_confirmTransfer'))

// WebUI.takeScreenshot(reportLocation + '/TC5/Step 7-Click on button confirmTransfer - Navigate to page dashboard.png')

"Step 8: Click on button logout -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_dashboard/button_logout'))

// WebUI.takeScreenshot(reportLocation + '/TC5/Step 8-Click on button logout - Navigate to page .png')

"Step 9: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC5-Transfer Balance and Logout from Dashboard_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}