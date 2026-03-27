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

// Step 1: Create first mortgage loan application
def createLoanRequest1 = findTestObject('null')
addHeaderConfiguration(createLoanRequest1)
def loan1Payload = [
    loanType: "Mortgage",
    loanData: [
        firstName: "Eve__unique__",
        lastName: "Davis__unique__",
        employer: "Realty LLC",
        jobTitle: "Agent",
        annualIncome: 90000,
        loanAmount: 250000,
        loanTerm: 36,
        purpose: "Investment property"
    ]
]
def loan1Body = JsonOutput.toJson(loan1Payload)
createLoanRequest1.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(loan1Body)))
def response1 = WSBuiltInKeywords.sendRequest(createLoanRequest1)
WSBuiltInKeywords.verifyResponseStatusCode(response1, 201)

// Step 2: Create second mortgage loan application
def createLoanRequest2 = findTestObject('null')
addHeaderConfiguration(createLoanRequest2)
def loan2Payload = [
    loanType: "Mortgage",
    loanData: [
        firstName: "Frank__unique__",
        lastName: "Miller__unique__",
        employer: "Construction Co",
        jobTitle: "Engineer",
        annualIncome: 110000,
        loanAmount: 400000,
        loanTerm: 36,
        purpose: "Primary residence"
    ]
]
def loan2Body = JsonOutput.toJson(loan2Payload)
createLoanRequest2.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(loan2Body)))
def response2 = WSBuiltInKeywords.sendRequest(createLoanRequest2)
WSBuiltInKeywords.verifyResponseStatusCode(response2, 201)

// Step 3: Retrieve the list of loans
def getLoansRequest = findTestObject('null')
addHeaderConfiguration(getLoansRequest)
def response3 = WSBuiltInKeywords.sendRequest(getLoansRequest)
WSBuiltInKeywords.verifyResponseStatusCode(response3, 200)

// Step 4: Confirm the response contains both mortgage loans with correct loanType and loanData
def slurper = new JsonSlurper()
def loans = slurper.parseText(response3.getResponseBodyContent())
def mortgageLoans = loans.findAll { it.loanType == "Mortgage" }

assert mortgageLoans.any { loan ->
    loan.loanData?.firstName == "Eve__unique__" &&
    loan.loanData?.lastName == "Davis__unique__" &&
    loan.loanData?.loanAmount == 250000 &&
    loan.loanData?.loanTerm == 36
} : "First mortgage loan not found or data mismatch"

assert mortgageLoans.any { loan ->
    loan.loanData?.firstName == "Frank__unique__" &&
    loan.loanData?.lastName == "Miller__unique__" &&
    loan.loanData?.loanAmount == 400000 &&
    loan.loanData?.loanTerm == 36
} : "Second mortgage loan not found or data mismatch"

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

