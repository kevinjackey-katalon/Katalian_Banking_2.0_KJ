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

def loanRequest = [
    loanType: "Mortgage",
    loanData: [
        firstName: "Bob_" + uuid,
        lastName: "Wilson_" + uuid,
        loanAmount: -50000,
        loanTerm: 36
    ]
]

RequestObject createLoanRequest = findTestObject('null')
addHeaderConfiguration(createLoanRequest)

String bodyContent = JsonOutput.toJson(loanRequest)
createLoanRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(bodyContent)))

def response = WSBuiltInKeywords.sendRequest(createLoanRequest)
WSBuiltInKeywords.verifyResponseStatusCode(response, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

