Feature: Tax to total purchase
  As a service user
  I need to complete a checkout
  to verify purchase tax is 8%

  Background: open the page sauce demo
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

    @tax
    Scenario: tax validation
      When I login as standard user
      And select any displayed result to go to the shopping cart
      And checkout my information
        | First Name | Codeludo   |
        | Last Name  | the tester |
        | Zip        | 98192      |
      And  validate that the tax is correct
        | Tax | 2.40 |
