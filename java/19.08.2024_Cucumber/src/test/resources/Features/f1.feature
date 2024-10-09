@login
Feature: To validate login functionality

@sanity
Scenario: As a user i want to validate valid login functionality
Given as a user i am on login page
When i enter valid username and valid password and click login
Then i should be able to login successfully

@regresssion
Scenario Outline: As a user i want to validate invalid login functionality
Given as a user i am on login page
When i enter either username or password invalid and click login
Then i should see the error message
Examples:
|username|password|
|user1@gmail.com|dfsdfsdf|
|user1@gmail.com| |
