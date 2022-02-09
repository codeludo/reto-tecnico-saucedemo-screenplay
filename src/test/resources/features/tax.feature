Feature: Tax to total purchase
  As a service user
  I need to verify the tax value
  to verify it is 8%

  Background:
    Given that I am in the saucedemo page at 'https://www.saucedemo.com/'

    @tax
    Scenario:
      When I login as standard user
      And select any displayed result to go to the shopping cart
      And checkout my information
        | First Name | Codeludo   |
        | Last Name  | the tester |
        | Zip        | 98192      |
      Then validate that the tax is exactly 8%
        | Tax | 2.40 |

