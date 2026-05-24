Feature: Contact Us Module

Scenario: Submit contact form with valid data
Given User opens contact form
When User enters contact details
And User submits contact form
Then Form should submit successfully

Scenario: Verify success message
Given User opens contact form
When User enters contact details
And User submits contact form
Then Contact success message should display

Scenario: Upload file in contact form
Given User opens contact form
When User enters contact details
And User uploads file
And User submits contact form
Then Form should submit successfully