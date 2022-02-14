Feature: login users
  As a saucedemo tester
  I need to login different users
  to verify different errors


  Background: open the page sauce demo
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

  @loginStandard
  Scenario: login as standard user
    When I login as 'standard user'
    Then I should see 6 products

  @loginLocked
  Scenario: login as locked out user
    When I login as 'locked out user'
    Then I can see an error message

  @loginProblem
  Scenario: login as problem user
    When I login as 'problem user'
    Then I can see in the inventory page all images are equals
    And I only can add three items to shopping cart
    And I can not remove items from button in inventory
    And I can not filter items
    And checkout my information shows error message
