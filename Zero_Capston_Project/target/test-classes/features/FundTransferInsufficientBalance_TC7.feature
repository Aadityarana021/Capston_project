Feature: Fund Transfer with Insufficient Balance

  @FundTransferInsufficientBalance
  Scenario: Validate Fund Transfer when balance is insufficient
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to Transfer Funds page with insufficient balance

    And User selects an account with insufficient funds as "From Account"
    And User enters an amount greater than the available balance
    And User clicks on Submit
    Then User should see an error message "Insufficient funds."
    And Transfer should not be processed
