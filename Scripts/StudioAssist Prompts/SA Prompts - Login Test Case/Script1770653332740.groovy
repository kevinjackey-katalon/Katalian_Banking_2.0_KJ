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


/* Login Test Case
1. Launch a new browser instance.
2. Go to https://katalian-banking.vercel.app/login.
3. Enter "bankinguser123" in the username field .
4. Enter "notapassword@123" in the password field 
5. Click on the login button "Enter Vault Access"
6. Verify Successful Login 
*/

/* Generate Test Case
Objective:
Generate a runnable Katalon Studio WebUI test case to validate successful and unsuccessful login for the Katalian Banking demo application.

Project Structure Requirements
1. Test Case Name: Login-01 – Verify Successful and Failed Login
2. Test Case Location: Test Cases/Login/Login-01
3. Use built-in WebUI keywords only and add all relevant includes
4. Store screenshots automatically in the default Katalon Reports folder
5. Do NOT encrypt the entered password

Application Details
1. Open a new session window for https://katalian-banking.vercel.app/login
2. Capture all page objects for this test and place them into the Object Repository/Login folder
3. Close page object capture session window after test script has been created

Test Steps (Execution Flow)
1. Open a new browser instance.
2. Navigate to the login URL.
3. Wait until the login page is fully loaded.
4. Enter username "bankinguser123" into the username field.
5. Enter password "notapassword@123 into the password field
6. Click the Login button.
7. Wait for page navigation to complete.

Verification – Successful Login
1. Verify the current URL contains #appointment
2. Verify the page header (h2) displays the text "Make Appointment"
3. Capture a screenshot of the logged-in state

Error Handling – Failed Login
1. If login fails:
	a. Detect an alert message with CSS class text-danger
	b. Verify the alert text equals: "Login failed! Please ensure the username and password are valid."
	c. Capture a screenshot for failure evidence

*/

/* Update Test Case
Objective
1. Rename an existing Katalon test case from Login-01 – Verify Successful and Failed Login to Login-01 - Verify Login.

Update Instructions
1. Locate the test case named Login-01 – Verify Successful and Failed Login
2. This test case exists under the Test Cases/Login folder
3. Rename only the test case
4. Do not modify:
	a. Test steps
	b. Test logic
	c. Associated objects
	d. Listeners or keywords
5. Ensure all internal references remain intact
6. Do not duplicate the test case
7. Perform a safe rename operation supported by Katalon Studio
8. Preserve version history and execution compatibility

Rename Details
1. Old Test Case Name: Login-01 – Verify Successful and Failed Login
2. New Test Case Name: Login-01 - Verify Login
3. Folder Location (unchanged): Test Cases/Login


Expected Outcome
1. The test case is renamed to Login-01 - Verify Login
2. The test case remains under Test Cases/Login
3. The test case remains fully runnable without any errors
4. No other project artifacts are impacted

*/
