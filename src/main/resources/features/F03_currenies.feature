@smoke
Feature: F03_Currency | users could select currency from the dropdown list on the top left of home page
  Scenario: user could login with valid email and password then select currency
    Given user go to login page
    When user login with "valid" "test952@example.com" and "P@ssw0rd"
    And user press on login button
    Then user login to the system successfully
    When user select euro currency
    Then user selection success
