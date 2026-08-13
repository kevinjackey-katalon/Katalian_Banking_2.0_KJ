import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

String applicationId = '965afb70-e115-4faf-81cf-572c75147350'
String loginUsername = username
String loginPassword = password

try {
    Mobile.startApplication(applicationId, true)

    Mobile.waitForElementPresent(findTestObject('SA Mobile Example/Page_Login/input_username'), 30)
    Mobile.setText(findTestObject('SA Mobile Example/Page_Login/input_username'), loginUsername, 10)

    Mobile.waitForElementPresent(findTestObject('SA Mobile Example/Page_Login/input_password'), 30)
    Mobile.setText(findTestObject('SA Mobile Example/Page_Login/input_password'), loginPassword, 10)
    Mobile.hideKeyboard()

    Mobile.waitForElementPresent(findTestObject('SA Mobile Example/Page_Login/button_login'), 30)
    Mobile.tap(findTestObject('SA Mobile Example/Page_Login/button_login'), 10)

    Mobile.verifyElementExist(findTestObject('SA Mobile Example/Page_Dashboard/label_dashboard_loaded'), 30)
} finally {
    Mobile.closeApplication()
}
