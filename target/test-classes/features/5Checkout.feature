Feature: Checkout Module

Scenario: Proceed to checkout
Given User is logged in and has product in cart
When User proceeds to checkout from cart
Then Checkout address details should display

Scenario: Enter address details
Given User is logged in and has product in cart
When User proceeds to checkout from cart
Then Checkout address details should display

Scenario: Verify order review
Given User is logged in and has product in cart
When User proceeds to checkout from cart
Then Order review should display

Scenario: Place order successfully
Given User is logged in and has product in cart
When User proceeds to checkout from cart
And User enters order message
And User clicks place order
And User enters payment details
And User clicks pay and confirm order
Then Order should place successfully