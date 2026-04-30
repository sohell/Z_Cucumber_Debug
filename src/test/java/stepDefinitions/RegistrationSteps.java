package stepDefinitions;

import java.util.Map;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationSteps
{
	HomePage hp;
	RegistrationPage rp;
	
	@Given("user navigate to registration page")
	public void user_navigate_to_registration_page() {
	    hp = new HomePage(BaseClass.getDriver());
	    hp.clickMyAccount();
	    hp.clickRegister();
	}
	
	@When("user enters below fields")
	public void user_enters_below_fields(DataTable dataTable) {
	   Map<String,String> data = dataTable.asMap(String.class,String.class);
	   rp = new RegistrationPage(BaseClass.getDriver());
	   rp.setFirstName(data.get("firstName"));
	   rp.setLastName(data.get("lastName"));
	   rp.setEmail(BaseClass.randomAlphanumeric()+"@gmail.com");
	   rp.setTelephone(data.get("telephone"));
	   rp.setPassword(data.get("password"));
	   rp.setConfirmPwd(data.get("password"));
	   
	}
	
	@And("user selects Privacy Policy")
	public void user_selects_Privacy_Policy() {
	    rp.clickPolicy();
	}
	
	@And("user click on continue")
	public void user_click_on_continue() {
	    rp.clickContinue();
	}
	
	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
		rp = new RegistrationPage(BaseClass.getDriver());
	    String ConfMsg = rp.getConfirmationMsg();
	    Assert.assertEquals(ConfMsg, "Your Account Has Been Created!");
	}
	
	
}
