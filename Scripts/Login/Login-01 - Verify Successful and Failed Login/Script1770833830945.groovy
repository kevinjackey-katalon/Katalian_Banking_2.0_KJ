import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String loginUrl = 'https://katalian-banking.vercel.app/login'
String username = 'bankinguser123'
String password = 'notapassword@123'

String expectedSuccessHeader = 'Make Appointment'
String expectedFailureMessage = 'Login failed! Please ensure the username and password are valid.'

    // 1. Open a new browser instance.
    WebUI.openBrowser('')
    WebUI.maximizeWindow()

    // 2. Navigate to the login URL.
    WebUI.navigateToUrl(loginUrl)

    // 3. Wait until the login page is fully loaded.
    WebUI.waitForPageLoad(30)
    WebUI.waitForElementVisible(findTestObject('null'), 30)
    WebUI.waitForElementVisible(findTestObject('null'), 30)
    WebUI.waitForElementClickable(findTestObject('null'), 30)

    // 4. Enter username into the username field.
    WebUI.setText(findTestObject('null'), username)

    // 5. Enter password into the password field (NOT encrypted as requested).
    WebUI.setText(findTestObject('null'), password)

    // 6. Click the Login button.
    WebUI.click(findTestObject('null'))

    // 7. Wait for page navigation to complete.
    WebUI.waitForPageLoad(30)

    // Decide success vs fail based on expected success header existence.
    boolean success = WebUI.waitForElementVisible(findTestObject('null'), 10, FailureHandling.OPTIONAL)

    if (success) {
        // Verification – Successful Login
        String currentUrl = WebUI.getUrl()
        WebUI.verifyMatch(currentUrl, '.*#appointment.*', true) // regex
        WebUI.verifyElementText(findTestObject('null'), expectedSuccessHeader)

        // Capture a screenshot of the logged-in state (saved under Reports by default)
        WebUI.takeScreenshot()
        KeywordUtil.markPassed('Login successful. Verified URL contains #appointment and header is Make Appointment.')
    } else {
        // Error Handling – Failed Login
        boolean hasError = WebUI.waitForElementVisible(findTestObject('null'), 10, FailureHandling.OPTIONAL)
        WebUI.verifyEqual(hasError, true)

        if (hasError) {
            String actualError = WebUI.getText(findTestObject('null')).trim()
            WebUI.verifyEqual(actualError, expectedFailureMessage)
        }

        // Capture a screenshot for failure evidence (saved under Reports by default)
        WebUI.takeScreenshot()
        KeywordUtil.markFailed('Login failed. Verified error message and captured screenshot evidence.')
    }
