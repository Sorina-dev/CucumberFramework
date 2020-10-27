Feature: Job Titles validation against DB
@dbValidationJobTitles
Scenario: Job Titles validation against DB
When login with valid credentials
Then verify the dahsboard logo is displayed
When navigate to Job Titles
And verify the table is displayed
When get all Job Titles from table
Then get all Job Titles from db
Then validate the Job Titles from ui against db

