Feature: Pay Bills Without Entering Amount

  @PayBillsWithoutAmount
  Scenario: Validate error when amount is empty while paying bills
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to Pay Bills page with empty amount case

    And User enters a payment date "03/18/2025"
    And User clicks on Pay without entering amount
    Then User should see a pop-up message since the amount field is empty
