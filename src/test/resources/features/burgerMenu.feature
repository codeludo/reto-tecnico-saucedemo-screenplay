Feature: Burger menu testing
  As a service user
  I need to validate the options in burger menu
  to verify it is working

  Background:
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

  @burger-menu-3items
  Scenario Outline: Burger menu for All items, About, Logout
    And I select an option in main menu
      | selection | <selection> |

    Then I should see that page change depends on selection
      | validation | <validation> |
    Examples:
      | selection | validation                               |
      | All Items | https://www.saucedemo.com/inventory.html |
      | About     | https://saucelabs.com/                   |
      | Logout    | https://www.saucedemo.com/               |

  @burger-menu-resetStateItem
  Scenario: burger menu reset all items
    When I want to reset the app state
      | selection | Reset App State |
    Then I should see the items has been reset

