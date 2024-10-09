@login
Feature: To validate login functionality

@sanity
Scenario: As a user i want to validate valid login functionality
Given as a user i am on login page
When i enter valid username "standard_user" and valid password "secret_sauce" and click login
Then i should be able to login successfully

@regression
Scenario Outline: As a user i want to validate invalid login functionality
Given as a user i am on login page
When i enter either "<username>" or "<password>" invalid and click login
Then i should see the error message
Examples:
|username|password|
|usesgsvs|dfsdfsdf|
|standard_user| |
