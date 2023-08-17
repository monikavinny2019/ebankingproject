package com.ebankingproject.PageObject;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegisterPage extends BasePage{

	public AccountRegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
//Element
	@FindBy(id="input-username")
			WebElement username;
	
	@FindBy(id="input-firstname")
	        WebElement firstname;
	@FindBy(id="input-lastname")
	        WebElement lastname;
	
	@FindBy(id="input-email")
	        WebElement email;
	
	@FindBy(id="input-country")
    WebElement select;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="Register")
	WebElement Register;
	
	
	@FindBy(id="terms")
	WebElement checkbox;
	
	@FindBy(id="email")
	WebElement TextEmail;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUp;
	
	@FindBy(name="action")
	WebElement Signuplogin;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement recaptcha;
	@FindBy(xpath="//iframe[@title='reCAPTCHA']")
	WebElement iframe;
	@FindBy(xpath="//h2[normalize-space()='Almost there!']")
	WebElement msgConfirmation;
	
	public void setEmail(String email)
	{
		TextEmail.click();
		TextEmail.sendKeys(email);
	}
	public void ClickCheckbox()
	{
		checkbox.click();
	}
	
	public void Recaptcha() throws InterruptedException
	{
	      
		driver.switchTo().frame(iframe);
		System.out.print("Swithched to Iframe");
		recaptcha.click();
		driver.switchTo().defaultContent();
		System.out.print("Swithched to windows");
		Thread.sleep(10000);
		
	}
	public void SignUp()
	{
		
		SignUp.click();
		
		
	}
	
	public void signuplogin() throws InterruptedException
	{
		Signuplogin.click();
		Thread.sleep(2000);
	}
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}



}}
