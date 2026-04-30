package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Shopping_Cart_Page extends BasePage
{
	public Shopping_Cart_Page(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//table[@class='table table-bordered']/tbody//a[text()='iMac']")
	WebElement product1;
	
	@FindBy(xpath="//table[@class='table table-bordered']/tbody//a[text()='Samsung Galaxy Tab 10.1']")
	WebElement product2;
	
	public String getProduct1()
	{
		//return product1.getText();
		return wait.until(ExpectedConditions.visibilityOf(product1)).getText();
	}
	
	public String getProduct2()
	{
		return product2.getText();
	}
}
