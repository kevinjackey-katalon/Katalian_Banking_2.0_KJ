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

'Step 2: Click the Enter Vault Access (Login) button without entering any credentials'
WebUI.enhancedClick(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/button_enterVaultAccess'))

'Step 3: Verify the user remains on the login page (login blocked) - the username field should still be present'
WebUI.verifyElementPresent(findTestObject('03 - AI-Generated - KAI/AI-Generated/Katalian Banking Production/Page_login/input_secureId'), 10)

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
