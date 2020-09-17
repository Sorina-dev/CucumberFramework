$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SearchEmployee.feature");
formatter.feature({
  "name": "Search Employee Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "search the employees by name",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@byName"
    }
  ]
});
formatter.step({
  "name": "search by name \"\u003cName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.step({
  "name": "validate the user name \"\u003cName\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Name"
      ]
    },
    {
      "cells": [
        "Anne Smith"
      ]
    },
    {
      "cells": [
        "Andrew Locksmith"
      ]
    },
    {
      "cells": [
        "Benjamin Mathers"
      ]
    },
    {
      "cells": [
        "Beyonce Carter"
      ]
    },
    {
      "cells": [
        "Jessie Rodrigues"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the Employee List",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.go_to_the_Employee_List()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "search the employees by name",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@byName"
    }
  ]
});
formatter.step({
  "name": "search by name \"Anne Smith\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.search_by_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.click_on_search_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the user name \"Anne Smith\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\texpected [Anne Smith] but found [Elijah Green \u003cLast Name\u003e]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\r\n\tat com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(SearchEmployeeStepDefinitions.java:82)\r\n\tat ✽.validate the user name \"Anne Smith\"(file:///C:/Users/crist/eclipse-workspace/CucumberFrameworkBatch7/src/test/resources/features/SearchEmployee.feature:25)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "search the employees by name");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the Employee List",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.go_to_the_Employee_List()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "search the employees by name",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@byName"
    }
  ]
});
formatter.step({
  "name": "search by name \"Andrew Locksmith\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.search_by_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.click_on_search_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the user name \"Andrew Locksmith\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\texpected [Andrew Locksmith] but found [Elijah Green \u003cLast Name\u003e]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\r\n\tat com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(SearchEmployeeStepDefinitions.java:82)\r\n\tat ✽.validate the user name \"Andrew Locksmith\"(file:///C:/Users/crist/eclipse-workspace/CucumberFrameworkBatch7/src/test/resources/features/SearchEmployee.feature:25)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded1.png", "search the employees by name");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the Employee List",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.go_to_the_Employee_List()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "search the employees by name",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@byName"
    }
  ]
});
formatter.step({
  "name": "search by name \"Benjamin Mathers\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.search_by_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.click_on_search_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the user name \"Benjamin Mathers\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\texpected [Benjamin Mathers] but found [Elijah Green \u003cLast Name\u003e]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\r\n\tat com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(SearchEmployeeStepDefinitions.java:82)\r\n\tat ✽.validate the user name \"Benjamin Mathers\"(file:///C:/Users/crist/eclipse-workspace/CucumberFrameworkBatch7/src/test/resources/features/SearchEmployee.feature:25)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded2.png", "search the employees by name");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the Employee List",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.go_to_the_Employee_List()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "search the employees by name",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@byName"
    }
  ]
});
formatter.step({
  "name": "search by name \"Beyonce Carter\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.search_by_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.click_on_search_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the user name \"Beyonce Carter\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\texpected [Beyonce Carter] but found [Elijah Green \u003cLast Name\u003e]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\r\n\tat com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(SearchEmployeeStepDefinitions.java:82)\r\n\tat ✽.validate the user name \"Beyonce Carter\"(file:///C:/Users/crist/eclipse-workspace/CucumberFrameworkBatch7/src/test/resources/features/SearchEmployee.feature:25)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded3.png", "search the employees by name");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the Employee List",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.go_to_the_Employee_List()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "search the employees by name",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@byName"
    }
  ]
});
formatter.step({
  "name": "search by name \"Jessie Rodrigues\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.search_by_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.click_on_search_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the user name \"Jessie Rodrigues\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\texpected [Jessie Rodrigues] but found [Elijah Green \u003cLast Name\u003e]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\r\n\tat com.hrms.stepDefinitions.SearchEmployeeStepDefinitions.validate_the_user_name(SearchEmployeeStepDefinitions.java:82)\r\n\tat ✽.validate the user name \"Jessie Rodrigues\"(file:///C:/Users/crist/eclipse-workspace/CucumberFrameworkBatch7/src/test/resources/features/SearchEmployee.feature:25)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded4.png", "search the employees by name");
formatter.after({
  "status": "passed"
});
});