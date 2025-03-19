Feature: Add a New Payee

  @AddNewPayee
  Scenario: Validate adding a new payee successfully
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to Pay Bills page for Adding New Payee
    And User clicks on "Add New Payee" tab
    And User enters new payee details
    And User clicks on "Add Payee" button
    Then User should see a success message "The new payee Aditya Rana was successfully created."
    And User captures a screenshot for confirmation
