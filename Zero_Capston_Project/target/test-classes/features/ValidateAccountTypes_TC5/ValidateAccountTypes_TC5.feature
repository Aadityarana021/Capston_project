Feature: Validate Account Types for Test Case 5
	@ValidateAccountTypes
  Scenario: Validate that all expected account types are displayed
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to the Account Summary page for TC5
    Then User should see all expected account types for TC5
