Feature: Login Module

Scenario: Login with valid credentials
Given User launches browser
When User enters valid email and password
And User clicks login button
Then User should login successfully

Scenario: Login with invalid credentials
Given User launches browser
When User enters invalid email and password
And User clicks login button
Then Error message should display