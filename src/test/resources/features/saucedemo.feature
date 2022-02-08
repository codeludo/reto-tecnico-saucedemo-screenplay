Feature: purchase saucedemo
  As service user
  I want to interact with the purchase workflow
  to test a succesfull purchase

  Background:
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

  @shoppintCart
  Scenario: shopping cart

    When I login as standard user
      | username | standard_user |
      | password | secret_sauce  |
    And select any displayed result to go to the shopping cart
    Then should the shopping cart show the product is not null

    @main-menu
    Scenario: main menu
      When I select an option in main menu
      Then I should see depends on selection
        | option 1 | https://saucelabs.com/inventory.html |
        | option 2 | https://saucelabs.com/               |
        | option 2 | https://www.saucedemo.com/           |
        | option 3 | null                                 |
