Feature: Login Scenario in SwagLabs

  Scenario: User log in to the application
    Given User is on log in page
    When User enters log in id "standard_user"
    And User enters password "secret_sauce"
    And User clicks on log in button
    Then User gets the title of the Home page
    And Page title should be "Swag Labs"

  Scenario: Log in Page title
    Given User is on log in page
    When User gets the title of the page
    Then Page title should be "Swag Labs"