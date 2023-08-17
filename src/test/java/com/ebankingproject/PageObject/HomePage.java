package com.ebankingproject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
//constructer
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Element
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUp;
	
	
	@FindBy(xpath="//span[text()='Log In']")
	WebElement LinkLogin;
	
	
	
	//Action method
	
	public void SignUp()
	{
		SignUp.click();	
	}
	
	public void ClickLogin()
	{
		LinkLogin.click();
	}
	
	
}


