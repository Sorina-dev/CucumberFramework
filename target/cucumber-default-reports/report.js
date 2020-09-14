$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployee.feature");
formatter.feature({
  "name": "Add Employee Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add employee with login details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "log in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.log_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Add Employee Page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.go_to_Add_Employee_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "input the employee login details",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.input_the_employee_login_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the Personal Details text after login details",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.verify_the_Personal_Details_text_after_login_details()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Add employee with login details");
formatter.after({
  "status": "passed"
});
});