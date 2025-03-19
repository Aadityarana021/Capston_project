Feature: Fund Transfer with Negative Amount

@FundTransferNegativeAmount
Scenario: Validate Fund Transfer when negative amount is entered
  Given User logs into Zero Bank for Account Summary TC4
  When User navigates to Transfer Funds page for Negative Amount Test
  And User enters a negative amount "-500"
  And User clicks on Submit for Negative Amount Test
  Then User should see an error message "Invalid amount entered." for Negative Amount Test
