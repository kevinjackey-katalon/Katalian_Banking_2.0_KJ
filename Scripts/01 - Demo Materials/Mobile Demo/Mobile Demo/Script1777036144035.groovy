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

// Step 1: Start the mobile application (fresh install / reset app state)
Mobile.startApplication('207ca014-66dd-4231-a989-aad15dd5866c', true)
Mobile.verifyElementExist(findTestObject('Mobile Demo/XCUIElementTypeStaticText - Mexican'), 30)

// Step 2: Select the "Mexican" option from the list
Mobile.tap(findTestObject('Mobile Demo/XCUIElementTypeStaticText - Mexican'), 10)

// Step 3: Tap "Start" to begin the demo flow
Mobile.tap(findTestObject('Mobile Demo/XCUIElementTypeButton - Start'), 20)

// Step 4: Tap "Stop" to end/stop the running action
Mobile.tap(findTestObject('Mobile Demo/XCUIElementTypeButton - Stop'), 20)

// Step 5: Tap "Back" to return to the previous screen
Mobile.tap(findTestObject('Mobile Demo/XCUIElementTypeButton - Back'), 10)

// Step 6: Close the application
Mobile.closeApplication()
