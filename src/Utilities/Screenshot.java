package Utilities;
/**
 * @author NagiReddy Karri 
 *
 */
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * This Class is used to take screen in the project location
 */
public class Screenshot {
	
	/**
	 * Method to takes screenshot
	 */
	
	public static void TakeScreenshot(WebDriver driver, String name)
	{
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File ( "./Screenshots/"+name + ".jpeg") );
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Screenshotmethod " + e);
			e.printStackTrace();
		} 
	}

}
