package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_WishList_Page extends BasePage
{
	public My_WishList_Page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='iMac']")
	WebElement product1;
	
	public String getProduct1()
	{
		return product1.getText();
	}

}
