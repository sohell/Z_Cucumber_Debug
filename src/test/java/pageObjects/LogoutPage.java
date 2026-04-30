package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage
{
	public LogoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement msgLogout;
	
	public String getAccountLogoutMsg()
	{
		return msgLogout.getText();
	}
}
