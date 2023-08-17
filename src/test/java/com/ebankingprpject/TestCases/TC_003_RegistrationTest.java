package com.ebankingprpject.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.ebankingproject.PageObject.AccountRegisterPage;
import com.ebankingproject.PageObject.HomePage;
import com.ebankingproject.TestBase.BaseClass;

public class TC_003_RegistrationTest extends BaseClass{
	@Test(groups={"regression","sanity"})
	public void test_account_Registration()
	{
	
		try
		{
			Actions actions = new Actions(driver);
	AccountRegisterPage regpage=new AccountRegisterPage(driver);
	HomePage hp=new HomePage(driver);
	hp.SignUp();
	//regpage.SignUp();
	Thread.sleep(2000);
	regpage.setEmail(randomeString()+"@gmail.com");
	//regpage.setEmail("monika.csengg@gmail.com");
	regpage.ClickCheckbox();
	regpage.Recaptcha();
	regpage.signuplogin();
	
	String confmsg=regpage.getConfirmationMsg();
	
	Assert.assertEquals(confmsg, "Almost there!");
	}
	catch(Exception e)
	{
		Assert.fail();
		logger.info(" Failed TC_003_RegistrationTest");

	}

	
	}
	
	/*catch(Exception e)
	{
		AssertJUnit.fail();
	}
   logger.info(" Finished TC_003_RegistrationTest");
*/

}
