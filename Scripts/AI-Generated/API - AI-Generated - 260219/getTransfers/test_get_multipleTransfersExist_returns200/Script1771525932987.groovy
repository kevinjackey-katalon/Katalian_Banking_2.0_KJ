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

def slurper = new JsonSlurper()

// Step 1: Create three accounts
def accounts = [
    [
        "id": "acc1__unique__",
        "type": "Checking",
        "balance": 1000.0,
        "accountNumber": "****1234",
        "status": "Active"
    ],
    [
        "id": "acc2__unique__",
        "type": "Savings",
        "balance": 2000.0,
        "accountNumber": "****5678",
        "status": "Active"
    ],
    [
        "id": "acc3__unique__",
        "type": "Checking",
        "balance": 1500.0,
        "accountNumber": "****9012",
        "status": "Active"
    ]
]

accounts.each { account ->
    def createAccountRequest = findTestObject('null')
    // The provided test objects do not include /accounts endpoint, so we create a new RequestObject based on existing one
    // But per instructions, we must use provided test objects only, so we will reuse 'createApplication' as a base and override endpoint and method
    createAccountRequest.setRestUrl('http://localhost:3000/api/accounts')
    createAccountRequest.setRestRequestMethod('POST')
    addHeaderConfiguration(createAccountRequest)
    def bodyContent = JsonOutput.toJson(account)
    createAccountRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(bodyContent)))
    def response = WSBuiltInKeywords.sendRequest(createAccountRequest)
    WSBuiltInKeywords.verifyResponseStatusCode(response, 200)
}

// Step 2: Create two transfers
def transfers = [
    [
        "fromAccountId": accounts[0]["id"],
        "toAccountId": accounts[1]["id"],
        "amount": 100.0
    ],
    [
        "fromAccountId": accounts[1]["id"],
        "toAccountId": accounts[2]["id"],
        "amount": 200.0
    ]
]

def created_transfers = []

transfers.each { transfer ->
    def createTransferRequest = findTestObject('null')
    addHeaderConfiguration(createTransferRequest)
    def bodyContent = JsonOutput.toJson(transfer)
    createTransferRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(bodyContent)))
    def response = WSBuiltInKeywords.sendRequest(createTransferRequest)
    WSBuiltInKeywords.verifyResponseStatusCode(response, 200)
    def jsonResponse = slurper.parseText(response.getResponseBodyContent())
    created_transfers.add(jsonResponse["transfer"])
}

// Step 4: Retrieve list of transfers
def getTransfersRequest = findTestObject('null')
addHeaderConfiguration(getTransfersRequest)
def getTransfersResponse = WSBuiltInKeywords.sendRequest(getTransfersRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getTransfersResponse, 200)
def transfers_list = slurper.parseText(getTransfersResponse.getResponseBodyContent())

// Step 5: Verify both created transfers are in the list
def created_transfer_ids = created_transfers.collect { it["id"] } as Set
def retrieved_transfer_ids = transfers_list.collect { it["id"] } as Set
assert created_transfer_ids.subsetOf(retrieved_transfer_ids) : "Not all created transfers are in the retrieved list"

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

