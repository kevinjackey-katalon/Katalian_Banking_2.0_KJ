import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

/**
 * API AI Demo - TC01
 * Steps:
 * 1) Open endpoint http://localhost:3000/api/users
 * 2) Perform GET request to retrieve user details
 * 3) Validate HTTP 200
 * 4) Parse response body and extract all usernames, then display them
 * 5) Validate 'bankinguser123' is included in the username list
 */

// Step 1 & 2: Send GET request to /api/users using Object Repository
RequestObject request = findTestObject('Object Repository/03 - AI-Generated - KAI/API AI Demo/Users/GET - Get all users')
KeywordUtil.logInfo("Sending GET request to: ${request.getRestUrl()}")

ResponseObject response = WS.sendRequest(request)

// Step 3: Validate response status code 200
int statusCode = response.getStatusCode()
KeywordUtil.logInfo("Response status code: ${statusCode}")

if (statusCode != 200) {
    KeywordUtil.markFailedAndStop("Expected HTTP 200 but got ${statusCode}. Response body: ${response.getResponseBodyContent()}")
}

// Step 4: Parse response and list usernames
String responseBody = response.getResponseBodyContent()
KeywordUtil.logInfo("Response body (raw): ${responseBody}")

def parsed = new JsonSlurper().parseText(responseBody)

List<String> usernames = []

// Expected response is typically an array of user objects: [{username: '...'}, ...]
if (parsed instanceof List) {
    parsed.each { userObj ->
        def u = userObj?.username
        if (u != null) {
            usernames << u.toString()
        }
    }
} else if (parsed instanceof Map) {
    // Fallback: if API wraps user list in a field like {users:[...]}
    def listCandidate = parsed.users
    if (listCandidate instanceof List) {
        listCandidate.each { userObj ->
            def u = userObj?.username
            if (u != null) {
                usernames << u.toString()
            }
        }
    }
}

KeywordUtil.logInfo("Extracted usernames (${usernames.size()}): ${usernames}")

// Step 5: Validate bankinguser123 is present
String expectedUsername = 'bankinguser123'
boolean exists = usernames.contains(expectedUsername)
KeywordUtil.logInfo("Username '${expectedUsername}' present: ${exists}")

if (!exists) {
    KeywordUtil.markFailedAndStop("Expected username '${expectedUsername}' was not found. Usernames returned: ${usernames}")
}
