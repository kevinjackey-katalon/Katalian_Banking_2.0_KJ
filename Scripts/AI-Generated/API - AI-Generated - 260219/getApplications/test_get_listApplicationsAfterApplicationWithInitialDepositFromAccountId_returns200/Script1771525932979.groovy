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

// Step 1: Create an Account resource
def createAccountRequest = findTestObject('Object Repository/Katalian Bank API (1)/accounts/createAccount')
def accountPayload = [
    id           : "acc-123",
    type         : "Checking",
    balance      : 5000.0,
    accountNumber: "****1234",
    status       : "Active"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))
addHeaderConfiguration(createAccountRequest)
def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 201)

// Step 3: Create an Application with initialDeposit and depositFromAccountId
def createApplicationRequest = findTestObject('null')
def applicationPayload = [
    accountType     : "Checking",
    applicationData : [
        firstName           : "Frank__unique__",
        lastName            : "Green__unique__",
        initialDeposit      : 2000.0,
        depositFromAccountId: "acc-123"
    ]
]
def applicationPayloadJson = JsonOutput.toJson(applicationPayload)
createApplicationRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(applicationPayloadJson)))
addHeaderConfiguration(createApplicationRequest)
def createApplicationResponse = WSBuiltInKeywords.sendRequest(createApplicationRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createApplicationResponse, 201)

// Step 5: Get list of applications
def getApplicationsRequest = findTestObject('null')
addHeaderConfiguration(getApplicationsRequest)
def getApplicationsResponse = WSBuiltInKeywords.sendRequest(getApplicationsRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getApplicationsResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

