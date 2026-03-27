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

def depositRequest = findTestObject('null')
addHeaderConfiguration(depositRequest)

def depositPayloadMap = [
    toAccountId: "non-existent-acc__unique__",
    amount: 100.0
]
def depositPayload = JsonOutput.toJson(depositPayloadMap)
depositRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(depositPayload)))

def depositResponse = WSBuiltInKeywords.sendRequest(depositRequest)
WSBuiltInKeywords.verifyResponseStatusCode(depositResponse, 404)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

