package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage 
{
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//i[@class='fa fa-th-list']")
	WebElement listOption;
	
	@FindBy(xpath="//img[@title='iMac']")
	WebElement lnkImac;
	
	@FindBy(xpath="//i[@class='fa fa-exchange']")
	WebElement btnCompare;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgCompare;
	
	@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-shopping-cart']")
	WebElement btnAddToCart;
	
	public void clickListOption()
	{
		listOption.click();
	}
	
	public void clickProduct()
	{
		lnkImac.click();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickCompare()
	{
		btnCompare.click();
	}
	
	public String getCompareMsg()
	{
		//return msgCompare.getText();
		return wait.until(ExpectedConditions.visibilityOf(msgCompare)).getText();
	}
	
	public void clickAddToCart()
	{
		btnAddToCart.click();
	}
	
	public String getAddoCartMsg()
	{
		return msgCompare.getText();
		
	}
}
