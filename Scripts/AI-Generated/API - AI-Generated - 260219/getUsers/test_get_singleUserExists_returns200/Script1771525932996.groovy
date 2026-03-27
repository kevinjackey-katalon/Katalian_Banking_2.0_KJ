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

// Step 1: Create a user by sending POST /users
def createUserRequest = findTestObject('Object Repository/Katalian Bank API (1)/users/createUser')
def createUserPayloadMap = [
    id: "user1__unique__",
    username: "userone__unique__",
    accounts: []
]
def createUserPayload = JsonOutput.toJson(createUserPayloadMap)
createUserRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(createUserPayload)))
addHeaderConfiguration(createUserRequest)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 201)

// Step 3: Execute GET /users to retrieve all users
def getUsersRequest = findTestObject('null')
addHeaderConfiguration(getUsersRequest)
def getUsersResponse = WSBuiltInKeywords.sendRequest(getUsersRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getUsersResponse, 200)

def slurper = new JsonSlurper()
def users = slurper.parseText(getUsersResponse.getResponseBodyContent())
assert users instanceof List
assert users.size() == 1
def user = users[0]
assert user.id == "user1__unique__"
assert user.username == "userone__unique__"

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

