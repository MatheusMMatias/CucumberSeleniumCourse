@Regression
Feature: Search for products on the website pages

  Background: Open home page
    Given the user is on GreenKart home page

  @Smoke
  Scenario: Search for the same product in home page AND top deals page
    When the user search for Tom and product is shown
    Then the user search with the same name Tom in top deals page
    And it should appear and match home page

  Scenario Outline: Search for the same product in home page AND top deals page using Scenario Outline
    When the user search for <ProductShortName> and product is shown
    Then the user search with the same name <ProductShortName> in top deals page
    And it should appear and match home page

    Examples:
      | ProductShortName |
      | Tom              |
      | Straw            |
      | Feijao           |