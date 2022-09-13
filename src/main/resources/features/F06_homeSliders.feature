#@smoke
Feature: F06_homeSliders | users could select from sliders
  Scenario: user could click on first slider and navigate to correct url
    When user clicks on first slider
    Then user is redirected to first slider url

  Scenario: user could click on second slider and navigate to correct url
    When user clicks on second slider
    Then user is redirected to second slider url