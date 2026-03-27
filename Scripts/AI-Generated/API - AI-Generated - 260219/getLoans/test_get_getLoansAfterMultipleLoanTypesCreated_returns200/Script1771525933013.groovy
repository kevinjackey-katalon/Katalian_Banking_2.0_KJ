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

// Step 1: Create an auto loan application
def autoLoanPayload = [
    loanType: "Auto",
    loanData: [
        firstName: "Bob__unique__" + uuid,
        lastName: "Smith__unique__" + uuid,
        employer: "Auto Inc",
        jobTitle: "Sales",
        annualIncome: 55000,
        loanAmount: 20000,
        loanTerm: 24,
        purpose: "Car purchase"
    ]
]
RequestObject createAutoLoanRequest = findTestObject('null')
addHeaderConfiguration(createAutoLoanRequest)
def autoLoanBody = JsonOutput.toJson(autoLoanPayload)
createAutoLoanRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(autoLoanBody)))
def createAutoLoanResponse = WSBuiltInKeywords.sendRequest(createAutoLoanRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createAutoLoanResponse, 201)

// Step 2: Create a mortgage loan application
def mortgageLoanPayload = [
    loanType: "Mortgage",
    loanData: [
        firstName: "Carol__unique__" + uuid,
        lastName: "White__unique__" + uuid,
        employer: "Bank Corp",
        jobTitle: "Analyst",
        annualIncome: 120000,
        loanAmount: 300000,
        loanTerm: 36,
        purpose: "Home purchase"
    ]
]
RequestObject createMortgageLoanRequest = findTestObject('null')
addHeaderConfiguration(createMortgageLoanRequest)
def mortgageLoanBody = JsonOutput.toJson(mortgageLoanPayload)
createMortgageLoanRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(mortgageLoanBody)))
def createMortgageLoanResponse = WSBuiltInKeywords.sendRequest(createMortgageLoanRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createMortgageLoanResponse, 201)

// Step 3: Retrieve the list of loans
RequestObject getLoansRequest = findTestObject('null')
addHeaderConfiguration(getLoansRequest)
def getLoansResponse = WSBuiltInKeywords.sendRequest(getLoansRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getLoansResponse, 200)
def slurper = new JsonSlurper()
def loans = slurper.parseText(getLoansResponse.getResponseBodyContent())

// Step 4: Confirm the response contains both the auto and mortgage loans with correct loanType and loanData
boolean autoLoanFound = false
boolean mortgageLoanFound = false

for (loan in loans) {
    if (loan.loanType == "Auto") {
        def ld = loan.loanData ?: [:]
        if (ld.firstName?.startsWith("Bob__unique__") && ld.lastName?.startsWith("Smith__unique__") && ld.loanAmount == 20000 && ld.loanTerm == 24) {
            autoLoanFound = true
        }
    } else if (loan.loanType == "Mortgage") {
        def ld = loan.loanData ?: [:]
        if (ld.firstName?.startsWith("Carol__unique__") && ld.lastName?.startsWith("White__unique__") && ld.loanAmount == 300000 && ld.loanTerm == 36) {
            mortgageLoanFound = true
        }
    }
}

assert autoLoanFound : "Auto loan not found in the list"
assert mortgageLoanFound : "Mortgage loan not found in the list"

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

