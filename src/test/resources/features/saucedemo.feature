Feature: purchase saucedemo
  As service user
  I want to interact with the purchase workflow
  to test a succesfull purchase

  Background:
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

  @shoppingCart
  Scenario: shopping cart

    When I login as standard user
      | username | standard_user |
      | password | secret_sauce  |
    And select any displayed result to go to the shopping cart
    Then should the shopping cart show the product is not null

    @burger-menu
    Scenario Outline: main menu
      When I select an option in main menu
        | selection | <selection> |
      Then I should see depends on selection
        | validation | <validation> |
      Examples:
        | selection       | validation                               |
        | All Items       | https://www.saucedemo.com/inventory.html |
        | About           | https://saucelabs.com/                   |
        | Logout          | https://www.saucedemo.com/               |
        | Reset App State | https://www.saucedemo.com/inventory.html |





