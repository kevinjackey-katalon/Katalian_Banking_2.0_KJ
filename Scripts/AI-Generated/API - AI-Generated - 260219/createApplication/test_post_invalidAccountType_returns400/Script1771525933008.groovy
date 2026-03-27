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
def createAccountRequest = findTestObject('Katalian Bank API (1)/accounts/createAccount')
if (createAccountRequest == null) {
    // Since the provided test objects do not include /accounts POST, create a new RequestObject manually
    createAccountRequest = new RequestObject('createAccount')
    createAccountRequest.setRestRequestMethod('POST')
    createAccountRequest.setRestUrl('http://localhost:3000/api/accounts')
}
addHeaderConfiguration(createAccountRequest)

def accountPayload = [
    id: "acc3-1",
    type: "Checking",
    balance: 4000.0,
    accountNumber: "****4321"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))

def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 201)

// Step 2: Submit Application with invalid accountType
def createApplicationRequest = findTestObject('null')
addHeaderConfiguration(createApplicationRequest)

def applicationPayload = [
    accountType: "InvalidType",
    applicationData: [
        firstName: "Alice__unique__",
        lastName: "Brown__unique__"
    ]
]
def applicationPayloadJson = JsonOutput.toJson(applicationPayload)
createApplicationRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(applicationPayloadJson)))

def createApplicationResponse = WSBuiltInKeywords.sendRequest(createApplicationRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createApplicationResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

