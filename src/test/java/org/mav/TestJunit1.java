package org.mav;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestJunit1 {
	public static WebDriver driver;
	@BeforeClass
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\JunitLearn\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
	}
	
	@AfterClass
	public static void browser() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void clickSingnin() {
		WebElement button = driver.findElement(By.id("signInLink"));
		button.click();
		
	}
	
}
