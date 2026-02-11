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

"Step 1: Navigate to /dashboard"

TrueTestScripts.navigate("dashboard")

"Step 2: Click on button freezeAllCards -> Navigate to page '/security/freeze-all'"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_dashboard/button_freezeAllCards'))

// WebUI.takeScreenshot(reportLocation + '/TC2/Step 2-Click on button freezeAllCards - Navigate to page securityfreeze-all.png')

"Step 3: Click on button authorizeCryoFreeze"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_security_freeze_all/button_authorizeCryoFreeze'))

// WebUI.takeScreenshot(reportLocation + '/TC2/Step 3-Click on button authorizeCryoFreeze.png')

"Step 4: Click on button backToPortfolio -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking QA/Page_security_freeze_all/button_backToPortfolio'))

// WebUI.takeScreenshot(reportLocation + '/TC2/Step 4-Click on button backToPortfolio - Navigate to page .png')

"Step 5: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('Freeze All Cards from Dashboard_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}