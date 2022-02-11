Feature: filter to order price in products
  As a service user
  I want to filter the prices
  to order the product prices y some order

  Background: open the page sauce demo
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

  @filter
  Scenario Outline: order the products acording to example selection
    When I login as standard user
    And select the price filter
      | selection | <selection> |
    Then first inventory list should contains filtered item
      | item  | <item name>  |
      | price | <item price> |
    Examples:
      | selection           | item name                         | item price |
      | Name (Z to A)       | Test.allTheThings() T-Shirt (Red) | $15.99     |
      | Price (low to high) | Sauce Labs Onesie                 | $7.99      |
      | Price (high to low) | Sauce Labs Fleece Jacket          | $49.99     |
#      | Name (A to Z) | Sauce Labs Backpack | $29.99     | ----> Este por defecto es mejor probarlo el el menu.
