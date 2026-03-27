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

// Step 1: Create a user with id 'user4', username 'userfour', accounts [], locked true
def createUserRequest = findTestObject('Object Repository/Katalian Bank API (1)/users/createUser')
if (createUserRequest == null) {
    // If createUser test object does not exist, use the getUsers test object and change method and endpoint accordingly
    createUserRequest = findTestObject('null')
    createUserRequest.setRestRequestMethod("POST")
    createUserRequest.setRestUrl(createUserRequest.getRestUrl().replace("/users", "/users"))
}
addHeaderConfiguration(createUserRequest)

def createUserPayloadMap = [
    id      : "user4__unique__",
    username: "userfour__unique__",
    accounts: [],
    locked  : true
]
def createUserPayload = JsonOutput.toJson(createUserPayloadMap)
createUserRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(createUserPayload)))

def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 201)

// Step 3: Execute GET /users to retrieve all users
def getUsersRequest = findTestObject('null')
addHeaderConfiguration(getUsersRequest)
def getUsersResponse = WSBuiltInKeywords.sendRequest(getUsersRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getUsersResponse, 200)

// Step 5: Verify the response body contains the user with id 'user4' and locked status true
def slurper = new JsonSlurper()
def users = slurper.parseText(getUsersResponse.getResponseBodyContent())
def user4 = users.find { it.id == "user4__unique__" }
assert user4 != null : "User with id 'user4' not found in users list"
assert user4.locked == true : "User 'user4' locked status is not True"

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

