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

// Step 1: Create account
def createAccountRequest = findTestObject('null')
def accountPayload = [
    id: "acc1-3__unique__",
    type: "Checking",
    balance: 1000.0,
    accountNumber: "****3333",
    status: "Active"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))
addHeaderConfiguration(createAccountRequest)
def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 200)

// Step 2: Execute transfer to the same account
def createTransferRequest = findTestObject('null')
def transferPayload = [
    fromAccountId: "acc1-3__unique__",
    toAccountId: "acc1-3__unique__",
    amount: 50.0
]
def transferPayloadJson = JsonOutput.toJson(transferPayload)
createTransferRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(transferPayloadJson)))
addHeaderConfiguration(createTransferRequest)
def createTransferResponse = WSBuiltInKeywords.sendRequest(createTransferRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createTransferResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

