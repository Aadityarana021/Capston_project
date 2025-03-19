Feature: Add a New Payee with Missing Details

  @AddPayeeMissingDetails
  Scenario: Validate error message when adding a payee with missing details
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to Add New Payee page
    And User leaves any field empty and clicks Add Payee
    Then User should see a validation error
