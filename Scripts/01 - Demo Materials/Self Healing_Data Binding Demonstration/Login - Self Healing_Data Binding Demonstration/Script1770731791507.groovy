import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// =====================================================================
// TEST CASE: Login - Self Healing_Data Binding Demonstration
// GOAL:
// - Demonstrate self-healing object usage in a basic login flow
// - Demonstrate use of data-bound variables (e.g., username/password)
// =====================================================================


// [1] Execution traceability: Log where this run’s report artifacts are stored
KeywordUtil.logInfo('Report Results Log: ' + RunConfiguration.getReportFolder())  

/*
// [2] Session setup: Start browser using environment-based application domain
//WebUI.openBrowser(GlobalVariable.application_domain + '/login')

// [3] Navigation: Ensure test begins from the known Login page
WebUI.navigateToUrl('https://katalian-banking.vercel.app/login')
*/

String url = GlobalVariable.application_domain + '/login'
CustomKeywords.'common.utilities.shared_functions.userLogin'(url)

// [4] Test data entry: Enter credentials (username variable + encrypted password)
//NOTE: The 'input_username_broken' object is intentionally named to demonstrate self-healing.
//It should still work if the username field's properties change, as long as the self-healing mechanism can find it.
WebUI.setText(findTestObject('Object Repository/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_username_broken'), username)
WebUI.setEncryptedText(findTestObject('Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_password'), 'CS9RmWxFPRFoMJc95WUBEN4WG8mxfTJo')


// [5] Action: Submit login
WebUI.click(findTestObject('Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/button_Enter Vault Access'))


// [6] Teardown: Close browser
WebUI.closeBrowser()
