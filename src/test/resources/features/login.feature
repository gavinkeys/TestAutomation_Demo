@login
Feature: Login Feature

  Background:
    Given I navigate to "https://www.saucedemo.com/"
    And I am on the login page

  @HappyPath
  Scenario Outline: Login to SauceDemo.com
    Given I enter the username <username>
    And I enter the password <password>
    Then I click the login button

    Given I have successfully logged in
    Then I logout

    Examples:
      | username        | password       |
      | "standard_user" | "secret_sauce" |
      | "error_user"    | "secret_sauce" |

  @LockedOutUser
  Scenario Outline: Login to SauceDemo.com with locked-out user
    Given I enter the username <username>
    And I enter the password <password>
    And I click the login button
    Then I see the "Epic sadface: Sorry, this user has been locked out." error message

    Examples:
      | username          | password        |
      | "locked_out_user" | "secret_sauce"  |
      | "standard_user"   | "locked_out_pwd"|

  @EmptyCredentials
  Scenario: Login to SauceDemo.com with empty credentials
    Given I click the login button
    Then I see the "Epic sadface: Username is required" error message

  @InvalidUsername
  Scenario Outline: Login to SauceDemo.com with invalid username
    Given I enter the username <username>
    And I enter the password "secret_sauce"
    And I click the login button
    Then I see the "Epic sadface: Username and password do not match any user in this service" error message

    Examples:
      | username                   |
      | "invalid_characters_$%"    |
      | "invalid_email_format.com" |
      | " "                        |

  @InvalidPassword
  Scenario Outline: Login to SauceDemo.com with invalid password
    Given I enter the username "standard_user"
    And I enter the password <password>
    And I click the login button
    Then I see the "Epic sadface: Username and password do not match any user in this service" error message

    Examples:
      | password                   |
      | "short"                    |
      | "long_password"            |
      | " "                        |

  @InvalidSession
  Scenario: Invalid session attempt
    When I access a secure page without logging in
    Then I am on the login page
    And I see the "Epic sadface: You can only access '/inventory-item.html' when you are logged in." error message