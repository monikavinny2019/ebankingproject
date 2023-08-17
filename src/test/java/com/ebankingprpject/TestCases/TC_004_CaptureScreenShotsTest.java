package com.ebankingprpject.TestCases;


	
	
	

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

	//import io.github.bonigarcia.wdm.WebDriverManager;
   
    
	public class TC_004_CaptureScreenShotsTest {

		private static WebDriver driver;
		
		
				@Test	
			public  void Tc_CaptureScreenShotsTest() throws InterruptedException, IOException
			
			{
			ChromeOptions options=new ChromeOptions();
			driver = new ChromeDriver(options);
			Thread.sleep(2000);
			//WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
			
			//Capture full page screenshot - selenium 3 & 4
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg=new File("/Users/manishkumar/eclipse-workspace/seleniumwithmaven/ebankingproject/Screenshot/screenpage.png");
			FileUtils.copyFile(src, trg);
			 
			
			// capture screenshot of specific area from webpage -- selenium 4+
			
			WebElement featuredproducts=driver.findElement(By.xpath("//div[@class='header-logo']"));
			
			File src1=featuredproducts.getScreenshotAs(OutputType.FILE);
			File trg1=new File("/Users/manishkumar/eclipse-workspace/seleniumwithmaven/ebankingproject/Screenshot/logo.png");
			FileUtils.copyFile(src1, trg1);
			
			
			// capture screenshot of specific Web element -- selenium 4+
			
			WebElement logo=driver.findElement(By.xpath("//img[@alt='Picture for category Electronics']"));
			
				File src2=logo.getScreenshotAs(OutputType.FILE);
				File trg2=new File("/Users/manishkumar/eclipse-workspace/seleniumwithmaven/ebankingproject/Screenshot/featureproduct.png");
				FileUtils.copyFile(src2, trg2);
					
					
			}	
		
			
		}
		 
			// TODO Auto-generated method stub
			
		

	



