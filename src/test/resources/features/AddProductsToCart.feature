Feature: Add Products to Cart
  As a shopper
  I want to add products to my cart
  So that I can purchase them

  Background:
    Given the shopper is on the product page

  Scenario: Display confirmation alert when adding a product to the cart
    When the shopper clicks "Add to Cart" for a product
    Then a confirmation alert should be displayed with the message "Product added to cart successfully"

  Scenario: Verify product details in the cart
    When the shopper clicks "Add to Cart" for a product
    And navigates to the cart page
    Then the cart should display the product with the correct name, price, and quantity

  Scenario: Update cart correctly when multiple items are added
    When the shopper clicks "Add to Cart" for Product A
    And the shopper clicks "Add to Cart" for Product B
    And navigates to the cart page
    Then the cart should display both Product A and Product B with their correct names, prices, and quantities

  Scenario: Prevent adding unavailable or out-of-stock items
    Given a product is marked as "Out of Stock"
    When the shopper clicks "Add to Cart" for the out-of-stock product
    Then the system should display an error message "This product is out of stock"
    And the product should not be added to the cart