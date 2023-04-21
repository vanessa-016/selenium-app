Feature: access app Swag Labs
  Scenario Outline: access with diferent users
    Given go to app "Swag Labs"
    When access "<USERNAME>" and "<PASS>"
    Then i see the "<MESSAGGE>"

    Examples:
      | USERNAME        |PASS         | MESSAGGE                                            |
      | standard_user   |secret_sauce | https://www.saucedemo.com/inventory.html            |
      | locked_out_user |secret_sauce | Epic sadface: Sorry, this user has been locked out. |

  Scenario: Test Logout
    Given go to app "Swag Labs"
    When access "standard_user" and "secret_sauce"
    Then user click on logout