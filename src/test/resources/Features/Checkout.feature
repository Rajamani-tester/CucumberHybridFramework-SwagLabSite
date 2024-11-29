Feature: Checkout Page Functionality

  # Background: Common steps before each scenario
  Background: 
    Given User is on the inventory page
    And User adds "Sauce Labs Backpack" to the cart
    And User go to the cart page
    Then the cart should contain 1 item
    And the total price should be 29.99
    When User clicks Checkout

  # Scenario 1: Filling out the checkout information and completing the process
  Scenario: User fills out the checkout information and completes the checkout
    Given the user should be redirected to the checkout page
    When User enters "<firstName>" in the First Name field
    And User enters "<lastName>" in the Last Name field
    And User enters "<zipCode>" in the Zip/Postal Code field
    And User clicks Continue
    Then the user should be redirected to the confirmation page
    And the order details should be correct product name "Sauce Labs Backpack", product count 1, product price 29.99
    And User clicks Finish
    And User should recieve order sucessfully placed Message
    
  Examples:
    | firstName | lastName | zipCode |
    | petta     | raja     | 90210   |
    | john      | doe      | 12345   |
    | jane      | smith    | 54321   |