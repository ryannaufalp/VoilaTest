by: Ryan Naufal Pioscha

# Technical Question

## 1. Technical Test
this is on class TransactionSteps and the feature on transaction.feature

this is dummy class of selenium i created because this is just example of the feature (on TransactionSteps.java)
```
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
```

## 2. Voila Test cases
### Test cases:
Login
```Feature: User Login
  As a user, I want to log in to the application so that I can access my account.

  Scenario: Successful login with valid username credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the user should be redirected to the dashboard
    And the user should see a welcome message with their username

  Scenario: Successful login with valid phone number credentials
    Given the user is on the login page
    When the user enters a valid phone number
    And the user clicks the login button
    Then the user should be redirected to the dashboard
    And the user should see a welcome message with their username

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    And the user clicks the login button
    Then the user should see an error message "Invalid username or password"
    And the user should remain on the login page

  Scenario: Unsuccessful login with empty credentials
    Given the user is on the login page
    When the user clicks the login button without entering credentials
    Then the user should see an error message "Username and password are required"
    And the user should remain on the login page
```
I created automation for succesful login feature with username and password on LoginSteps.java, and all gherkin cases on login.feature

Search
```
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

```
I created automation for search with a valid product name on SearchSteps.java (Not Done) and all gherkin cases on search.feature 
### bugs:
for now i cannot find any bugs

### idea for next feature
For login, i have an idea to login with fingerprint or face id
For search, i think its better to have search recommendation based on history feature

# General Question
## 1. Can you tell us about your passion?
As a QA engineer, my passion lies in ensuring that software products meet the highest standards of quality and reliability. I like doing problem solving and coding and also i like finding detail an ensuring it to be perfect.
## 2. Why do you want to be a QA Engineer?
I am interested in quality and also like doing problem solving. I think because of this, role as a QA engineer is the one that excites me most.
## 3. What is your goal as a QA Engineer ?
I always want to ensuring for high quality product, and also like doing and build the automation testing. In the future, i want to do more technical as a QA Engineer, so i think my goal is to become test architect 
## 4. How do you plan your goal as a QA Engineer ?
I think for this i need to do step by step, and learn from more experienced QA. I also need to learn latest technology to improve my QA skills and continue my professional development to become better QA in the future.
## 5. What is your expectation, If you join with Catalyst as a QA Engineer ?
I heard that Catalyst is using latest and advanced technology, specifically in testing. I want to learn more about testing here because of that and while Catalyst have good quality product, i think its good to learn more about testing here. I also hope my current skills also can fit here and can grow to become better QA in the future.