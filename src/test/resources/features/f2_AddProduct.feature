Feature: Add prooduct

Scenario:  Add product to cart 

Given Navigate to Walmart homepage 
When User Select the Departments dropdown 
When Hover on Toys & Outdoor Play
And Select All Toys & Outdoor Play
When  user Select any product 
Then Ensure that we are on correct product details page
When Click on Add to cart 
Then Ensure the correct product is added to cart 