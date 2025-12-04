package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateAccPage;
import testBase.BaseClass;

public class TC002_InvalidEmailCheck extends BaseClass 
{
	
	@Test
	public void verify_InvalidEmail()
	{
		
		// Entering invalid email address
		
		CreateAccPage cp = new CreateAccPage(driver);
		cp.enter_name(setRandomString().toUpperCase());
		cp.enter_mail(setRandomString().toLowerCase()+"txt.in");
		cp.enter_orgname(setRandomString().toLowerCase());
		cp.enter_password(setRandomAlphaNum());
		cp.click_createACC();
		if(cp.error_text().equals("Invalid email address"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}

}
