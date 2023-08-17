package com.ebankingproject.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.asynchttpclient.config.AsyncHttpClientConfigHelper.Config;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import com.beust.jcommander.Parameter;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public Logger logger;// for Logging
	
	public static WebDriver driver;
	public ResourceBundle rb;
	
	
	
	
	@BeforeClass(groups= {"master","sanity","regression"})
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br) throws InterruptedException

	{
		ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		//WebDriverManager.chromedriver().setup();
		rb=ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());// for Logger  
		
		//launch right browser based on parameter
		if (br.equals("chrome")) {
			driver = new ChromeDriver(options);
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(rb.getString("appURL"));
		//driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	}

	@AfterClass(groups= {"master","sanity","regression"})
	public void teadDown() {
		driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	public String randomeNumberString() {
		String st = RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(10);
		return (st+num);
	}
	
		public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = "/Users/manishkumar/eclipse-workspace/seleniumwithmaven/ebankingproject/Screenshot/" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}



}



