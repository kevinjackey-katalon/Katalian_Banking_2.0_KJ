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
	WebUI.setViewPortSize(1512, 762)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to /login"

TrueTestScripts.navigate("login")

"Step 2: Click on input secureId"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_login/input_secureId'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 2-Click on input secureId.png')

"Step 3: Enter input value in input secureId"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_login/input_secureId'), input_secureId)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 3-Enter input value in input secureId.png')

"Step 4: Click on input accessCode"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_login/input_accessCode'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 4-Click on input accessCode.png')

"Step 5: Enter input value in input accessCode"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_login/input_accessCode'), input_accessCode)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 5-Enter input value in input accessCode.png')

"Step 6: Click on button enterVaultAccess -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_login/button_enterVaultAccess'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 6-Click on button enterVaultAccess - Navigate to page dashboard.png')

"Step 7: Click on button payments -> Navigate to page '/transfer'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_dashboard/button_payments'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 7-Click on button payments - Navigate to page transfer.png')

"Step 8: Select option with input value from select originLiquidity"

TrueTestScripts.selectOption(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_transfer/select_originLiquidity'), select_originLiquidity, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 8-Select option with input value from select originLiquidity.png')

"Step 9: Select option with input value from select recipientFacility"

TrueTestScripts.selectOption(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_transfer/select_recipientFacility'), select_recipientFacility, "label", false)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 9-Select option with input value from select recipientFacility.png')

"Step 10: Click on input liquidCapitalAmount"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_transfer/input_liquidCapitalAmount'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 10-Click on input liquidCapitalAmount.png')

"Step 11: Enter input value in input liquidCapitalAmount"

WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_transfer/input_liquidCapitalAmount'), input_liquidCapitalAmount)

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 11-Enter input value in input liquidCapitalAmount.png')

"Step 12: Click on button reviewProtocol"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_transfer/button_reviewProtocol'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 12-Click on button reviewProtocol.png')

"Step 13: Click on button authorizePayment -> Navigate to page '/dashboard'"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_transfer/button_authorizePayment'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 13-Click on button authorizePayment - Navigate to page dashboard.png')

"Step 14: Click on button signOut -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking QA/Page_dashboard/button_signOut'))

// WebUI.takeScreenshot(reportLocation + '/TC1/Step 14-Click on button signOut - Navigate to page .png')

"Step 15: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Complete Payment Transfer and Logout from Dashboard_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}