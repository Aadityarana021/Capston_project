Feature: Bill Payment

@FundTransferBillPayment
Scenario: Validate Bill Payment with a Valid Amount and Date
  Given User logs into Zero Bank for Account Summary TC4
  When User navigates to Bills page to Pay Bills in TC9
  And User selects a payee and enters amount "1000"
  And User clicks Pay
  Then User should see the payment confirmation
