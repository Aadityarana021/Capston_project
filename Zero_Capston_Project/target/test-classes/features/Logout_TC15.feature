Feature: Logout Functionality

  @Logout
  Scenario: Validate successful logout from Zero Bank
    Given User logs into Zero Bank for Account Summary TC4
    When User clicks on the Logout button
    Then User should be redirected to the login page
