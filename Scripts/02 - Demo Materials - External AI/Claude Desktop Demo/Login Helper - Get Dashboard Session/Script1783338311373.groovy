
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

WebUI.openBrowser('https://katalian-banking.vercel.app/login')
WebUI.waitForPageLoad(10)
WebUI.setText(
    findTestObject('Object Repository/01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_Secure ID_username'),
    'bankinguser123',
    FailureHandling.STOP_ON_FAILURE
)
WebUI.setText(
    findTestObject('Object Repository/01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_Access Code_password'),
    'notapassword@123',
    FailureHandling.STOP_ON_FAILURE
)
WebUI.click(
    findTestObject('Object Repository/02 - Demo Materials - External AI/Claude Desktop Demo/Page_Login/button_Enter Vault Access'),
    FailureHandling.STOP_ON_FAILURE
)
WebUI.waitForPageLoad(15)
WebUI.delay(30)
