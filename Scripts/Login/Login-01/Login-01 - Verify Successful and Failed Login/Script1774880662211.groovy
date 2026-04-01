import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * Login-01 - Verify Successful and Failed Login
 * Objective: Validate successful and unsuccessful login for the Katalian Banking demo application.
 */

String loginUrl = 'https://katalian-banking.vercel.app/login'
String username = 'bankinguser123'
String password = 'notapassword@123' // Do NOT encrypt

String expectedFailedMsg = 'Login failed! Please ensure the username and password are valid.'

WebUI.openBrowser('')
WebUI.maximizeWindow()

try {
	WebUI.navigateToUrl(loginUrl)
	WebUI.waitForPageLoad(30)

	// Wait until the login page is fully loaded
	WebUI.waitForElementVisible(findTestObject('Object Repository/Login/input_USER_0000'), 30)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Login/input_'), 30)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Login/button_Enter Vault Access'), 30)

	// Enter credentials
	WebUI.setText(findTestObject('Object Repository/Login/input_USER_0000'), username)
	WebUI.setText(findTestObject('Object Repository/Login/input_'), password)
	WebUI.click(findTestObject('Object Repository/Login/button_Enter Vault Access'))

	// Wait for page navigation to complete
	WebUI.delay(1)
	WebUI.waitForPageLoad(30)

	// Verification – Successful Login
	boolean isSuccessUrl = WebUI.verifyUrlContains('#appointment', FailureHandling.OPTIONAL)

	if (isSuccessUrl) {
		TestObject headerMakeAppointment = new TestObject('dynamic_h2_makeAppointment')
		headerMakeAppointment.addProperty('xpath', ConditionType.EQUALS, "//h2[normalize-space(.)='Make Appointment']")

		WebUI.verifyElementVisible(headerMakeAppointment)
		WebUI.verifyElementText(headerMakeAppointment, 'Make Appointment')

		// Stored automatically in the default Katalon Reports folder
		WebUI.takeScreenshot()
		KeywordUtil.logInfo('Successful login verified. Screenshot captured.')
	} else {
		// Error Handling – Failed Login
		TestObject alertDanger = new TestObject('dynamic_alert_text_danger')
		alertDanger.addProperty('css', ConditionType.EQUALS, '.text-danger')

		WebUI.verifyElementVisible(alertDanger)
		WebUI.verifyElementText(alertDanger, expectedFailedMsg)

		// Stored automatically in the default Katalon Reports folder
		WebUI.takeScreenshot()
		KeywordUtil.markFailed('Login failed verified. Screenshot captured.')
	}
} finally {
	WebUI.closeBrowser()
}
