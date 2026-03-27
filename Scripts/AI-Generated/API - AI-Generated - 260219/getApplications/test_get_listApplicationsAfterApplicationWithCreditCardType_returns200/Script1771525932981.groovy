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

// Step 1: POST /applications with minimal required fields for Credit Card application
def postRequest = findTestObject('null')
addHeaderConfiguration(postRequest)

def postPayloadMap = [
    accountType: "Credit Card",
    applicationData: [
        firstName: "Grace" + uuid,
        lastName: "Hopper" + uuid,
        dob: "1906-12-09",
        address: "789 Tech Rd",
        city: "Arlington",
        state: "Virginia",
        zip: "22201"
    ]
]
def postPayload = JsonOutput.toJson(postPayloadMap)
postRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(postPayload)))

def postResponse = WSBuiltInKeywords.sendRequest(postRequest)
WSBuiltInKeywords.verifyResponseStatusCode(postResponse, 201)

// Step 3: GET /applications to retrieve the list of applications
def getRequest = findTestObject('null')
addHeaderConfiguration(getRequest)

def getResponse = WSBuiltInKeywords.sendRequest(getRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

