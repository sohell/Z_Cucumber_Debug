@loginDD
Feature: Login Data Driven
	Scenario Outline: Login with multiple credentials
		Given user navigate to login page
		When user enter email as "<email>" and password as "<password>"
		And user click on Login button
		Then the user should redirect to MyAccount Page
		
		Examples:
			|email             | password  |
			|aas12@gmail.com   | Test@12345|
			|pavanol@gmail.com | test123   |