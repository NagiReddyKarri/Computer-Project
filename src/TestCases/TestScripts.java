package TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Environment.ChooseBrowser;
import PageObjectModel.AddComputer;
import PageObjectModel.EditComputer;
import PageObjectModel.HomePage;
import Utilities.ConstantValues;
import Utilities.ExcelConfig;
import Utilities.Screenshot;

/**
 * @author NagiReddy Karri 
 *
 */

public class TestScripts extends ChooseBrowser
{
	/**
	 * This Class contains all the test cases to Execute
	 * 
	 */
	public WebDriver driver;
	
	// TC_01  Add a new computer
	@Test(priority = 0)
	public void AddCompueter() throws Exception
	{
		Applicationlaunch();
		AddComputer addcom = new AddComputer(driver);
		HomePage hp = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 6000);
		WebElement CompName = addcom.btnAddComputer;
		wait.until(ExpectedConditions.visibilityOf(CompName));
		CompName.click();
		WebElement CName = addcom.edtComputername;
		wait.until(ExpectedConditions.visibilityOf(CName));
		String Name = ExcelConfig.getCellData(2,1);
		CName.sendKeys(Name);
		String introdate = ExcelConfig.getCellData(2, 2);
		addcom.edtintroducedate.sendKeys(introdate);
		String discondate = ExcelConfig.getCellData(2, 3);
		addcom.edtdiscontinueddate.sendKeys(discondate);
		String Company = ExcelConfig.getCellData(2, 4);
		WebElement ele = addcom.selectcompany;
		Select Sel = new Select(ele);
		Sel.selectByValue(Company);
		Screenshot.TakeScreenshot(driver, "AddComputer/1 Details entered");
		addcom.btnCreate.click();
		WebElement confirm = hp.Confirmmessage;
		wait.until(ExpectedConditions.visibilityOf(confirm));
		String Actualmessage = confirm.getText();
		Screenshot.TakeScreenshot(driver, "AddComputer/2 Home Screen Validations");
		String Expectedmessage = "Done! Computer "+Name +" has been created";
		if(Expectedmessage.equalsIgnoreCase(Actualmessage))
		{
			ExcelConfig.SetCellData("Passed", 2, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 2, 5);
		}
		driver.quit();
	}
	// TC_02  Edit a computer
	@Test(priority = 1)
	public void EditComputername() throws Exception
	{
		Applicationlaunch();
		SearchComputer(2,1);
		EditComputer edt = new EditComputer(driver);
		edt.firstComputer.click();
		String compname = ExcelConfig.getCellData(3, 1);
		edt.edtComputername.clear();
		edt.edtComputername.sendKeys(compname);
		edt.edtintroducedate.clear();
		String introducedate = ExcelConfig.getCellData(3, 2);
		edt.edtintroducedate.sendKeys(introducedate);
		edt.edtdiscontinueddate.clear();
		String discontinueddate = ExcelConfig.getCellData(3, 3);
		edt.edtdiscontinueddate.sendKeys(discontinueddate);
		Screenshot.TakeScreenshot(driver, "Edit Computer/1 Name changed");
		edt.btnSave.click();
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		HomePage hp = new HomePage(driver);
		WebElement confirm = hp.Confirmmessage;
		wait.until(ExpectedConditions.visibilityOf(confirm));
		Screenshot.TakeScreenshot(driver, "Edit Computer/2 Home Screen Validation");
		String Actualmessage = confirm.getText();
		String Expectedmessage = "Done! Computer "+ compname+" has been updated";
		if(Expectedmessage.equalsIgnoreCase(Actualmessage))
		{
			ExcelConfig.SetCellData("Passed", 3, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 3, 5);
		}
		driver.quit();
	}
	// TC_03  Delete a computer
	@Test(priority = 2)
	public void DelComputername() throws Exception
	{
		Applicationlaunch();
		SearchComputer(3,1);
		EditComputer edt = new EditComputer(driver);
		edt.firstComputer.click();
		WebElement delete = edt.btndelete;
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		wait.until(ExpectedConditions.visibilityOf(delete));
		Screenshot.TakeScreenshot(driver, "Delete Computer/1 Edit Computer page");
		delete.click();
		HomePage hp = new HomePage(driver);
		WebElement msg = hp.Confirmmessage;
		wait.until(ExpectedConditions.visibilityOf(msg));
		String Actualmessage = msg.getText();
		Screenshot.TakeScreenshot(driver, "Delete Computer/2 Home Screen Validation");
		String Expectedmessage = "Done! Computer has been deleted";
		if(Expectedmessage.equalsIgnoreCase(Actualmessage))
		{
			ExcelConfig.SetCellData("Passed", 4, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 4, 5);
		}
		driver.quit();
		
	}
	// TC_04  Validate the number of computers displayed
	@Test(priority = 3)

	public void ComputerCount() throws Exception
	{
		Applicationlaunch();
		Screenshot.TakeScreenshot(driver, "Home Screen/1 Home Screen Page");
		SearchComputer(5, 1);
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		String Expected = hp.nbrcomputers.getText();
		Screenshot.TakeScreenshot(driver, "Home Screen/2 Search result");
		WebElement navigation = hp.navgationdisplay;
		String Actual = navigation.getText();
		String [] a = Expected.split(" ");
		String Expnbr = a[0];
		String []b = Actual.split(" ");
		String actnbr = b[5];
		if(Expnbr.equalsIgnoreCase(actnbr))
		{
			ExcelConfig.SetCellData("Passed", 5, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 5, 5);
		}
		driver.quit();	
	}
	//TC_05 Validate error for the invalid date format in Add Computer screen
	@Test(priority = 4)
	public void invalidDatevalidation() throws Exception
	{
		Applicationlaunch();
		AddComputer addcom = new AddComputer(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		WebElement CompName = addcom.btnAddComputer;
		wait.until(ExpectedConditions.visibilityOf(CompName));
		CompName.click();
		String Name = ExcelConfig.getCellData(6,1);
		addcom.edtComputername.sendKeys(Name);
		String introdate = ExcelConfig.getCellData(6, 2);
		addcom.edtintroducedate.sendKeys(introdate);
		String discondate = ExcelConfig.getCellData(6, 3);
		addcom.edtdiscontinueddate.sendKeys(discondate);
		String Company = ExcelConfig.getCellData(6, 4);
		WebElement ele = addcom.selectcompany;
		Select Sel = new Select(ele);
		Sel.selectByValue(Company);
		Screenshot.TakeScreenshot(driver, "AddComputer/3 invalid date Detail entered");
		addcom.btnCreate.click();
		WebElement sc = addcom.AddCompTitle;
		String message = sc.getText();
		Screenshot.TakeScreenshot(driver, "AddComputer/4 Error is displayed in introduction field");
		if(message.equalsIgnoreCase("Add a computer"))
		{
			ExcelConfig.SetCellData("Passed", 6, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 6, 5);
		}
		driver.quit();	
	}
	//TC_06 Validate error for  the Blank name in Add Computer screen
	@Test(priority =5)
	public void BlanknameInAddComputer() throws Exception
	{
		Applicationlaunch();
		AddComputer addcom = new AddComputer(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		WebElement CompName = addcom.btnAddComputer;
		wait.until(ExpectedConditions.visibilityOf(CompName));
		CompName.click();
		addcom.edtComputername.sendKeys("");
		String introdate = ExcelConfig.getCellData(7, 2);
		addcom.edtintroducedate.clear();
		addcom.edtintroducedate.sendKeys(introdate);
		String discondate = ExcelConfig.getCellData(7, 3);
		addcom.edtdiscontinueddate.clear();
		addcom.edtdiscontinueddate.sendKeys(discondate);
		String Company = ExcelConfig.getCellData(7, 4);
		WebElement ele = addcom.selectcompany;
		Select Sel = new Select(ele);
		Sel.selectByValue(Company);
		Screenshot.TakeScreenshot(driver, "AddComputer/5 Name left blank");
		addcom.btnCreate.click();
		WebElement sc = addcom.AddCompTitle;
		String message = sc.getText();
		Screenshot.TakeScreenshot(driver, "AddComputer/6 Error is displayed in Name field");
		if(message.equalsIgnoreCase("Add a computer"))
		{
			ExcelConfig.SetCellData("Passed", 7, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 7, 5);
		}
		driver.quit();	
	}
	//TC_07 Validate error for  the Blank name in Edit Computer screen
	@Test(priority =6)
	public void BlanknameInEditComputer() throws Exception
	{
		Applicationlaunch();
		EditComputer edt = new EditComputer(driver);
		edt.firstComputer.click();
		Thread.sleep(3000);
		edt.edtComputername.clear();
		edt.edtComputername.sendKeys("");
		String introdate = ExcelConfig.getCellData(8, 2);
		edt.edtintroducedate.clear();
		edt.edtintroducedate.sendKeys(introdate);
		String discondate = ExcelConfig.getCellData(8, 3);
		edt.edtdiscontinueddate.clear();
		edt.edtdiscontinueddate.sendKeys(discondate);
		String Company = ExcelConfig.getCellData(8, 4);
		WebElement ele = edt.selectcompany;
		Select Sel = new Select(ele);
		Sel.selectByValue(Company);
		Screenshot.TakeScreenshot(driver, "Edit Computer/3 Blank Name displayed");
		edt.btnSave.click();
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		WebElement sc = edt.EditCompTitle;
		wait.until(ExpectedConditions.visibilityOf(sc));
		String message = sc.getText();
		Screenshot.TakeScreenshot(driver, "Edit Computer/4 Error is displayed in Name field");
		if(message.equalsIgnoreCase("Edit computer"))
		{
			ExcelConfig.SetCellData("Passed", 8, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 8, 5);
		}
		driver.quit();	
	}
	//TC_08 Validate error for the invalid date format in Edit Computer screen
	@Test(priority = 7)
	public void invalidDateinEditComp() throws Exception
	{
		Applicationlaunch();
		EditComputer edt = new EditComputer(driver);
		edt.firstComputer.click();
		String compname = ExcelConfig.getCellData(9, 1);
		edt.edtComputername.clear();
		edt.edtComputername.sendKeys(compname);
		edt.edtdiscontinueddate.clear();
		String discontdate = ExcelConfig.getCellData(9, 3);
		edt.edtdiscontinueddate.sendKeys(discontdate);
		Screenshot.TakeScreenshot(driver, "Edit Computer/5 invalid date entered");
		edt.btnSave.click();
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		WebElement sc = edt.EditCompTitle;
		wait.until(ExpectedConditions.visibilityOf(sc));
		Screenshot.TakeScreenshot(driver, "Edit Computer/6 Error is displayed in Name field");
		String message = sc.getText();
		
		if(message.equalsIgnoreCase("Edit computer"))
		{
			ExcelConfig.SetCellData("Passed", 9, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 9, 5);
		}
		driver.quit();
	}
	//TC_09 Search validation for not existing computer
	@Test(priority = 8)
	public void invalidSearch() throws Exception
	{
		Applicationlaunch();
		Screenshot.TakeScreenshot(driver, "Home Screen/3 Home Screen Page");
		SearchComputer(10, 1);
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		String Msg = hp.Resultdisplay.getText();
		Screenshot.TakeScreenshot(driver, "Home Screen/4 message displayed");
		if(Msg.equalsIgnoreCase("Nothing to display"))
		{
			ExcelConfig.SetCellData("Passed", 10, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 10, 5);
		}
		driver.quit();
		
	}
	//TC_09 Validation of Cancel button in Edit computer page
	@Test(priority = 9)
	public void CancelbuttonValidation() throws Exception
	{
		Applicationlaunch();
		SearchComputer(11,1);
		EditComputer edt = new EditComputer(driver);
		edt.firstComputer.click();
		String compname = ExcelConfig.getCellData(11, 1);
		edt.edtComputername.clear();
		edt.edtComputername.sendKeys(compname);
		edt.edtintroducedate.clear();
		edt.edtintroducedate.sendKeys(ExcelConfig.getCellData(11, 2));
		edt.edtdiscontinueddate.clear();
		edt.edtdiscontinueddate.sendKeys(ExcelConfig.getCellData(11, 3));
		Screenshot.TakeScreenshot(driver, "Edit Computer/7 Details Entered");
		edt.btnCancel.click();
		Thread.sleep(6000);
		Screenshot.TakeScreenshot(driver, "Edit Computer/8 Home Screen Validation");
		String Expectedmessage = driver.getTitle();
		if(Expectedmessage.equalsIgnoreCase("Computers database"))
		{
			ExcelConfig.SetCellData("Passed", 11, 5);
		}
		else
		{
			ExcelConfig.SetCellData("Failed", 11, 5);
		}
		driver.quit();
	
	}
		
	// Search the computer in home page
	public void SearchComputer(int row, int col) throws Exception
	{
		HomePage hp = new HomePage(driver);
		String Computer = ExcelConfig.getCellData(row, col);
		hp.edtSearchComputer.sendKeys(Computer);
		hp.filterbtn.click();
	}
	// To launch the URL in browser
	public void Applicationlaunch() throws Exception
	{
		String launchbrowser = ExcelConfig.getCellData(0, 1);
		String URL = ConstantValues.URL;
		driver = ChooseBrowser.setDriver(launchbrowser ,URL );
	}
}
