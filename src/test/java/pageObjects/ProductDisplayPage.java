package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage
{
	public ProductDisplayPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='thumbnails']//li[1]//a[1]")
	WebElement lnkProduct;
	
	@FindBy(xpath="//button[@title='Next (Right arrow key)']")
	WebElement rightArrow;
	
	@FindBy(xpath="//button[@title='Previous (Left arrow key)']")
	WebElement leftArrow;
	
	@FindBy(xpath="//button[normalize-space()='×']")
	WebElement closeArrow;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//li[contains(.,'Brand: Apple')]")
	WebElement brand_name;
	
	@FindBy(xpath="//li[normalize-space()='Product Code:Product 14']")
	WebElement product_code;
	
	@FindBy(xpath="//li[normalize-space()='Availability:Out Of Stock']")
	WebElement availability;
	
	public void clickonProductImage()
	{
		lnkProduct.click();
	}
	
	public void clickRight()
	{
		rightArrow.click();
	}
	
	public void clickLeft()
	{
		leftArrow.click();
	}
	
	public void clickClose()
	{
		closeArrow.click();
	}
	
	public String getBrandName()
	{
		return brand_name.getText();
	}
	
	public String getProductCode()
	{
		return product_code.getText();
	}
	
	public String getAvailability()
	{
		return availability.getText();
	}
	
}
