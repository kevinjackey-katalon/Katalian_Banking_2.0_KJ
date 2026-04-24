package common.utilities

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * Shared reusable functions/keywords.
 */
class shared_functions {

	/**
	 * Keyword: Open browser and navigate to the given application URL.
	 *
	 * Step description:
	 * - Open a new browser session and navigate to the provided URL.
	 *
	 * @param url Application URL to navigate to.
	 */
	@Keyword
	void userLogin(String url) {
		KeywordUtil.logInfo("[Step] Open browser and navigate to: ${url}")
		WebUI.openBrowser(url)
	}

	/**
	 * Keyword: Safely click on an element with retry to reduce flakiness (e.g., stale element).
	 *
	 * Step description:
	 * - Wait for the element to be present.
	 * - Click the element.
	 * - Retry when an exception occurs, up to the configured number of retries.
	 *
	 * @param to The target TestObject.
	 * @param timeout Timeout (seconds) to wait for element presence.
	 * @param retries Number of retry attempts.
	 */
	@Keyword
	static void safeClick(TestObject to, int timeout = 10, int retries = 3) {
		if (timeout == 0) timeout = 10

		int attempt = 0
		while (attempt < retries) {
			try {
				KeywordUtil.logInfo("[Step] Wait for element present (timeout=${timeout}s), then click. Attempt ${attempt + 1}/${retries}")
				WebUI.waitForElementPresent(to, timeout)
				WebUI.click(to, timeout)
				return
			} catch (Exception e) {
				attempt++
				KeywordUtil.logInfo("[Step] Click failed on attempt ${attempt}/${retries}. Error: ${e.message}")

				if (attempt >= retries) {
					KeywordUtil.markFailed("Failed to click element after ${retries} attempts: ${e.message}")
				}
				WebUI.delay(1)
			}
		}
	}

	/**
	 * Keyword: Safely set text on an element with retry to reduce flakiness (e.g., stale element).
	 * Note: This method also includes a click before setting text to ensure the element is focused, which can help with certain types of input fields.
	 * Step description:
	 * - Wait for the element to be present.
	 * - Focus/click the element.
	 * - Set text into the element.
	 * - Retry when an exception occurs, up to the configured number of retries.
	 *
	 * @param to The target TestObject.
	 * @param text Text to input.
	 * @param timeout Timeout (seconds) to wait for element presence.
	 * @param retries Number of retry attempts.
	 */
	@Keyword
	static void safeSendKeys(TestObject to, String text, int timeout = 10, int retries = 3) {
		if (timeout == 0) timeout = 10

		int attempt = 0
		while (attempt < retries) {
			try {
				KeywordUtil.logInfo("[Step] Wait for element present (timeout=${timeout}s), focus, then set text. Attempt ${attempt + 1}/${retries}")
				WebUI.waitForElementPresent(to, timeout)
				WebUI.click(to, timeout)
				WebUI.setText(to, text, timeout)
				return
			} catch (Exception e) {
				attempt++
				KeywordUtil.logInfo("[Step] Set text failed on attempt ${attempt}/${retries}. Error: ${e.message}")

				if (attempt >= retries) {
					KeywordUtil.markFailed("Failed to send keys after ${retries} attempts: ${e.message}")
				}
				WebUI.delay(1)
			}
		}
	}
}
