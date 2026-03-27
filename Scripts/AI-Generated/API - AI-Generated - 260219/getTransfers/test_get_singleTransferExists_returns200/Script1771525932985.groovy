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

// Step 1: Create two accounts

// Account 1
def account1Payload = [
    id: "acc1__unique__",
    type: "Checking",
    balance: 1000.0,
    accountNumber: "****1234",
    status: "Active"
]
RequestObject createAccount1Request = findTestObject('Object Repository/Katalian Bank API (1)/users/createUser') // No createUser test object provided, so use accounts endpoint test object if exists
// From provided test objects, no accounts create test object is listed, so we create a new RequestObject for accounts POST
// But instructions say to use provided test objects only, so we must create RequestObject from existing test object with endpoint /accounts and method POST
// No such test object is provided in the list, so we must create RequestObject manually for accounts POST

// Since no test object for accounts POST is provided, we create a new RequestObject manually for accounts POST
RequestObject createAccount1 = new RequestObject()
createAccount1.setRestRequestMethod("POST")
createAccount1.setRestUrl("http://localhost:3000/api/accounts")
addHeaderConfiguration(createAccount1)
def account1Body = JsonOutput.toJson(account1Payload)
createAccount1.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(account1Body)))
def createAccount1Response = WSBuiltInKeywords.sendRequest(createAccount1)
WSBuiltInKeywords.verifyResponseStatusCode(createAccount1Response, 201) || WSBuiltInKeywords.verifyResponseStatusCode(createAccount1Response, 200)

// Account 2
def account2Payload = [
    id: "acc2__unique__",
    type: "Savings",
    balance: 500.0,
    accountNumber: "****5678",
    status: "Active"
]
RequestObject createAccount2 = new RequestObject()
createAccount2.setRestRequestMethod("POST")
createAccount2.setRestUrl("http://localhost:3000/api/accounts")
addHeaderConfiguration(createAccount2)
def account2Body = JsonOutput.toJson(account2Payload)
createAccount2.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(account2Body)))
def createAccount2Response = WSBuiltInKeywords.sendRequest(createAccount2)
WSBuiltInKeywords.verifyResponseStatusCode(createAccount2Response, 201) || WSBuiltInKeywords.verifyResponseStatusCode(createAccount2Response, 200)

// Step 2: Create a transfer
def transferPayload = [
    fromAccountId: account1Payload.id,
    toAccountId: account2Payload.id,
    amount: 100.0
]
RequestObject createTransferRequest = findTestObject('null')
addHeaderConfiguration(createTransferRequest)
def transferBody = JsonOutput.toJson(transferPayload)
createTransferRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(transferBody)))
def createTransferResponse = WSBuiltInKeywords.sendRequest(createTransferRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createTransferResponse, 200)
def slurper = new JsonSlurper()
def createdTransfer = slurper.parseText(createTransferResponse.getResponseBodyContent()).transfer

// Step 4: Get list of transfers
RequestObject getTransfersRequest = findTestObject('null')
addHeaderConfiguration(getTransfersRequest)
def getTransfersResponse = WSBuiltInKeywords.sendRequest(getTransfersRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getTransfersResponse, 200)
def transfers = slurper.parseText(getTransfersResponse.getResponseBodyContent())

// Step 5: Verify the list contains exactly one transfer matching the created transfer
def matchingTransfers = transfers.findAll { it.id == createdTransfer.id }
assert matchingTransfers.size() == 1
assert matchingTransfers[0].fromAccountId == transferPayload.fromAccountId
assert matchingTransfers[0].toAccountId == transferPayload.toAccountId
assert matchingTransfers[0].amount == transferPayload.amount

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

