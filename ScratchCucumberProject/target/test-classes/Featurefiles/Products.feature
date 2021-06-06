Feature: Product page Feature

  Background:
    Given User has already logged in to the page
      | username      | Password     |
      | standard_user | secret_sauce |

  Scenario: Product Page title
    Given User is on Product page
    When User gets the title of the Home page
    Then Page title should be "Swag Labs"


  Scenario: Product Section Count
    Given User is on Product page
    Then User get the product names
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

    And the product section count should be 6