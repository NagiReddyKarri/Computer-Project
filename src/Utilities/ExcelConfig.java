package Utilities;
/**
 * @author NagiReddy Karri 
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	/**
	 * This Class is used for Data Driven Model
	 */
	public static String path = ConstantValues.Excellocation;
	public static String sheetname = ConstantValues.Sheetname;	
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFCell Cell;
	public static XSSFRow Row;

	/**
	 * Method to Call Excel Workbook Reading
	 */
		public static void ExcelConfige() throws Exception
		{
			try {
				File src = new File (path);
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
				sh = wb.getSheet(sheetname);
			} 
			catch (Exception e) {
				System.out.println("Exception in ExcelConfige method "+ e);
			}
		}
		/**
		 * Method to Call the Cell values
		 */
		public static String getCellData(int rownum, int colnum) throws Exception
		{
			ExcelConfige();
			 try {
				Cell = sh.getRow(rownum).getCell(colnum);
				 String Celldata = Cell.getStringCellValue();
				 return Celldata;
			 	 } 
			 catch (Exception e) {
				 System.out.println("Exception in getCellData method "+ e);
				 return null;
			}		 
		}
		/**
		 * Method to enter the values in Specified Cell
		 */
		public static void SetCellData(String Result, int rownum, int colnum) throws Exception
		{
			try {
				ExcelConfige();
				File src = new File (path);
				Cell = null;
				Cell = sh.getRow(rownum).getCell(colnum);
				Row = sh.getRow(rownum);
				Row.createCell(colnum).setCellValue(Result);
				FileOutputStream fos = new FileOutputStream(src);
				wb.write(fos);
				fos.close();
			}
			catch (Exception e) {
				System.out.println("Exception in SetCellData method "+ e);
			}
		}
	}

