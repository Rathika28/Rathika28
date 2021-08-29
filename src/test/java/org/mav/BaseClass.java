package org.mav;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	public static WebDriver driver;
	public static Select s;
	public static void launchurl(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\JunitLearn\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);

	}
	public static WebElement elementById(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
		
	}
	public static WebElement elementLocatorByxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
		
	}
	public static void enterText(WebElement element,String Text) {
		element.sendKeys(Text);
	}
	public static void btnclick(WebElement element,int Index) {
		s=new Select(element);
		s.selectByIndex(Index);
	}

	public static String excelRead(String path,String sname,int rownum,int cellnum) throws IOException {
		File f=new File(path);
		FileInputStream str=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(str);
		Sheet sheet = w.getSheet(sname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
    	int cellType = cell.getCellType();
    	String data=null;
    	if(cellType==1) {
    		data = cell.getStringCellValue();
    	}
    	else if(DateUtil.isCellDateFormatted(cell)) {
    		Date dateCellValue = cell.getDateCellValue();
    		SimpleDateFormat fo=new SimpleDateFormat("MM/DD/YYYY");
    		data = fo.format(dateCellValue);
    		}
    	else {
    		double numericCellValue = cell.getNumericCellValue();
			long l=(long)numericCellValue;
			data=String.valueOf(l);
    	}
    	return data;
    }
	 public static void excelWrite(String path,String sname,int rownum,int cellnum,String data)throws IOException {
	    	File f=new File(path);
	    	Workbook w=new XSSFWorkbook();
	    	Sheet createSheet = w.createSheet(sname);
	    	Row createRow = createSheet.createRow(rownum);
	    	Cell createCell = createRow.createCell(cellnum);
	    	createCell.setCellValue(data);
	    	FileOutputStream str1=new FileOutputStream(f);
	    	w.write(str1);
	    }

	    	public static String title() {
	    		return driver.getTitle();
	    	}
	    	
	}
		
	


