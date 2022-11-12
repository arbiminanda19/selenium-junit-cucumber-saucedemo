@FirstRelease
Feature: Login functionality

  @Positive
  Scenario Outline: Ensure user succesfully login
    # precondition
    Given user is on SauceDemo homepage
    #steps
    When user input <username> as username
    And user input <password> as password
    And user click enter
    # expected
    Then user verify <status> login result

    Examples:
      | username                | password      | status  |
      | standard_user           | secret_sauce  | success |
      | performance_glitch_user | secret_sauce  | success |
      | failed_user             | secret_sauce  | failed  |

  @Negative
  Scenario: Ensure user failed login with password null
    Given user is on SauceDemo homepage
    #steps
    When user input username
    And user click enter
    Then user verify failed login
