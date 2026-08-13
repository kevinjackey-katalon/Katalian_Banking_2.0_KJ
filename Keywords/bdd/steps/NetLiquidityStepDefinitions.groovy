package bdd.steps

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import cucumber.api.java.en.And

public class NetLiquidityStepDefinitions {

    // ─────────────────────────────────────────────────────────────────────────
    // BACKGROUND / PRECONDITION STEPS
    // ─────────────────────────────────────────────────────────────────────────

    @Given("I navigate to the login page at {string}")
    def navigateToLoginPage(String url) {
        WebUI.openBrowser(url)
        WebUI.waitForPageLoad(10)
    }

    @And("I enter username {string}")
    def enterUsername(String username) {
        WebUI.setText(
            findTestObject('Object Repository/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_Secure ID_username'),
            username,
            FailureHandling.STOP_ON_FAILURE
        )
    }

    @And("I enter password {string}")
    def enterPassword(String password) {
        WebUI.setText(
            findTestObject('Object Repository/Self-Healing Objects/Page_Katalian Bank  Private Wealth Management/input_Access Code_password'),
            password,
            FailureHandling.STOP_ON_FAILURE
        )
    }

    @And("I click the login button")
    def clickLoginButton() {
        WebUI.click(
            findTestObject('Object Repository/Claude demo - June 26/Page_Login/button_Enter Vault Access'),
            FailureHandling.STOP_ON_FAILURE
        )
    }

    @And("I wait for the dashboard to load")
    def waitForDashboard() {
        WebUI.waitForPageLoad(15)
        WebUI.delay(3)
    }

    // ─────────────────────────────────────────────────────────────────────────
    // SCENARIO STEPS
    // ─────────────────────────────────────────────────────────────────────────

    @When("I navigate to the dashboard")
    def navigateToDashboard() {
        // Already on dashboard after login — verify URL
        String currentUrl = WebUI.getUrl()
        WebUI.verifyMatch(currentUrl, '.*dashboard.*', true, FailureHandling.STOP_ON_FAILURE)
    }

    @Then("the dashboard page should load successfully")
    def dashboardPageLoadsSuccessfully() {
        WebUI.verifyElementPresent(
            findTestObject('Object Repository/Claude demo - June 26/Page_Dashboard/div_dashboard_container'),
            15,
            FailureHandling.STOP_ON_FAILURE
        )
    }

    @And("the Net Liquidity section should be present on the page")
    def netLiquiditySectionIsPresent() {
        WebUI.verifyElementPresent(
            findTestObject('Object Repository/Claude demo - June 26/Page_Dashboard/section_net_liquidity_heading'),
            15,
            FailureHandling.STOP_ON_FAILURE
        )
    }

    @And("the {string} label should be visible in the Net Liquidity section")
    def labelIsVisible(String labelText) {
        WebUI.verifyElementVisible(
            findTestObject('Object Repository/Claude demo - June 26/Page_Dashboard/section_net_liquidity_heading'),
            FailureHandling.STOP_ON_FAILURE
        )
        WebUI.closeBrowser()
    }
}
