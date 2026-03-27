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
    // Since the provided test objects do not include createAccount, create a new RequestObject manually
    createAccountRequest = new RequestObject('createAccount')
    createAccountRequest.setRestRequestMethod('POST')
    createAccountRequest.setRestUrl('http://localhost:3000/api/accounts')
}
addHeaderConfiguration(createAccountRequest)

def accountPayload = [
    id: "acc2-1__unique__",
    type: "Savings",
    balance: 3000.0,
    accountNumber: "****5678"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))

def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 201)

// Step 2: Submit Application with missing required fields firstName and lastName
def createApplicationRequest = findTestObject('null')
addHeaderConfiguration(createApplicationRequest)

def applicationPayload = [
    accountType: "Savings",
    applicationData: [:]
]
def applicationPayloadJson = JsonOutput.toJson(applicationPayload)
createApplicationRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(applicationPayloadJson)))

def createApplicationResponse = WSBuiltInKeywords.sendRequest(createApplicationRequest)

// Step 3: Verify response status 400
WSBuiltInKeywords.verifyResponseStatusCode(createApplicationResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

