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

// Step 1: Create a user by sending POST /users with required fields
def createUserRequest = findTestObject('Object Repository/Katalian Bank API (1)/users/createUser')
if (createUserRequest == null) {
    // Since the provided test objects do not include a POST /users, use the getUsers test object and change method to POST
    createUserRequest = findTestObject('null')
    createUserRequest.setRestRequestMethod("POST")
    createUserRequest.setRestUrl(createUserRequest.getRestUrl())
}
addHeaderConfiguration(createUserRequest)

def createUserPayload = [
    id: "user3__unique__",
    username: "userthree__unique__",
    accounts: [
        [
            id: "acc1__unique__",
            type: "Checking",
            balance: 1000.0,
            accountNumber: "****0001"
        ]
    ]
]
def createUserPayloadJson = JsonOutput.toJson(createUserPayload)
createUserRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(createUserPayloadJson)))

def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 201)

// Step 3: Execute GET /users to retrieve all users
def getUsersRequest = findTestObject('null')
addHeaderConfiguration(getUsersRequest)
def getUsersResponse = WSBuiltInKeywords.sendRequest(getUsersRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getUsersResponse, 200)

// Step 5: Verify the response body contains the user with id 'user3__unique__' and the accounts array with the created account
def slurper = new JsonSlurper()
def users = slurper.parseText(getUsersResponse.getResponseBodyContent())

boolean userFound = false
for (user in users) {
    if (user.id == "user3__unique__") {
        userFound = true
        def accounts = user.accounts ?: []
        boolean accountFound = accounts.any { acc ->
            acc.id == "acc1__unique__" &&
            acc.type == "Checking" &&
            acc.balance == 1000.0 &&
            acc.accountNumber == "****0001"
        }
        assert accountFound
        break
    }
}
assert userFound

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

