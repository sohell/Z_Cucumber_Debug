@loginDD
Feature: Login Data Driven with Excel
	Scenario Outline: Login Data Driveen Excel
		Given the user navigate to Login Page
		Then the user should redirect to MyAccount Page by passing email and password with excel row "<row_index>"
		
		Examples:
			|row_index|
			|1		  |
			|2		  |
			|3		  |
			