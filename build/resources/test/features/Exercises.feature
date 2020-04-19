@test
Feature: Exercise related tests

  Scenario: user should be able to create new exercises
    Given user should be able to register an account
    And user creates an exercise
    Then exercises should be created

  Scenario Outline: user should be able to open side menu
    Given user should be able to register an account
    And user opens side menu
    And user selects <sideMenu> option
    Then <sideMenu> should be displayed

    Examples:
      | <sideMenu>  |
      | BODYTRACK   |
      | WEIGHTTRACK |
      | SETTINGS    |
      | ABOUT       |

