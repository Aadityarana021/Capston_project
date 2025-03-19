Feature: Verify Session Expiry After Logout

  @SessionExpiry
  Scenario: Validate that user session expires after logout
    Given User logs into Zero Bank
    When User logs out
    And User clicks the Back button in the browser
    Then User should not be able to access the previous page
