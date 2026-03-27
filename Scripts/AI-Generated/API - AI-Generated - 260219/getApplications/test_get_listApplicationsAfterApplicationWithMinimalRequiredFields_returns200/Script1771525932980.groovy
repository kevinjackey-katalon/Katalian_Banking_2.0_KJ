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

// Step 1: POST /applications with minimal required fields
def createApplicationRequest = findTestObject('null')
addHeaderConfiguration(createApplicationRequest)

def postPayloadMap = [
    accountType: "Savings",
    applicationData: [
        firstName: "Eve_" + uuid,
        lastName: "White_" + uuid
    ]
]
def postPayload = JsonOutput.toJson(postPayloadMap)
def postBodyContent = new HttpTextBodyContent(replaceSuffixWithUUID(postPayload))
createApplicationRequest.setBodyContent(postBodyContent)

def postResponse = WSBuiltInKeywords.sendRequest(createApplicationRequest)
WSBuiltInKeywords.verifyResponseStatusCode(postResponse, 201)

// Step 3: GET /applications to retrieve the list of applications
def getApplicationsRequest = findTestObject('null')
addHeaderConfiguration(getApplicationsRequest)

def getResponse = WSBuiltInKeywords.sendRequest(getApplicationsRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

