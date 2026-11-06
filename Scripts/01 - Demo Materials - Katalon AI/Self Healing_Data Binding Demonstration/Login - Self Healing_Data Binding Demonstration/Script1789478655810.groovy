import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import org.openqa.selenium.Keys as Keys

// =====================================================================
// TEST CASE: Login - Self Healing_Data Binding Demonstration
// GOAL:
// - Demonstrate self-healing object usage in a basic login flow
// - Demonstrate use of data-bound variables (e.g., username/password)
// =====================================================================
/*
// [1] Execution traceability: Log where this run’s report artifacts are stored
KeywordUtil.logInfo('Report Results Log: ' + RunConfiguration.getReportFolder())


// [2] Session setup: Start browser using environment-based application domain
WebUI.openBrowser(GlobalVariable.application_domain + '/login')

// [3] Navigation: Ensure test begins from the known Login page
WebUI.navigateToUrl('https://katalian-banking.vercel.app/login')
*/
String url = GlobalVariable.application_domain + '/login'

CustomKeywords.'common.utilities.shared_functions.userLogin'(url)

if (WebUI.waitForPageLoad(30) == false) {
    KeywordUtil.markFailedAndStop('Page did not load within 30 seconds. Stopping test execution.')

    WebUI.acceptAlert( // [4] Test data entry: Enter credentials (username variable + encrypted password)
        ) //NOTE: The 'input_username_broken' object is intentionally named to demonstrate self-healing.
    //It should still work if the username field's properties change, as long as the self-healing mechanism can find it.
    // [5] Action: Submit login
    // [6] Teardown: Close browser
} else {
    WebUI.setText(findTestObject('Object Repository/01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_username_broken'), 
        username)

    WebUI.setEncryptedText(findTestObject('01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_password'), 
        'CS9RmWxFPRFoMJc95WUBEN4WG8mxfTJo')

    WebUI.click(findTestObject('01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/button_Enter Vault Access'))

    WebUI.closeBrowser()
}

