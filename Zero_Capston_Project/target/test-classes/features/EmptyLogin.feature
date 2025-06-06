#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Empty Login Fields
	@EmptyLogin
  Scenario: User tries to login without entering credentials
    Given User opens the Zero Bank login page for Empty Login
    When User does not enter any credentials for Empty Login
    And Clicks on the Sign In button for Empty Login
    Then User should see an error message "Login and/or password are wrong." for Empty Login
