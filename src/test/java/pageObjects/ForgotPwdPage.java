package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPwdPage extends BasePage
{
	public ForgotPwdPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgForgotPwd;
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getForgotMsg()
	{
		return msgForgotPwd.getText();
	}
}
