Feature: Shopping Cart Functionality

  Scenario: Adding a product to the shopping cart and verifying on the cart page
    Given User is on the inventory page
    When User adds "<product>" to the cart
    And User go to the cart page
    Then the cart should contain <itemCount> item
    And the item in the cart should be "<product>"
    And the total price should be <totalPrice>
    
  Examples:
    | product                | itemCount | totalPrice |
    | Sauce Labs Bike Light  | 1         | 9.99       |

  Scenario: Adding multiple products to the shopping cart and verifying on the cart page
    Given User is on the inventory page
    When User adds "<product1>" to the cart
    And User adds "<product2>" to the cart
    And User go to the cart page
    Then the cart should contain <itemCount> item
    And the items in the cart should be "<product1>" and "<product2>"
    And the total price should be <totalPrice>
    
  Examples:
    | product1              | product2            		 | itemCount | totalPrice |
    | Sauce Labs Backpack   | Sauce Labs Fleece Jacket | 2         | 79.98      |
    
  # Scenario 3: Removing an item from the cart and verifying the cart page
  Scenario: Removing an item from the cart and verifying the cart page
  	Given User is on the inventory page
    When User adds "<product1>" to the cart
    And User adds "<product2>" to the cart
    Then User removes "<product1>" from the cart
    And User go to the cart page
    Then the cart should contain <itemCount> item
    And the item in the cart should be "<product2>"
    And the total price should be <totalPrice>
    
  Examples:
    | product1              | product2                 | itemCount | totalPrice |
    | Sauce Labs Backpack   | Sauce Labs Fleece Jacket | 1         | 49.99      |
    
  # Scenario 4: Proceeding to Checkout from the cart page
  Scenario: Proceeding to Checkout from the cart page
    Given User is on the inventory page
    When User adds "<product>" to the cart
    And User go to the cart page
    When User clicks Checkout
    Then the user should be redirected to the checkout page
  Examples:
    | product                |
    | Sauce Labs Backpack    |
    | Sauce Labs Bike Light  |
    
  # Scenario 5: Continuing shopping after adding items to the cart
  Scenario: Continuing shopping after adding items to the cart
    Given User is on the inventory page
    When User adds "<product>" to the cart
    And User go to the cart page
    When User clicks Continue Shopping
    Then the user should be redirected to the inventory page

  Examples:
    | product                |
    | Sauce Labs Backpack    |
    | Sauce Labs Bike Light  |


