package stepDefinitions;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class Login_Steps 
{
	LoginPage lp;
	HomePage hp;
	MyAccountPage map;
	
	@Given("the user navigate to login page")
	public void the_user_navigate_to_login_page() {
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
	}
	@When("the user entered email as {string} and password as {string}")
	public void the_user_entered_email_as_and_password_as(String username, String pwd) {
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(username);
		lp.setPassword(pwd);
		
	}
	@When("click on Login button")
	public void click_on_login_button() {
		lp.clickLogin();
	}
	@Then("user should navigate to login page")
	public void user_should_navigate_to_login_page() {
		map = new MyAccountPage(BaseClass.getDriver());
	   boolean flag = map.isAccountPageExist();
	   Assert.assertEquals(true, flag);
	}

}
