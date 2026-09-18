import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.openBrowser(GlobalVariable.application_domain)

WebUI.navigateToUrl('https://katalian-banking.vercel.app/login')

WebUI.setText(findTestObject('01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_username'), username)

WebUI.setText(findTestObject('01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_password'), password)

WebUI.click(findTestObject('01 - Demo Materials - Manual/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/button_Enter Vault Access'))

WebUI.closeBrowser()
