@smoke
Feature: F04_Search | users could search for products using product name or sku
  Scenario Outline: user could search using product name
    When user enter product name as <product> "name"
#    Then user should see items
    Examples:
      |product|
      |book   |
      |laptop |
      |nike   |

  Scenario Outline: user could search for product using sku
    When user enter product name as <product> "sku"
#    Then user should see items
    Examples:
      |product|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|
