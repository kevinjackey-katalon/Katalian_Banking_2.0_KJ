package truetest.Katalian_Banking_Production.common

import com.kms.katalon.core.testdata.TestData as TestData
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

public class enterSecureIdAndAccessCode {

	private static def execute(String input_accessCode, String input_secureId) {

		"Step 1: Click on input secureId"

		WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'))

		"Step 2: Enter input value in input secureId"

		WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_secureId'), input_secureId)

		"Step 3: Click on input accessCode"

		WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'))

		"Step 4: Enter input value in input accessCode"

		WebUI.setText(findTestObject('AI-Generated/Katalian Banking Production/Page_login/input_accessCode'), input_accessCode)

		"Step 5: Click on button enterVaultAccess"

		WebUI.enhancedClick(findTestObject('AI-Generated/Katalian Banking Production/Page_login/button_enterVaultAccess'))
	}
}

