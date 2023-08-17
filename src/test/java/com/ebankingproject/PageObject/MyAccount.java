package com.ebankingproject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//p[text()='Welcome to OpenCart!']")
	WebElement Textexist;
	
	public boolean PageExist()
	{
		try
		{
			return Textexist.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	

}
