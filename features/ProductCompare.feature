Feature: Product Comparison Functionality

Background:
    Given the user navigate to login page
	When the user entered email as "aas12@gmail.com" and password as "Test@12345"
	And click on Login button
	Then user should navigate to login page
	
 Scenario: Verify user can compare a product successfully
    Given user enters product name "iphone" in the search field
    When user clicks on search button
    And user clicks on compare option
    Then success message should be displayed with product comparison link
