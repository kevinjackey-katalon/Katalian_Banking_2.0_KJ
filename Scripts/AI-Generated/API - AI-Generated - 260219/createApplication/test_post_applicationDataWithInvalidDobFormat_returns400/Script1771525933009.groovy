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
def accountPayload = [
    id           : "acc5-1__unique__",
    type         : "Savings",
    balance      : 2000.0,
    accountNumber: "****9999"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))
addHeaderConfiguration(createAccountRequest)
def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 201)

// Step 2: Submit Application with invalid dob format
def createApplicationRequest = findTestObject('null')
def applicationPayload = [
    accountType     : "Savings",
    applicationData : [
        firstName: "Eve__unique__",
        lastName : "Adams__unique__",
        dob      : "15-05-1990"
    ]
]
def applicationPayloadJson = JsonOutput.toJson(applicationPayload)
createApplicationRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(applicationPayloadJson)))
addHeaderConfiguration(createApplicationRequest)
def createApplicationResponse = WSBuiltInKeywords.sendRequest(createApplicationRequest)

// Step 3: Verify response status 400
WSBuiltInKeywords.verifyResponseStatusCode(createApplicationResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

