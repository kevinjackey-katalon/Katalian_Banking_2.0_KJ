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

// Step 1: POST /loans to create a personal loan application
def createLoanRequest = findTestObject('null')

def loanRequestPayload = [
    loanType: "Personal",
    loanData: [
        firstName: "Alice" + uuid,
        lastName: "Johnson" + uuid,
        dob: "1985-04-12",
        address: "456 Elm St" + uuid,
        city: "Springfield" + uuid,
        state: "Illinois" + uuid,
        zip: "62704",
        employer: "Retail Corp" + uuid,
        jobTitle: "Manager" + uuid,
        annualIncome: 60000,
        loanAmount: 15000,
        loanTerm: 36,
        purpose: "Debt consolidation" + uuid
    ]
]

def loanRequestBody = JsonOutput.toJson(loanRequestPayload)
createLoanRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(loanRequestBody)))
addHeaderConfiguration(createLoanRequest)

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

// Step 3: Confirm the response contains the created personal loan with correct loanType and loanData
boolean found = false
for (loan in loansList) {
    if (loan.id == createdLoan.id) {
        if (loan.loanType == "Personal") {
            def loanData = loan.loanData ?: [:]
            if (loanData.firstName == "Alice" + uuid &&
                loanData.lastName == "Johnson" + uuid &&
                loanData.dob == "1985-04-12" &&
                loanData.address == "456 Elm St" + uuid &&
                loanData.city == "Springfield" + uuid &&
                loanData.state == "Illinois" + uuid &&
                loanData.zip == "62704" &&
                loanData.employer == "Retail Corp" + uuid &&
                loanData.jobTitle == "Manager" + uuid &&
                loanData.annualIncome == 60000 &&
                loanData.loanAmount == 15000 &&
                loanData.loanTerm == 36 &&
                loanData.purpose == "Debt consolidation" + uuid) {
                found = true
                break
            }
        }
    }
}

assert found : "Created personal loan not found or data mismatch in loans list"

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

