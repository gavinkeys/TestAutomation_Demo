@login
Feature: Login Feature

  Background:
    Given I navigate to "https://www.saucedemo.com/"

  @HappyPath
  Scenario Outline: Login to SauceDemo.com
    Given I enter the username <username>
    And I enter the password <password>
    Then I click the login button

    Examples:
      | username                  | password       |
      | "standard_user"           | "secret_sauce" |
      | "locked_out_user"         | "secret_sauce" |
      | "problem_user"            | "secret_sauce" |
      | "performance_glitch_user" | "secret_sauce" |
      | "error_user"              | "secret_sauce" |
      | "visual_user"             | "secret_sauce" |