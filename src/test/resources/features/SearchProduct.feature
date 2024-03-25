Feature: Verify adding a Laptop to cart on Amazon portal

  Scenario Outline: As a customer when I search for Monitor, I want to see if the first selected item price is consistency after adding to the cart.
    Given the user navigates to Amazon India Portal
    Then Verify the title of the Home Page
    When I type "<Product>" in the Search field and press Enter
    Then List of searched product  should be displayed
    And I select the first item
    And I add the item to the cart by clicking on Add to Cart
    Then Verify the sub-total

    Examples: 
      | Product |
      | Monitor |
