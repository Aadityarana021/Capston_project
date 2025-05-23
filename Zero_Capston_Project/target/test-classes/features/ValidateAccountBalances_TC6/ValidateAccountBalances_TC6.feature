Feature: Validate Account Balances

  @ValidateAccountBalances
  Scenario: Validate Transfer Funds between accounts
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to transfer funds for TC6 validation
    

    And User selects From Account and To Account
    And User clicks on Continue
    Then User should see the transfer confirmation
