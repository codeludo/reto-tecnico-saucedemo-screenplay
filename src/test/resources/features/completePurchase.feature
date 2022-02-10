Feature: complete the purchase
  As a service user
  I want to complete a purchase of one product
  to verify is done successful

  Background: open the page sauce demo
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

    @completePurchase
    Scenario: complete the purchase to validate message of success
      When I login as standard user
      And select any displayed result to go to the shopping cart
      And checkout my information
        | First Name | Codeludo   |
        | Last Name  | the tester |
        | Zip        | 98192      |
      And finish the purchase
      Then I should see the message 'THANK YOU FOR YOUR ORDER'


