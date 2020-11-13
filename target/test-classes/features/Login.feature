Feature: Login Functionality
@smoke
Scenario: Login with valid credentials
When login with valid credentials
Then verify the dashboard logo is displayed

@invalidcred
Scenario: Login with invalid credentials
When login with invalid credentials
Then verify the error message                


 #And is the continuation, so it will repeat the previous keyword in snippets
 
 @invalidcred
 Scenario: Login with empty username
 When login with empty username
 Then verify the error message 
 
 @invalidcred
 Scenario: Login with empty password
 When login with empty password
 Then verify the error message
 
 

 