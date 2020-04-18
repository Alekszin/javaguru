Feature: Exercise related tests

  @test
  Scenario: user should be able to create new exercises
    Given user should be able to register an account
    And user creates an exercise
    Then exercises should be created