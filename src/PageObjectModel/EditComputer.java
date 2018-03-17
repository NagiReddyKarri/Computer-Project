/**
 * 
 */
package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author NagiReddy Karri 
 *
 */
public class EditComputer {

	public WebDriver driver;
	//Constructor to call in TestClass
	public EditComputer(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 // Object for first computer in the table
	@FindBy(xpath = "//*[@id='main']/table/tbody/tr[1]/td[1]/a")
	public WebElement firstComputer;
	 // Object for computer name 
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
	@FindBy(xpath = "//input[@type = 'submit'][@class = 'btn primary']")
	public WebElement btnSave;
	//Object for Cancel button
	@FindBy(xpath = "//a[@href ='/computers']")
	public WebElement btnCancel;
	//Object for Delete button
	@FindBy(xpath = "//input[@type = 'submit'][@class = 'btn danger']")
	public WebElement btndelete;
	//Object for Page Title
	@FindBy(xpath = "//*[@id = 'main']/h1")
	public WebElement EditCompTitle;
	
}
