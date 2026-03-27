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
    // fallback to create a new RequestObject if not found in repository
    createAccountRequest = new RequestObject('createAccount')
    createAccountRequest.setRestRequestMethod('POST')
    createAccountRequest.setRestUrl('http://localhost:3000/api/accounts')
}
addHeaderConfiguration(createAccountRequest)

def accountPayload = [
    id: "acc1-1",
    type: "Checking",
    balance: 5000.0,
    accountNumber: "****1234"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))

def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 201)

// Step 2: Prepare ApplicationData inline in Application request
def applicationData = [
    firstName: "John__${uuid}__",
    lastName: "Doe__${uuid}__",
    middleName: "Michael__${uuid}__",
    dob: "1990-05-15",
    address: "123 Main St__${uuid}__",
    city: "New York__${uuid}__",
    state: "New York__${uuid}__",
    zip: "10001",
    initialDeposit: 1000.0,
    depositFromAccountId: "acc1-1"
]

// Step 3: Submit Application
def createApplicationRequest = findTestObject('null')
addHeaderConfiguration(createApplicationRequest)

def applicationPayload = [
    accountType: "Checking",
    applicationData: applicationData
]
def applicationPayloadJson = JsonOutput.toJson(applicationPayload)
createApplicationRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(applicationPayloadJson)))

def createApplicationResponse = WSBuiltInKeywords.sendRequest(createApplicationRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createApplicationResponse, 201)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

