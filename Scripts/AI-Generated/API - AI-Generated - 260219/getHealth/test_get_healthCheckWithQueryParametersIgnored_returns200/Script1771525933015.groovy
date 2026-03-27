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

def variables = ['test': '1', 'verbose': 'true']
RequestObject getHealthRequest = findTestObject('null', variables)
addHeaderConfiguration(getHealthRequest)

def response = WSBuiltInKeywords.sendRequest(getHealthRequest)
WSBuiltInKeywords.verifyResponseStatusCode(response, 200)

def slurper = new JsonSlurper()
def data = slurper.parseText(response.getResponseBodyContent())

assert data.containsKey('status')
assert data.status in ['ok', 'error']
assert data.containsKey('timestamp')

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

