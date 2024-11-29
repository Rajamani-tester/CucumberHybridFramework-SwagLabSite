Feature: Inventory Page Automation of Sauce Labs

  # Scenario 1: Verify all items are listed correctly
  Scenario: Check that all items are displayed in the inventory
    Given User is on the inventory page
    Then The page displays the following items:
      | Sauce Labs Backpack              | $29.99 |
      | Sauce Labs Bike Light            | $9.99  |
      | Sauce Labs Bolt T-Shirt          | $15.99 |
      | Sauce Labs Fleece Jacket         | $49.99 |
      | Sauce Labs Onesie                | $7.99  |
      | Test.allTheThings() T-Shirt (Red)| $15.99 |
    
    
  # Scenario 2: Add an item to the cart  
  Scenario: Add item to the cart
    Given User is on the inventory page
    When User adds "<item>" to the cart
    Then The cart count is updated to "<cartCount>"
    
	Examples:
    | item                           | cartCount |
    | Sauce Labs Bike Light          | 1         |
    | Sauce Labs Backpack            | 1         |
    | Sauce Labs Fleece Jacket       | 1         |
	
    
    
  # Scenario 3: Add multiple items to the cart
  Scenario: Add multiple items to the cart
    Given User is on the inventory page
    When User adds "<item1>" to the cart
    And User adds "<item2>" to the cart
    Then The cart count is updated to "<cartCount>"
    
  Examples:
    | item1                        | item2                      | cartCount |
    | Sauce Labs Backpack          | Sauce Labs Fleece Jacket   | 2         |
    | Sauce Labs Bolt T-Shirt      | Sauce Labs Onesie					| 2         |
    
    
  # Scenario 4: Check if sorting is applied correctly (Name Z-A)
  Scenario: Sort products by Name (Z to A)
    Given User is on the inventory page
    When User selects the "<sortingOption>" option from the sorting dropdown
    Then The items are displayed in alphabetical order by product name in descending order
    
	Examples:
    | sortingOption       |
    | Name (Z to A)       |
    
  # Scenario 5: Check if sorting is applied correctly (Name A-Z)
  Scenario: Sort products by Name (A to Z)
    Given User is on the inventory page
    When User selects the "<sortingOption>" option from the sorting dropdown
    Then The items are displayed in alphabetical order by product name in ascending order
    
  Examples:
    | sortingOption       |
    | Name (A to Z)       |
        
  # Scenario 6: Check sorting by price (Low to High)
  Scenario: Sort products by Price (Low to High)
    Given User is on the inventory page
    When User selects the "<sortingOption>" option from the sorting dropdown
    Then The items are displayed in ascending order of price
    
  Examples:
    | sortingOption       |
    | Price (low to high) |
      
  # Scenario 7: Check sorting by price (High to Low)
  Scenario: Sort products by Price (High to Low)
    Given User is on the inventory page
    When User selects the "<sortingOption>" option from the sorting dropdown
    Then The items are displayed in descending order of price
    
  Examples:
    | sortingOption       |
    | Price (high to low) |
    
  # Scenario 8: Check "Open Menu" and "Close Menu" functionality
  Scenario: Verify the Open and Close Menu functionality
    Given User is on the inventory page
    When User clicks on Open Menu
    Then The menu is displayed
    When User clicks on Close Menu
    Then The menu is hidden
    
    
  # Scenario 9: Verify "Logout" functionality
  Scenario: Check logout functionality on inventory page
    Given User is on the inventory page
    When User clicks on Open Menu
    Then User clicks on Logout
    Then User is redirected to the login page
    