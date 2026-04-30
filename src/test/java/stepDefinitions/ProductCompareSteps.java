package stepDefinitions;

import java.util.Properties;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class ProductCompareSteps {

	HomePage hp;
	SearchPage sp;
	Properties prop = BaseClass.getProperties();
	
	@Given("user enters product name {string} in the search field")
	public void user_enters_product_name_in_the_search_field(String product) {
		hp = new HomePage(BaseClass.driver);
		//hp.searchProduct(prop.getProperty("searchProductName"));
		hp.searchProduct(product);
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		hp.clickSearch();
	}

//	@When("user selects the product from search results")
//	public void user_selects_the_product_from_search_results() {
//		// TODO: implement
//	}
//
//	@Then("user should see {string} option on product page")
//	public void user_should_see_option_on_product_page(String option) {
//		// TODO: implement (ER-1)
//	}

	@When("user clicks on compare option")
	public void user_clicks_on_option() {
		sp = new SearchPage(BaseClass.driver);
		sp.clickCompare();
	}

	@Then("success message should be displayed with product comparison link")
	public void success_message_should_be_displayed_with_product_comparison_link() {
		String cnfMsg = sp.getCompareMsg();
		Assert.assertTrue(cnfMsg.contains("Success: You have added"));
	}

//	@When("user clicks on {string} link")
//	public void user_clicks_on_link(String link) {
//		// TODO: implement (ER-3)
//	}
//
//	@Then("user should be navigated to product comparison page")
//	public void user_should_be_navigated_to_product_comparison_page() {
//		// TODO: implement (ER-3 validation)
//	}

}
