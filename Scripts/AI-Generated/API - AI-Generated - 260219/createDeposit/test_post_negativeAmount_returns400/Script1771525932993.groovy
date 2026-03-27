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
def createAccountRequest = findTestObject('null')
def accountPayload = [
    id: "acc1-2__unique__",
    type: "Savings",
    balance: 2000.0,
    accountNumber: "****5678"
]
def accountPayloadJson = JsonOutput.toJson(accountPayload)
createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(accountPayloadJson)))
addHeaderConfiguration(createAccountRequest)
def createAccountResponse = WSBuiltInKeywords.sendRequest(createAccountRequest)
assert WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 200) || WSBuiltInKeywords.verifyResponseStatusCode(createAccountResponse, 201)

// Step 2: Execute POST /deposits with negative amount
def createDepositRequest = findTestObject('null')
def depositPayload = [
    toAccountId: "acc1-2__unique__",
    amount: -100.0
]
def depositPayloadJson = JsonOutput.toJson(depositPayload)
createDepositRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(depositPayloadJson)))
addHeaderConfiguration(createDepositRequest)
def createDepositResponse = WSBuiltInKeywords.sendRequest(createDepositRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createDepositResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

