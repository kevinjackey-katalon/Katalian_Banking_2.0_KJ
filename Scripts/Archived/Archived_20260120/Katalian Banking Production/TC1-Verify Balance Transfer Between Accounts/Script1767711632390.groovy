import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import archived.archived_20260120.truetest.Katalian_Banking_Production.common.transferBalanceAndReview
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

"Step 3: Transfer balance between accounts and review transfer"

transferBalanceAndReview.execute(input_amount, select_fromAccount)

"Step 4: Click on button confirmTransfer -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/button_confirmTransfer'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 4-Click on button confirmTransfer - Navigate to page .png')

"Step 5: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Verify Balance Transfer Between Accounts_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}