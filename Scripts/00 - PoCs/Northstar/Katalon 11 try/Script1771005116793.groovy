import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startApplication('8e591f30-12c6-4fb3-ab50-074aad51370e', true)

Mobile.tap(findTestObject('android.widget.Button - Continue to Login'), 660)

Mobile.setText(findTestObject('android.widget.EditText'), '0001', 60)

Mobile.setText(findTestObject('android.widget.EditText (1)'), '123456', 60)

Mobile.tap(findTestObject('android.widget.Button - Sign In'), 60)

Mobile.tap(findTestObject('android.widget.Button - Allow'), 60)

Mobile.tap(findTestObject('android.widget.Button - NOT NOW'), 60)

Mobile.tap(findTestObject('null'), 60)

Mobile.tap(findTestObject('android.widget.ImageView'), 60)

Mobile.closeApplication()

