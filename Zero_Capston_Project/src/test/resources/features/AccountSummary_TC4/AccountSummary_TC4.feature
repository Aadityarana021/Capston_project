Feature: Account Summary Page for Test Case 4
	@AccountSummary_TC4
  Scenario: Account Summary Page Loads Correctly for TC4
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to the Account Summary page TC4
		When User clicks on the specific statement link for 2012

    Then Account Summary page should display account types and balances TC4
