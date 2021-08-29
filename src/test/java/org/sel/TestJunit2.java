package org.sel;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJunit2  {
	
	public static WebDriver driver;
	@BeforeClass
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\JunitLearn\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/account/login");
		}
	
	@Test
	public static void usernameAndpassword() {
		WebElement txtusername = driver.findElement(By.className("_2IX_2- VJZDxU"));
		txtusername.sendKeys("rathikaammu");
		WebElement txtpassword = driver.findElement(By.className("_2IX_2- _3mctLh VJZDxU"));
		txtpassword.sendKeys("ammucse");
		WebElement button = driver.findElement(By.className("_2KpZ6l _2HKlqd _3AWRsL"));
		button.click();
	}
	

}
