package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author NagiReddy Karri 
 *
 */

public class AddComputer {

	/**
	 * This Class contains all the objects present in Add A computer Page
	 */
	WebDriver driver;
	
	//Constructor to call in TestClass
	public AddComputer(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Object for Add Button 
	@FindBy(id = "add")
	public WebElement btnAddComputer;
	//Object for Computer Name 
	@FindBy(id = "name")
	public WebElement edtComputername;
	//Object for introduction date 
	@FindBy(id = "introduced")
	public WebElement edtintroducedate;
	//Object for discontinuation date 
	@FindBy(id = "discontinued")
	public WebElement edtdiscontinueddate;
	//Object for Company name
	@FindBy(id = "company")
	public WebElement selectcompany;
	//Object for Submit button
	@FindBy(xpath = "//*[@type = 'submit']")
	public WebElement btnCreate;
	//Object for Cancel button
	@FindBy(xpath = "//a[@href ='/computers']")
	public WebElement btnCancel;
	//Object for Page Title
	@FindBy(xpath = "//*[@id = 'main']/h1")
	public WebElement AddCompTitle;
	

}
