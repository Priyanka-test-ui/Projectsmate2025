package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CreateAccPage;
import testBase.BaseClass;


public class TC003_AlreadyRegEmail extends BaseClass{
	
	
	@Test
	public void verify_SignupUsingAlreadyRegistered_Email() 
	{
		
		CreateAccPage cp = new CreateAccPage(driver);
		cp.enter_name(setRandomString().toUpperCase());
		cp.enter_mail(p.getProperty("email"));
		cp.enter_orgname(setRandomString().toLowerCase());
		cp.enter_password(setRandomAlphaNum());
		cp.click_createACC();
		
		if(cp.error_already_mail_exists().contains("This email is already registered"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	
		
	}

}
