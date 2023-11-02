Feature: Application Login

Scenario: Login with valid credentials

Given I Open any browser
And I Navigate to login page
When I enter user name as "phaniatw33@gmail.com" and password as "atw@123" in to the fields
And I click on login button
Then Verify user is able to successfully login