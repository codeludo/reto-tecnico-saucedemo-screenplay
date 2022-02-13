Feature: Burger menu testing
  As a service user
  I need to validate the options in burger menu
  to verify it is working

  Background:
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'


  @burger-menu-3items
  Scenario Outline: 01 - Burger menu for All items, About, Logout
    When I login as 'standard user'
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
  Scenario: 02 - burger menu reset all items
    When I login as 'standard user'
    And I want to reset the app state
      | selection | Reset App State |
    Then I should see the items has been reset

