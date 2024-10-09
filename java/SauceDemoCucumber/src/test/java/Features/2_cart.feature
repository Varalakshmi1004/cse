@cart
Feature: To validate cart functionality

@sanity
Scenario: As a user i want to validate cart functionality
Given as a user i am on product page
When i added 3 products into the cart and navigate to cart Page
Then cart page count should same