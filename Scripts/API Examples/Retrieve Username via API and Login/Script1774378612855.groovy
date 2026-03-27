import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper

/**
 * Test Case: Retrieve Username via API and Login
 *
 * Purpose:
 * - Call an API endpoint to retrieve user details (JSON)
 * - Extract the username from the response
 * - Use the retrieved username to log into the web application
 *
 * Pre-requisites:
 * - API service is running and accessible at: http://localhost:3000
 * - Web app login page is accessible at: https://katalian-banking.vercel.app/login
 * - Object Repository test objects in this test are present and valid
 */

// ================================
// STEP 1: Build REST request to retrieve user details
// ================================
KeywordUtil.logInfo('STEP 1 - Build REST request (GET user details)')

String endpoint = 'http://localhost:3000/api/users/user1'
String requestMethod = 'GET'

RequestObject request = new RequestObject('Get User Details')
request.setRestUrl(endpoint)
request.setRestRequestMethod(requestMethod)

// ================================
// STEP 2: Send request
// ================================
KeywordUtil.logInfo("STEP 2 - Send request to endpoint: ${endpoint}")

ResponseObject response = WS.sendRequest(request)

// ================================
// STEP 3: Verify API response status
// ================================
KeywordUtil.logInfo('STEP 3 - Verify HTTP status code = 200')

WS.verifyResponseStatusCode(response, 200)

// ================================
// STEP 4: Parse JSON response body
// ================================
KeywordUtil.logInfo('STEP 4 - Parse JSON response body')

def jsonSlurper = new JsonSlurper()
def user = jsonSlurper.parseText(response.getResponseBodyContent())

// ================================
// STEP 5: Extract and validate username from response
// ================================
KeywordUtil.logInfo('STEP 5 - Extract and validate username')

def username = user?.username

assert username != null : 'Username was null or missing from response'
assert username == 'bankinguser123' : "Unexpected username: ${username}"

KeywordUtil.logInfo('Retrieved username: ' + username)

// ================================
// STEP 6: Open login page
// ================================
KeywordUtil.logInfo('STEP 6 - Open browser and navigate to login page')

WebUI.openBrowser('https://katalian-banking.vercel.app/login')

// ================================
// STEP 7: Populate login form with API-provided username
// ================================
KeywordUtil.logInfo('STEP 7 - Enter credentials and submit login form')

WebUI.setText(findTestObject('Object Repository/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_username'), username)
WebUI.setText(findTestObject('Object Repository/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_password'), 'notapassword@123')
WebUI.click(findTestObject('Object Repository/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/button_Enter Vault Access'))

// ================================
// STEP 8 (Optional): Add post-login verification
// ================================
// Example (uncomment and update test object as needed):
KeywordUtil.logInfo('STEP 8 - Verify user is logged in')
WebUI.verifyElementPresent(findTestObject('Object Repository/.../label_Dashboard'), 10)