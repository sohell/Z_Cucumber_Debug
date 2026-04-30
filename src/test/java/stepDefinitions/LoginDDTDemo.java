package stepDefinitions;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginDDTDemo 
{
	/*Feature: Login Data Driven
	Scenario Outline: Login with multiple credentials
		Given user navigate to login page
		When user enter email as "<email>" and password as "<password>"
		And user click on Login button
		Then the user should redirect to MyAccount Page
		
		Examples:
			|email             | password  |
			|aas12@gmail1.com   | Test@12345|
			|pavanol@gmail.com | test123   |
			*/
	
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		BaseClass.getLogger().info("go to MyAccount and click Login");
		HomePage hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
	}
	
	@When("user enter email as {string} and password as {string}")	
	public void user_enter_email_as_and_password_as(String email, String password) {
		LoginPage lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
	}
	
	@And("user click on Login button")
	public void user_click_on_Login_button() {
		LoginPage lp = new LoginPage(BaseClass.getDriver());
		lp.clickLogin();
	}
	
	@Then("the user should redirect to MyAccount Page")
	public void the_user_should_redirect_to_MyAccount_Page() {
		MyAccountPage mp = new MyAccountPage(BaseClass.getDriver());
		boolean status = mp.isAccountPageExist();
		Assert.assertEquals(true, status);
	}
	
	
}
