Feature: Add prooduct

Scenario:  Add product to cart 

Given Navigate to snapdeal homepage 
When Hover kids fashion
And Select kids fashion
When  user Select any product 
Then Ensure that we are on correct product details page
When Click on Add to cart 
Then Ensure the correct product is added to cart
And validate sub total 
And validate estimated total
And Validate the cart count that displayed on cart icon in header