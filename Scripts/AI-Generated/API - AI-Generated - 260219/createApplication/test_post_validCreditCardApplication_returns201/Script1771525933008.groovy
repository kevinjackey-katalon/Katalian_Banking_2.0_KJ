import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def addHeaderConfiguration(request) {
    def content_type_header = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
    request.getHttpHeaderProperties().add(content_type_header)
}

uuid = UUID.randomUUID().toString()

// Step 1: Create an Account
def createAccountRequest = findTestObject('Object Repository/Katalian Bank API (1)/accounts/createAccount')
if (createAccountRequest == null) {
    // Since no test object for /accounts POST is provided, create one dynamically
    createAccountRequest = new RequestObject('createAccount')
    createAccountRequest.setRestRequestMethod('POST')
    createAccountRequest.setRestUrl('http://localhost:3000/api/accounts')
}
addHeaderConfiguration(createAccountRequest)

def accountPayload = [
    id: "acc4-1__unique__",
    type: "Credit Card",
    balance: 10000.0,
    accountNumber: "****8765"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))

def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 201)

// Step 2: Submit Application
def createApplicationRequest = findTestObject('null')
addHeaderConfiguration(createApplicationRequest)

def applicationPayload = [
    accountType: "Credit Card",
    applicationData: [
        firstName: "Bob__unique__",
        lastName: "Wilson__unique__",
        dob: "1985-08-20",
        address: "456 Oak Ave",
        city: "Los Angeles",
        state: "California",
        zip: "90001"
    ]
]
def applicationPayloadJson = JsonOutput.toJson(applicationPayload)
createApplicationRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(applicationPayloadJson)))

def createApplicationResponse = WSBuiltInKeywords.sendRequest(createApplicationRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createApplicationResponse, 201)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

