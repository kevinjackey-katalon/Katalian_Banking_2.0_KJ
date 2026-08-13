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
	WebUI.setViewPortSize(1541, 929)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to /login"

TrueTestScripts.navigate("login")

"Step 2: Click on input secureId"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 2-Click on input secureId.png')

"Step 3: Click on input secureId"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 3-Click on input secureId.png')

"Step 4: Click on input secureId"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 4-Click on input secureId.png')

"Step 5: Enter input value in input secureId"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_secureId'), input_secureId)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 5-Enter input value in input secureId.png')

"Step 6: Click on input accessCode"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_accessCode'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 6-Click on input accessCode.png')

"Step 7: Enter input value in input accessCode"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_accessCode'), input_accessCode)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 7-Enter input value in input accessCode.png')

"Step 8: Click on button enterVaultAccess -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/button_enterVaultAccess'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 8-Click on button enterVaultAccess - Navigate to page .png')

"Step 9: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('Verify Successful Login_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}