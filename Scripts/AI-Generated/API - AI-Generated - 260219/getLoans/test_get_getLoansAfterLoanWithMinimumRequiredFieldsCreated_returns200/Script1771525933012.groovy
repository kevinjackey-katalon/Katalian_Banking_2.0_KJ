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

// Step 1: POST /loans with minimal required fields
def createLoanRequest = findTestObject('null')
addHeaderConfiguration(createLoanRequest)

def loanRequestPayload = [
    loanType: "Personal",
    loanData: [
        firstName: "David__unique__",
        lastName: "Brown__unique__",
        loanAmount: 5000,
        loanTerm: 12
    ]
]

def loanRequestBody = JsonOutput.toJson(loanRequestPayload)
createLoanRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(loanRequestBody)))

def responsePost = WSBuiltInKeywords.sendRequest(createLoanRequest)
WSBuiltInKeywords.verifyResponseStatusCode(responsePost, 201)

def slurper = new JsonSlurper()
def createdLoan = slurper.parseText(responsePost.getResponseBodyContent())

// Step 2: GET /loans to retrieve the list of loans
def getLoansRequest = findTestObject('null')
addHeaderConfiguration(getLoansRequest)

def responseGet = WSBuiltInKeywords.sendRequest(getLoansRequest)
WSBuiltInKeywords.verifyResponseStatusCode(responseGet, 200)

def loansList = slurper.parseText(responseGet.getResponseBodyContent())

// Step 3: Confirm the response contains the created loan with correct minimal loanData
boolean found = false
for (loan in loansList) {
    if (loan.id == createdLoan.id) {
        found = true
        def loanData = loan.loanData ?: [:]
        assert loan.loanType == "Personal" : "Expected loanType 'Personal', got ${loan.loanType}"
        assert loanData.firstName == "David__unique__" : "Expected firstName 'David__unique__', got ${loanData.firstName}"
        assert loanData.lastName == "Brown__unique__" : "Expected lastName 'Brown__unique__', got ${loanData.lastName}"
        assert loanData.loanAmount == 5000 : "Expected loanAmount 5000, got ${loanData.loanAmount}"
        assert loanData.loanTerm == 12 : "Expected loanTerm 12, got ${loanData.loanTerm}"
        break
    }
}

assert found : "Created loan not found in the loans list"

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

