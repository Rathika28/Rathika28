package org.sel;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJunit1 {
	public static WebDriver driver;

	@BeforeClass
    public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\JunitLearn\\driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	@Before
	public void timeBeforeEntry() throws InterruptedException {
		Date d=new Date();
		System.out.println(d);
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	@Test
	public void usernameAndpassword() {
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername .sendKeys("rathikaammu");
		WebElement txtpass = driver.findElement(By.id("pass"));
		txtpass.sendKeys("1234");
	}
	
	@After
	public void timeAfterEntry() throws InterruptedException {
		Date d1=new Date();
		System.out.println(d1);
		Thread.sleep(3000);
		Dimension di=new Dimension(250,250);
		driver.manage().window().setSize(di);
		}
	
	@AfterClass
	public static void closeBrowser() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.quit();
	}

}
