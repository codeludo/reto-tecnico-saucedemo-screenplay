Feature: checkout steps
  As a service user
  I need to complete a checkout
  to verify steps in it

  Background: open the page sauce demo
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

    @verifyTax
    Scenario: 01 - complete the purchase to validate taxes
      When I login as 'standard user'
      And select any displayed result to go to the shopping cart
      And checkout my information
        | First Name | Codeludo   |
        | Last Name  | the tester |
        | Zip        | 98192      |
      Then  validate that the tax is correct
        | Tax | 2.40 |

  @verifySuccessMessage
  Scenario: 02 - complete the purchase to validate message of success
    When I login as 'standard user'
    And select any displayed result to go to the shopping cart
    And checkout my information
      | First Name | Codeludo   |
      | Last Name  | the tester |
      | Zip        | 98192      |
    And finish the purchase
    Then I should see the message 'THANK YOU FOR YOUR ORDER'

  @verifyTotal
  Scenario: 03 - complete the purchase to validate total value
    When I login as 'standard user'
    And select any displayed result to go to the shopping cart
    And checkout my information
      | First Name | Codeludo   |
      | Last Name  | the tester |
      | Zip        | 98192      |
    Then I should see the value is '32.39'