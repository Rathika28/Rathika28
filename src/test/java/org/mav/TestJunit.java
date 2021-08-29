package org.mav;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJunit {
	public static WebDriver driver;
	
	@BeforeClass
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\JunitLearn\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	@Test
	public void UsernameAndPassword() {
		WebElement txtusername = driver.findElement(By.id("email"));
		txtusername.sendKeys("rathikaammu28");
		WebElement txtpassword = driver.findElement(By.id("pass"));
		txtpassword.sendKeys("ammucseb");
		
	}

}
