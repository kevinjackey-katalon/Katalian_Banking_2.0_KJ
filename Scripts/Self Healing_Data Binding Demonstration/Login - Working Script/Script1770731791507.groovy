import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.application_domain)

WebUI.navigateToUrl('https://katalian-banking.vercel.app/login')

WebUI.setText(findTestObject('Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_username'), 'bankinguser123')

WebUI.setEncryptedText(findTestObject('Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_password'), 'CS9RmWxFPRFoMJc95WUBEN4WG8mxfTJo')

WebUI.click(findTestObject('Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/button_Enter Vault Access'))

WebUI.closeBrowser()
