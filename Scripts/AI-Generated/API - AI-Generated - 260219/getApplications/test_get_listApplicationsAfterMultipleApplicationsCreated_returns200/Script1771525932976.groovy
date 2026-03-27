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

// Step 1: POST /applications with Checking account application
def createApplicationRequest1 = findTestObject('null')
addHeaderConfiguration(createApplicationRequest1)
def payload1 = [
    accountType: "Checking",
    applicationData: [
        firstName: "Alice_${uuid}",
        lastName: "Brown_${uuid}",
        initialDeposit: 1500.0
    ]
]
def bodyContent1 = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(payload1)))
createApplicationRequest1.setBodyContent(bodyContent1)
def response1 = WSBuiltInKeywords.sendRequest(createApplicationRequest1)
WSBuiltInKeywords.verifyResponseStatusCode(response1, 201)

// Step 3: POST /applications with Savings account application
def createApplicationRequest2 = findTestObject('null')
addHeaderConfiguration(createApplicationRequest2)
def payload2 = [
    accountType: "Savings",
    applicationData: [
        firstName: "Bob_${uuid}",
        lastName: "Smith_${uuid}",
        initialDeposit: 3000.0
    ]
]
def bodyContent2 = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(payload2)))
createApplicationRequest2.setBodyContent(bodyContent2)
def response2 = WSBuiltInKeywords.sendRequest(createApplicationRequest2)
WSBuiltInKeywords.verifyResponseStatusCode(response2, 201)

// Step 5: POST /applications with Credit Card application
def createApplicationRequest3 = findTestObject('null')
addHeaderConfiguration(createApplicationRequest3)
def payload3 = [
    accountType: "Credit Card",
    applicationData: [
        firstName: "Carol_${uuid}",
        lastName: "Jones_${uuid}",
        dob: "1985-08-20",
        address: "456 Oak Ave",
        city: "Los Angeles",
        state: "California",
        zip: "90001"
    ]
]
def bodyContent3 = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(payload3)))
createApplicationRequest3.setBodyContent(bodyContent3)
def response3 = WSBuiltInKeywords.sendRequest(createApplicationRequest3)
WSBuiltInKeywords.verifyResponseStatusCode(response3, 201)

// Step 7: GET /applications to retrieve all applications
def getApplicationsRequest = findTestObject('null')
addHeaderConfiguration(getApplicationsRequest)
def response4 = WSBuiltInKeywords.sendRequest(getApplicationsRequest)
WSBuiltInKeywords.verifyResponseStatusCode(response4, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

