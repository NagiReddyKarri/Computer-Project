package Environment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import Utilities.ConstantValues;

/**
 * @author NagiReddy Karri 
 *
 */

public class ChooseBrowser {

	/**
	 * This Class is used for Launching the application in browsers( Chrome, Internetexplorer or Firefox)
	 */
	
	public static WebDriver driver;
	/**
	 *Method to call Application Launch in desired browser 
	 */
	public static WebDriver setDriver(String browser, String appURL)
	{
		String browserToLaunch = browser;
		switch(browserToLaunch)
		{
	//To launch in Google Chrome
		case "Chrome":
		{ 
			System.setProperty("webdriver.chrome.driver", ConstantValues.DriverLocation + "chromedriver.exe");
			ChromeDriver chromedriver = new ChromeDriver();
			driver = chromedriver;
			launchURL(appURL);
			break;
		}
	//To launch in FireFox
		case "Firefox":
		{
			FirefoxDriver Firefoxdriver = new FirefoxDriver();
			driver = Firefoxdriver;
			launchURL(appURL);
			break;	
		}
	//To launch in Internet Explorer
		case "IE" : 
		{
			System.setProperty("webdriver.ie.driver", ConstantValues.DriverLocation + "IEDriverServer.exe");
			InternetExplorerDriver iedriver = new InternetExplorerDriver();
			driver = iedriver;
			launchURL(appURL);
			break;
			
		}
		default:
		{
			driver = null;
		}
		}
		return driver;		
	}
	// Method to Launch the Application URL
	public static void launchURL(String URL) {
		driver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);	
	}
	
	
}