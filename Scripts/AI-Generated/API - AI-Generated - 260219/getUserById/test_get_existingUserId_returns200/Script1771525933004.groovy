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

// Step 1: Create a new user
def user_id = "user1__unique__"
def user_payload = [
    id: user_id,
    username: "username__unique__",
    accounts: []
]
def createUserRequest = findTestObject('Object Repository/Katalian Bank API (1)/users/createUser')
if (createUserRequest == null) {
    // Since createUser test object is not provided, use the getUsers test object and change method and endpoint accordingly
    createUserRequest = findTestObject('null')
    createUserRequest.setRestRequestMethod("POST")
    createUserRequest.setRestUrl(createUserRequest.getRestUrl())
}
addHeaderConfiguration(createUserRequest)
def userPayloadJson = JsonOutput.toJson(user_payload)
def bodyContent = new HttpTextBodyContent(replaceSuffixWithUUID(userPayloadJson))
createUserRequest.setBodyContent(bodyContent)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 201)

// Step 2: Retrieve the created user
def variables = ['id': user_id]
def getUserRequest = findTestObject('null', variables)
addHeaderConfiguration(getUserRequest)
def getUserResponse = WSBuiltInKeywords.sendRequest(getUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getUserResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

