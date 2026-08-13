
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

// ─────────────────────────────────────────────────────────────────────────────
// PRECONDITION: Authenticate via login page (TC-17997970)
// URL:      https://katalian-banking.vercel.app/login
// Username: bankinguser123
// Password: notapassword@123
// ─────────────────────────────────────────────────────────────────────────────
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
WebUI.delay(3)

// ─────────────────────────────────────────────────────────────────────────────
// STEP 1: Navigate to the dashboard
// Expected: Dashboard page loads successfully for the authenticated user
// ─────────────────────────────────────────────────────────────────────────────
WebUI.verifyElementPresent(
    findTestObject('Object Repository/02 - Demo Materials - External AI/Claude Desktop Demo/Page_Dashboard/div_dashboard_container'),
    15,
    FailureHandling.STOP_ON_FAILURE
)

String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*dashboard.*', true, FailureHandling.STOP_ON_FAILURE)

// ─────────────────────────────────────────────────────────────────────────────
// STEP 2: Locate the Net Liquidity section
// Expected: Net Liquidity section is present on the page
// ─────────────────────────────────────────────────────────────────────────────
WebUI.verifyElementPresent(
    findTestObject('Object Repository/02 - Demo Materials - External AI/Claude Desktop Demo/Page_Dashboard/section_net_liquidity_heading'),
    15,
    FailureHandling.STOP_ON_FAILURE
)

// ─────────────────────────────────────────────────────────────────────────────
// STEP 3: Verify the Net Liquidity label is displayed
// Expected: The text 'Net Liquidity' label is visible in the section
// ─────────────────────────────────────────────────────────────────────────────
WebUI.verifyElementVisible(
    findTestObject('Object Repository/02 - Demo Materials - External AI/Claude Desktop Demo/Page_Dashboard/section_net_liquidity_heading'),
    FailureHandling.STOP_ON_FAILURE
)

WebUI.closeBrowser()
