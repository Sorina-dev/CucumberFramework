Feature: Search Employee Functionality

  Background: 
    When login with valid credentials
    Then go to the Employee List

  @byID
  Scenario Outline: search the employees by ID
    When search by ID "<ID>"
    Then click on search Button
    And validate the user ID "<ID>"

    Examples: 
      | ID   |
      | 7812 |
      | 7813 |
      | 7814 |
      | 7815 |
      | 7816 |

  @byName
  Scenario Outline: search the employees by name
    When search by name "<Name>"
    Then click on search Button
    And validate the user name "<Name>"

    Examples: 
      | Name             |
      | Anne Smith       |
      | Andrew Locksmith |
      | Benjamin Mathers |
      | Beyonce Carter   |
      | Jessie Rodrigues |
