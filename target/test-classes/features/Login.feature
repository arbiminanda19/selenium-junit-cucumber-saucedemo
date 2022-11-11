Feature: Login functionality

  Scenario: Ensure user succesfully login
    # precondition
    Given user is on SauceDemo homepage
    #steps
    When user input username
    And user input password
    And user click enter
    # expected
    Then user verify success login result

  Scenario: Ensure user failed login with password null
    Given user is on SauceDemo homepage
    #steps
    When user input username
    And user click enter
    Then user verify failed login
