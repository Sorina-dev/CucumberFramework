#Author: Intructor

@APIworkflow
Feature: Syntax HRMS API Workflow
Description: This feature file tests Syntax HRMS API Workflow

Background:
   Given a JWT id generated
   
   Scenario: Creating an employee
   Given a request is prepared to create an employee
   When a POST call is made to create an employee
   Then the status code for creating an employee 201
   And the employee is created contains key "Message" and value "Entry Created"
   And the employee ID "Employee[0].employee_id" is stored as a global variable to be used for other calls
  
  @Pogression
  Scenario: Retrieving created employee
  Given a request is prepared to retrieve the created employee
  When a GET call is made to retrieve the created employee
  Then the status code for retrieving the created employee is 200
  And the retrieved employee ID matches the globally stored employee ID
  And the retrieve data matches the data used to create an employee
  
  @Pogression
  Scenario: Retrieving all employees and verifying that created employee details display in the response
  Given a request is prepared to retrieve all employees
  When a GET call is made to retrieve all employees
  Then the status code for retrieving all employees is 200
  And the retrieve data contains the globally stored employee ID
  And the retrieve data matches the data that was used to create an employee
  
   