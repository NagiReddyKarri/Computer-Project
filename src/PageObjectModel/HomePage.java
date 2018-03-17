package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author NagiReddy Karri 
 */
public class HomePage {
	/**
	 * This Class contains all the objects present in Home Page
	 */
	public WebDriver driver;
	//Constructor to call in TestClass
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Object for Confirm message
	@FindBy(xpath = "//div[@class = 'alert-message warning']")
	public WebElement Confirmmessage;
	//Object for count of computers displayed
	@FindBy(xpath = "//*[@id='main']/h1")
	public WebElement nbrcomputers;
	//Object for Search Button
	@FindBy(id = "searchsubmit")
	public WebElement filterbtn;
	//Object for Edit Search box
	@FindBy(id = "searchbox")
	public WebElement edtSearchComputer;
	//Object for Navigation 
	@FindBy(xpath = "//*[@id='pagination']/ul/li[2]/a")
	public WebElement navgationdisplay;
	//Object for Next button
	@FindBy(xpath = "//*[@href='/computers?p=1']")
	public WebElement btnNext;
	//Object for Previous button
	@FindBy(xpath = "//*[@href='/computers']")
	public WebElement btnPrevious;
	//Object for Result display
	@FindBy(xpath = "//*[@id='main']/div[2]/em")
	public WebElement Resultdisplay;
	
	
	
	

}
