@registration @smoke @regression
Feature: Accout Registration
		Scenario: Successful Account Registration
			Given user navigate to registration page
			When user enters below fields
				|firstName|john|
				|lastName |kenedy|
				|email    |jk@gmail.com|
				|telephone |1234567890|
				|password  |Test@12345|
			And user selects Privacy Policy
			And user click on continue
			Then the user account should get created successfully