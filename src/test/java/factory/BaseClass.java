package factory;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver;
	public static Logger logger;
	
	public static Properties getProperties()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static WebDriver initializeBrowser()
	{
		prop = getProperties();
		String execution_env = prop.getProperty("execution_env").toLowerCase();
		String browser = prop.getProperty("browser").toLowerCase();
		String os = prop.getProperty("os").toLowerCase();
		
		if(execution_env.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			switch(browser)
			{
			case "chrome" : cap.setBrowserName("chrome"); break;
			case "edge" : cap.setBrowserName("MicrosoftEdge"); break;
			default : System.out.println("No Browserr found"); return null;
			}
			
			switch(os)
			{
			case "windows" : cap.setPlatform(Platform.WIN11); break;
			case "mac" :	cap.setPlatform(Platform.MAC); break;
			default : System.out.println("no OS found"); return null;
			}
			
			try {
				driver = new RemoteWebDriver(new URL(""), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(execution_env.equalsIgnoreCase("local")) 
		{
			switch(browser)
			{
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			default : System.out.println("Invalid Browser");
			driver=null;
			}
		}
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static Logger getLogger()
	{
		logger = LogManager.getLogger();  //log4j
		
		return logger;
	}
	
	public static String randomAlphanumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return generatedString+generatedNumber;
	}

}
