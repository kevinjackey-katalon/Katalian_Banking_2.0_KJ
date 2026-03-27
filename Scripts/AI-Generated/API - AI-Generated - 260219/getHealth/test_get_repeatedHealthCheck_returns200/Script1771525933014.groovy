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

RequestObject getHealthRequest1 = findTestObject('null')
addHeaderConfiguration(getHealthRequest1)
def response1 = WSBuiltInKeywords.sendRequest(getHealthRequest1)
WSBuiltInKeywords.verifyResponseStatusCode(response1, 200)

RequestObject getHealthRequest2 = findTestObject('null')
addHeaderConfiguration(getHealthRequest2)
def response2 = WSBuiltInKeywords.sendRequest(getHealthRequest2)
WSBuiltInKeywords.verifyResponseStatusCode(response2, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

