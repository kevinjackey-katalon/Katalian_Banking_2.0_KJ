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

def loanRequestBody = [
    loanType: "Personal",
    loanData: [
        firstName: "John" + uuid,
        lastName: "Doe" + uuid,
        loanAmount: 10000,
        loanTerm: 36
    ]
]

RequestObject createLoanRequest = findTestObject('null')
addHeaderConfiguration(createLoanRequest)

def jsonBody = JsonOutput.toJson(loanRequestBody)
def bodyContent = new HttpTextBodyContent(replaceSuffixWithUUID(jsonBody))
createLoanRequest.setBodyContent(bodyContent)

def createLoanResponse = WSBuiltInKeywords.sendRequest(createLoanRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createLoanResponse, 201)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

