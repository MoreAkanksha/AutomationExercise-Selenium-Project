Feature: Signup Module

Scenario: Register user with valid details
Given user is on register page
When user enters valid registration details
And user clicks create account button
Then verify successful account creation

Scenario: Register user with existing email
Given user is on register page
When user enters existing email
Then user gets email already existing message

Scenario: Verify validation messages
Given user is on register page
When user clicks signup without entering details
Then verify validation message

Scenario: Verify successful account creation message
Given user is on register page
When user enters valid registration details 
And user clicks create account button
Then verify account created message



