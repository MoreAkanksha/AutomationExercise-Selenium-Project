Feature: Product Module

Scenario: Search products using keyword
Given User opens products page
When User searches product keyword
Then Product should display

Scenario: Verify product details
Given User opens products page
When User opens first product details
Then Product details should display

Scenario: Add product to cart
Given User opens products page
When User adds product into cart
Then Product should add successfully

Scenario: Verify product category filtering
Given User opens products page
When User filters products by category
Then Filtered category products should display