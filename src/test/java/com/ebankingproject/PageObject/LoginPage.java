package com.ebankingproject.PageObject;
import org.openqa.selenium.remote.http.ConnectionFailedException;
import org.openqa.selenium.support.FindBy;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

		// TODO Auto-generated method stub
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//ChromeDriver driver = new ChromeDriver(options);
		
		@FindBy(name="email")
		WebElement email;
		@FindBy(name="password")
        WebElement password;
		@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
        WebElement Login;
		
		public void setemail(String emailid)
		{
			email.sendKeys(emailid);
			
			
		}
		
		public void setpassword(String pwd1)
		{
			password.sendKeys(pwd1);
			
			
		}
		public void clicklogin()
		{
			Login.click();;
				
		}
		

		
	}


