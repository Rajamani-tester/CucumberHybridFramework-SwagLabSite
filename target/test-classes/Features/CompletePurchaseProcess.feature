Feature: Shopping Cart and Checkout Flow

 	As a shopper,
  I want to log in, browse products, add them to my cart, complete the checkout process, 
  and receive a confirmation message,
  So that I can successfully purchase items and receive an order confirmation.
 
 Scenario: complete shopping flow from login to order placed
	Given User is on login page
	When User enters "<username>" and "<password>"
	And Clicks on Login Button
	Then User is navigated to Home Page
  When User adds "<product>" to the cart
  Then The cart count is updated to "<cartCount>"
	And User go to the cart page
  Then the cart should contain <cartCount> item
  And the item in the cart should be "<product>"
  And the total price should be <productPrice>
	When User clicks Checkout
	Then the user should be redirected to the checkout page
  When User enters "<firstName>" in the First Name field
  And User enters "<lastName>" in the Last Name field
  And User enters "<zip>" in the Zip/Postal Code field
  And User clicks Continue
  Then the user should be redirected to the confirmation page
  And the order details should be correct product name "<product>", product count <cartCount>, product price <productPrice>
  And User clicks Finish
  And User should recieve order sucessfully placed Message
  
  Examples:
    | username       | password     | product               		 | cartCount | productPrice | firstName | lastName | zip   |
    | standard_user  | secret_sauce | Sauce Labs Bike Light 		 | 1         | 9.99         | Herald    | Doss     | 90210 |
    | standard_user  | secret_sauce | Sauce Labs Backpack   		 | 1         | 29.99        | John      | Abraham  | 10001 |
    | standard_user  | secret_sauce | Sauce Labs Onesie          | 1         | 7.99         | Alice     | Smith    | 20002 |
    | standard_user  | secret_sauce | Sauce Labs Fleece Jacket   | 1         | 49.99        | john      | Wick     | 30003 |
    | standard_user  | secret_sauce | Sauce Labs Bolt T-Shirt		 | 1         | 15.99        | Mark      | Antony   | 40004 |