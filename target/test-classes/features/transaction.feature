Feature: Transaction and Checkout Process

  Scenario: Complete a transaction from login to checkout with specified conditions
    Given I am on the login page
    When I log in with valid credentials
    And I search for a product with a price below IDR 10.000.000
    And the product is not in the BAG or WATCH category for example "<CLOTHES>"
    And I add the product to my cart
    And I proceed to checkout
    And I input my name on Shipping Address as "<Ryan Naufal - Candidate QA>"
    And I choose a courier
    And I choose a payment method as midtrans or bank transfer for example "<midtrans>"
    Then I should see the transaction amount is correct
    And the transaction should be successfully completed
