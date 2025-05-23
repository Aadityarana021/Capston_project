Feature: Schedule a Bill Payment for a Future Date

  @FundTransferFuturePayment
  Scenario: Validate scheduling a future bill payment
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to Pay Bills page for Future Payment Test
    And User selects a payee
    And User enters a valid amount "1000"
    And User enters a future date "03/26/2025"
    And User clicks Pay for Future Payment Test
    Then User should see a success message for fund transfer "The payment was successfully submitted."

