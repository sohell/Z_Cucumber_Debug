@login @regression
Feature: Login with valid credentials
	Scenario: Successful Login
		Given the user navigate to login page
		When the user entered email as "aas12@gmail.com" and password as "Test@12345"
		And click on Login button
		Then user should navigate to login page
	