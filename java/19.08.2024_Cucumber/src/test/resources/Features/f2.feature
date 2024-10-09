@google
Feature: validate search functionality in google

@search
Scenario: To validate search
Given as a user i am on google homepage
When enter any value in the searchbox and click enter
Then the results should be displayed
