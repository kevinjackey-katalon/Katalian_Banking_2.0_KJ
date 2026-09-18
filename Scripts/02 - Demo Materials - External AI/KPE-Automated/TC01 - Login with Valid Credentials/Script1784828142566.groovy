import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Katalian_Banking_Production.custom.TrueTestScripts

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1541, 929)
}

'Step 1: Navigate to the login page'
TrueTestScripts.navigate('login')

'Step 2: Enter the username into the Secure ID field'
WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_secureId'), username)

'Step 3: Enter the password into the Access Code field (value must be bound at runtime to the Katalian_Banking_Password TestOps secret)'
WebUI.setText(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_accessCode'), password)

'Step 4: Click the Enter Vault Access (Login) button'
WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/button_enterVaultAccess'))

'Step 5: Verify the dashboard is displayed, confirming successful login'
WebUI.verifyElementPresent(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_dashboard/div_accountOverview'), 10)

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
