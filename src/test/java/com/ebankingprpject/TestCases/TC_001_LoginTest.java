package com.ebankingprpject.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebankingproject.PageObject.HomePage;
import com.ebankingproject.PageObject.LoginPage;
import com.ebankingproject.PageObject.MyAccount;
import com.ebankingproject.TestBase.BaseClass;

public class TC_001_LoginTest extends BaseClass {
	@Test(groups={"sanity","master"})
	public void test_Login()
	{
		logger.info("Starting TC_001_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			//hp.ClickRegister();
			hp.ClickLogin();
			
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setemail(rb.getString("email")); // valid email, get it from properties file
			
			lp.setpassword(rb.getString("password")); // valid password, get it from properties file
			
			lp.clicklogin();
			
			MyAccount macc=new MyAccount(driver);
			
			boolean targetpage=macc.PageExist();
						
			AssertJUnit.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			AssertJUnit.fail();
		}
	logger.info(" Finished TC_001_LoginTest");
		
	}
	
	
}





