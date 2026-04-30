package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage
{
	public Products_Page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[3]")
	WebElement subcategoryMac;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
	WebElement addToWishList;
	
	@FindBy(xpath="//a[normalize-space()='wish list']")
	WebElement lnkWishList;
	
	public void clickonMac()
	{
		subcategoryMac.click();
	}
	
	public void clickAddToWishList()
	{
		addToWishList.click();
	}
	
	public void linkWishList()
	{
		lnkWishList.click();
	}

}
