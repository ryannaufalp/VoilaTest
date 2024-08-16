Feature: Product Search
  As a user, I want to search for products so that I can quickly find what I'm looking for.

  Scenario: Search with a valid product name
    Given the user is on the homepage
    When the user enters "Nike" in the search bar
    And the user clicks enter key
    Then the user should see a list of products related to "Nike"
    And each product should display the name and price

  Scenario: Search with an invalid or non-existent product name
    Given the user is on the homepage
    When the user enters "aaaa" in the search bar
    And the user clicks enter key
    Then the user should see a message "Product not found"
    And no products should be displayed

  Scenario: Search with an empty search query
    Given the user is on the homepage
    When the user leaves the search bar empty
    And the user clicks enter key
    Then the user should see a message "Product not found"
    And no products should be displayed
