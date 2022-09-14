@smoke
Feature: F05_hoverCategories | users could select sub-categories from main category
  Scenario: user could hover on main category and select from sub-categories
    When user hover on main random category
    And user select a sub-category
    Then user navigates to selected sub-category page