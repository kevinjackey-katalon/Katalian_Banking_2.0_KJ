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

def createLoanRequest = findTestObject('null')

def requestBody = [
    loanType: "Personal",
    loanData: [
        firstName: "Eve__${uuid}__",
        lastName: "Davis__${uuid}__",
        loanAmount: 8000,
        loanTerm: 18
    ]
]

def jsonBody = JsonOutput.toJson(requestBody)
def bodyContent = new HttpTextBodyContent(replaceSuffixWithUUID(jsonBody))

createLoanRequest.setBodyContent(bodyContent)
addHeaderConfiguration(createLoanRequest)

def createLoanResponse = WSBuiltInKeywords.sendRequest(createLoanRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createLoanResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

