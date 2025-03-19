Feature: View Online Statements

  @ViewOnlineStatements
  Scenario: Validate user can view an online bank statement
    Given User logs into Zero Bank for Account Summary TC4
    When User navigates to Online Statements page
    And User selects an account from the dropdown
    And User clicks on the statement link for 2012
    Then User should be able to view the selected statement
