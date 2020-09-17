
Feature: Add Employee Functionality

  # backgorund will execute the same common steps for each scenario, and they must be the starting point in execution, at the beggining only
  Background: 
    Given log in
    And go to Add Employee Page

  Scenario: Add employee without login details
    When input the employee Full Name
    Then verify the Personal Details text

  Scenario: Add employee with login details
    When input the employee login details
    Then verify the Personal Details text after login details

 #PARAMETERIZATION
  @parameter
  Scenario: Add employee without login details but with middle name
    When enter first name as "Ahmet" middle name as "Can" and last name as "Bicer"
    Then click on save Button
    And verify that "Ahmet Can Bicer" is added successfully
    
   #Data Driven testing
@examples
  Scenario Outline: Adding multiple employees without login details
    When enter employee "<First Name>", "<Middle Name>" and "<Last Name>"
    Then click on save Button
    And verify that "<First Name>", "<Middle Name>" and "<Last Name>" is successfully added

    Examples: 
      | First Name | Middle Name | Last Name |
      | Mark       | J           | Smith     |
      | Hunter     | ABC         | Musoev    |
      | John       | M           | Wick      |
      | John       | F           | Kennedy   |