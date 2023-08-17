package com.ebankingprpject.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;


public class TC_002_DemoTest {
	
	
		private static WebDriver driver;
		
		//public static void main(String[] args) throws InterruptedException {
			
		//System.setProperty("webdriver.chrome.driver","C:\\ToolsQA\\Libs\\Drivers\\chromedriver.exe");
			
		@Test
		public void Tc_DemoTest() throws InterruptedException
			{
			ChromeOptions options=new ChromeOptions();
			driver = new ChromeDriver(options);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://freecrm.in/");
			
			driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
			Thread.sleep(2000);
			//ale
			driver.findElement(By.id("email")).click();
			driver.findElement(By.id("email")).sendKeys("monika.csengg@gmail.com");
			
			driver.findElement(By.xpath("//a[text()='Sign Up']")).click();

			//driver.navigate().to("https://shop.demoqa.com/?s=" + "dress" + "&post_type=product");

			}
}
