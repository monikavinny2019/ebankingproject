package com.ebankingprpject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebankingproject.PageObject.HomePage;
import com.ebankingproject.PageObject.LoginPage;
import com.ebankingproject.PageObject.MyAccount;
import com.ebankingproject.TestBase.BaseClass;
import com.ebankingproject.Utilities.DataProviders;


public class TC_003_LoginDataDrivenTest extends BaseClass{

	@Test(dataProvider ="LoginData", dataProviderClass =DataProviders.class)
	public void test_LoginDDT(String email, String password, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			HomePage hp = new HomePage(driver);
			hp.ClickLogin();
			

			LoginPage lp = new LoginPage(driver);
			lp.setemail(email);
			lp.setpassword(password);
			lp.clicklogin();

			MyAccount macc=new MyAccount(driver);
			boolean targetpage = macc.PageExist();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					//macc.clickLogout();
					System.out.println("valid");
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					MyAccount myaccpage = new MyAccount(driver);
					System.out.println("invalid");
					//myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}

}
