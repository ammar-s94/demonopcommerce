#@smoke
Feature: F03_Currency | users could select currency from the dropdown list on the top left of home page
  Scenario: user could login with valid email and password then select currency
#    Given user go to register page
    When user select euro currency
    Then user selection success
