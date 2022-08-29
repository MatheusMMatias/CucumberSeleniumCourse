@Regression
Feature: Order products

  Background: Open home page
    Given the user is on GreenKart home page

  @Smoke
  Scenario: Search item, add until 3, add to cart and go to cart page
    When the user search for Tom and product is shown
    And the user add 3 units of the product
    And the user adds the product to the cart
    And the user goes to the cart page
    Then the product should be there
    And the amount should be correct
    And the Apply button should be available
    And the Place Order button should be available