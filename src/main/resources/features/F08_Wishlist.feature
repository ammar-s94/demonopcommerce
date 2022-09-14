@smoke
Feature: F08_Wishlist | users could add items to whishlist
  Scenario: user adds HTC One M8 Android L 5.0 Lollipop to whishlist
    When user adds HTC item to wishlist
    Then item is added successfully

  Scenario: user adds HTC One M8 Android L 5.0 Lollipop to whishlist
    When user adds HTC item to wishlist
    And user go to wishlist page
    Then Qty is greater than zero