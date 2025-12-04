package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateAccPage;
import testBase.BaseClass;

public class TC001_CreateAcc extends BaseClass {
	
	
	@Test
	public void verify_acc_registration() throws InterruptedException
	{
		CreateAccPage cp = new CreateAccPage(driver);
		cp.enter_name(setRandomString().toUpperCase());
		cp.enter_mail(setRandomString().toLowerCase()+"@gmail.com");
		cp.enter_orgname(setRandomString().toUpperCase());
		cp.enter_password(setRandomAlphaNum());
		cp.click_createACC();
		Thread.sleep(3000);
		driver.navigate().back();
		
		String dashboard_validation = cp.dashboard_visibility();
		if(dashboard_validation.equals("Dashboard"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	

}
