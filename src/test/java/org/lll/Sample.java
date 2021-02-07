package org.lll;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

public class Sample {
	public static WebDriver driver;
	public static void getDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\framework\\Client\\folder\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	public static void lauchUrl(String url) {
		driver.get(url);
	}
	public void enterText(WebElement a, String data) {
		a.sendKeys(data);
	}	
	public void btnclick(WebElement element) {
		element.click();
	} 
	public void close() {
    driver.close();
	}
	public void movetoelement(WebElement acc) {
     Actions a=new Actions(driver);
     a.moveToElement(acc).perform();
	}
    public void contextclick(WebElement ref) {
    	Actions b=new Actions(driver);
    	b.contextClick(ref).perform();
    }
    public void doubleclick(WebElement ref1) {
    	Actions c=new Actions(driver);
    	c.doubleClick(ref1).perform();
    }
    public void dragAndDrop(WebElement source,WebElement target) {
     Actions d=new Actions(driver);
     d.dragAndDrop(source, target);
	}
    public void selectbyvalue(WebElement ref2,String value) {
    	Select select=new Select(ref2);
    	select.selectByValue(value);

	}
    public void selectByIndex(WebElement ref3, int data ) {
    	Select ds=new Select(ref3);
    	ds.selectByIndex(data);
    }
    public void selectByVisibletext(WebElement ref4,String name) {
          Select ss=new Select(ref4);
          ss.selectByVisibleText(name);
	}
    public String readvaluefromExcel(String path,String sheetname,int rowno,int cellno) throws IOException {
    	File file=new File(path);
    	FileInputStream stream=new FileInputStream(file);
      Workbook workbook=new XSSFWorkbook(stream);
      Sheet sheet = workbook.getSheet(sheetname);
      Row row = sheet.getRow(rowno);
      Cell cell = row.getCell(cellno);
      int cellType = cell.getCellType();
      String value="";
     if (cellType==1) {
    	  value = cell.getStringCellValue();
    	 System.out.println(value);
		
	}
     else if (DateUtil.isCellDateFormatted(cell)) {
    	 Date dateCellValue = cell.getDateCellValue();
    	 SimpleDateFormat dateformat =new SimpleDateFormat("dd-MM-yyyy");
    	 value = dateformat.format(dateCellValue);
    	 System.out.println(value);
     }
     else {
		double numericCellValue = cell.getNumericCellValue();
		long l=(long) numericCellValue;
		value = String.valueOf(l);
		System.out.println(value);
	}
     return value;
		
	}
    public void pressEnter(WebElement element) throws AWTException {
         Robot b=new Robot();
         b.keyPress(KeyEvent.VK_ENTER);
         b.keyRelease(KeyEvent.VK_ENTER);

	}
    public  void JavascriptExecutorclick(WebElement element) {
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0]z.click()", element);
	}

	}
   
      
	
    
    
   
	
	

	




