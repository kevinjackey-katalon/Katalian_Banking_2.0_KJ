@NetLiquidity @Dashboard @Positive
Feature: Net Liquidity Display on Dashboard
  As an authenticated banking user
  I want to see the Net Liquidity section on my dashboard
  So that I can quickly view my total financial position

  Background:
    Given I navigate to the login page at "https://katalian-banking.vercel.app/login"
    And I enter username "bankinguser123"
    And I enter password "notapassword@123"
    And I click the login button
    And I wait for the dashboard to load

  @P-01
  Scenario: Net Liquidity label is displayed on the dashboard
    When I navigate to the dashboard
    Then the dashboard page should load successfully
    And the Net Liquidity section should be present on the page
    And the "Net Liquidity" label should be visible in the Net Liquidity section
