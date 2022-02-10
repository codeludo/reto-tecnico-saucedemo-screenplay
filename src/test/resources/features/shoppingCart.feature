Feature: shopping cart testing
  As a service user
  I want to add a product to the cart with the purchase workflow
  to test a successful item added

  Background:
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

  @shoppingCart
  Scenario: shopping cart
    When I login as standard user
    And select any displayed result to go to the shopping cart
    Then should the shopping cart show the product is not null



