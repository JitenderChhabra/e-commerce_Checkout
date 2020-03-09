Feature: Add 2 items in cart and checkout
# Created by Jitender Chhabra, 0469322846

  Scenario Outline: Basic functionality testing of E-Commerce Site (AutomationPractice)
    Given I am on test page
    And I search the first "<Product1>" and Add to cart
    And I search the second "<Product2>" and Add to cart
    When I checkout the items
    Then I should see the Authentication page
  # Since I am landing on the Authentication page Therefore i am verifying here same.

    Examples:
      | Product1 | Product2 |
      | dress    | T-shirts |