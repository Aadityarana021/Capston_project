Feature: Login to Zero Bank

  @Login
  Scenario: User logs in successfully
    Given User opens the Zero Bank login page
    When User enters valid username "username" and password "password"
    And Clicks on the Sign In button
    Then User should be redirected to the Account Summary page
