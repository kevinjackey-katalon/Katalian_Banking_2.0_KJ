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

// Step 1: POST /applications with required body
def postRequest = findTestObject('null')
addHeaderConfiguration(postRequest)

def postPayloadMap = [
    accountType: "Checking",
    applicationData: [
        firstName: "John_${uuid}",
        lastName: "Doe_${uuid}",
        middleName: "Michael_${uuid}",
        dob: "1990-05-15",
        address: "123 Main St_${uuid}",
        city: "New York_${uuid}",
        state: "New York_${uuid}",
        zip: "10001",
        initialDeposit: 1000.0
    ]
]

def postPayload = JsonOutput.toJson(postPayloadMap)
postRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(postPayload)))
def postResponse = WSBuiltInKeywords.sendRequest(postRequest)
WSBuiltInKeywords.verifyResponseStatusCode(postResponse, 201)

// Step 3: GET /applications to retrieve list
def getRequest = findTestObject('null')
addHeaderConfiguration(getRequest)
def getResponse = WSBuiltInKeywords.sendRequest(getRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

