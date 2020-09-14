Feature: Add Employee Functionality

@regression
Scenario: Add employee
Given log in
And go to Add Employee Page
When input the employee Full Name
Then verify the Personal Details text

@smoke
Scenario: Add employee with login details
Given log in
And go to Add Employee Page
When input the employee login details
Then verify the Personal Details text after login details


