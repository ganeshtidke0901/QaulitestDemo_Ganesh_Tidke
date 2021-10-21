Feature: Wish list and Cart Verification

  @smoke
  Scenario: Verify selected wish list and lowest price product in cart
    Given I add four different products to my wish list
    When I view my wishlist table
    Then I find total four selected items in my Wishlist 
    When I search for lowest price product
 		And I am able to add the lowest price item to my cart
 		Then I am able to verify the item in my cart
   
 

    