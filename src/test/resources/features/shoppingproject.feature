@Test
Feature: My project is to buy the products from yourlogo shopping website


  Scenario: 1 Buy T-shirt and verify the order history
    Given the user lands on t-shirt page home page
    And the user adds a t-shirt to the cart
    When and the user checks out the T-shirt
    And the user verifies the order history
   Then the page should display Here are the orders you've placed since your account was created. message on the page
    
  Scenario: 2 Updating My FirstName on account
    Given the user signsIn to the account
    And user clicks My Personal Information tab
    And user lands on Your personal Information page
    When user edits and enters EditPranee on first name and fills restof information
    And user clicks save
    Then the user can see Your personal information has been successfully updated. message on the page
