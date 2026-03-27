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

// Step 1: Create source account
def sourceAccountRequest = findTestObject('null')
sourceAccountRequest.setRestUrl('http://localhost:3000/api/accounts')
sourceAccountRequest.setRestRequestMethod('POST')
addHeaderConfiguration(sourceAccountRequest)
def sourceAccountPayload = [
    id: "acc1-4__unique__",
    type: "Savings",
    balance: 1000.0,
    accountNumber: "****4444",
    status: "Active"
]
sourceAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(sourceAccountPayload))))
def sourceAccountResponse = WSBuiltInKeywords.sendRequest(sourceAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(sourceAccountResponse, 200)

// Step 2: Create destination account
def destinationAccountRequest = findTestObject('null')
destinationAccountRequest.setRestUrl('http://localhost:3000/api/accounts')
destinationAccountRequest.setRestRequestMethod('POST')
addHeaderConfiguration(destinationAccountRequest)
def destinationAccountPayload = [
    id: "acc1-5__unique__",
    type: "Checking",
    balance: 500.0,
    accountNumber: "****5555",
    status: "Active"
]
destinationAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(destinationAccountPayload))))
def destinationAccountResponse = WSBuiltInKeywords.sendRequest(destinationAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(destinationAccountResponse, 200)

// Step 3: Execute transfer with negative amount
def transferRequest = findTestObject('null')
addHeaderConfiguration(transferRequest)
def transferPayload = [
    fromAccountId: "acc1-4__unique__",
    toAccountId: "acc1-5__unique__",
    amount: -10.0
]
transferRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(transferPayload))))
def transferResponse = WSBuiltInKeywords.sendRequest(transferRequest)
WSBuiltInKeywords.verifyResponseStatusCode(transferResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

