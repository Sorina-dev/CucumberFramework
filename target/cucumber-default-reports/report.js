$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/APIWorkflow.feature");
formatter.feature({
  "name": "Syntax HRMS API Workflow",
  "description": "Description: This feature file tests Syntax HRMS API Workflow",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@APIworkflow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT id generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_id_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@APIworkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_request_is_prepared_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a POST call is made to create an employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_POST_call_is_made_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating an employee 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_status_code_for_creating_an_employee(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is created contains key \"Message\" and value \"Entry Created\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_employee_is_created_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee ID \"Employee[0].employee_id\" is stored as a global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT id generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_id_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@APIworkflow"
    },
    {
      "name": "@Pogression"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve the created employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_request_is_prepared_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve the created employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_GET_call_is_made_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for retrieving the created employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_status_code_for_retrieving_the_created_employee_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved employee ID matches the globally stored employee ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_retrieved_employee_ID_matches_the_globally_stored_employee_ID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieve data matches the data used to create an employee",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_retrieve_data_matches_the_data_used_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT id generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_id_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving all employees and verifying that created employee details display in the response",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@APIworkflow"
    },
    {
      "name": "@Pogression"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve all employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_request_is_prepared_to_retrieve_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve all employees",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_GET_call_is_made_to_retrieve_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for retrieving all employees is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_status_code_for_retrieving_all_employees_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieve data contains the globally stored employee ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_retrieve_data_contains_the_globally_stored_employee_ID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieve data matches the data that was used to create an employee",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_retrieve_data_matches_the_data_that_was_used_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
});