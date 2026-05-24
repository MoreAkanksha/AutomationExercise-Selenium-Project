Feature: Cart Module

Scenario: Verify cart page access
Given User opens cart page
Then Cart page should display

Scenario: Update product quantity
Given User adds product with quantity "3"
Then Product quantity should be "3"

Scenario: Remove product from cart
Given User adds product with quantity "1"
When User removes product
Then Cart should update successfully

Scenario: Verify total amount
Given User adds product with quantity "2"
Then Total amount should be correct