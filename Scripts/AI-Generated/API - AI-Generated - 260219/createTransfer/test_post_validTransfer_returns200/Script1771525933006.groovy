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
def sourceAccountPayload = [
    id: "acc1-1__unique__",
    type: "Checking",
    balance: 1000.0,
    accountNumber: "****1111",
    status: "Active"
]
def sourceAccountBody = JsonOutput.toJson(sourceAccountPayload)
sourceAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(sourceAccountBody)))
addHeaderConfiguration(sourceAccountRequest)
def sourceAccountResponse = WSBuiltInKeywords.sendRequest(sourceAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(sourceAccountResponse, 200)

// Step 2: Create destination account
def destinationAccountRequest = findTestObject('null')
def destinationAccountPayload = [
    id: "acc1-2__unique__",
    type: "Savings",
    balance: 500.0,
    accountNumber: "****2222",
    status: "Active"
]
def destinationAccountBody = JsonOutput.toJson(destinationAccountPayload)
destinationAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(destinationAccountBody)))
addHeaderConfiguration(destinationAccountRequest)
def destinationAccountResponse = WSBuiltInKeywords.sendRequest(destinationAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(destinationAccountResponse, 200)

// Step 3: Execute transfer
def transferRequest = findTestObject('null')
def transferPayload = [
    fromAccountId: "acc1-1__unique__",
    toAccountId: "acc1-2__unique__",
    amount: 100.0
]
def transferBody = JsonOutput.toJson(transferPayload)
transferRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(transferBody)))
addHeaderConfiguration(transferRequest)
def transferResponse = WSBuiltInKeywords.sendRequest(transferRequest)
WSBuiltInKeywords.verifyResponseStatusCode(transferResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

