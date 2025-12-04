package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccPage extends BasePage{
	
	//constructor

	public CreateAccPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	//elements using Locators
	
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name_txtbox;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement mail_txtbox;
	
	@FindBy(xpath="//input[@name='organisationName']")
	WebElement organisation_txtbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password_txtbox;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement btn_createAcc;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement link_login;
	
	@FindBy(xpath="//h1[normalize-space()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//p[@id='undefined-form-item-message']")
	WebElement error_msg;
	
	@FindBy(xpath="//section//div[contains(text(),'This email is already registered')]")
	WebElement error_popup_mailExist;
	
	public void enter_name(String name)
	{
		name_txtbox.sendKeys(name);
	}
	
	public void enter_mail(String mail)
	{
		mail_txtbox.sendKeys(mail);
	}
	
	public void enter_orgname(String orgname)
	{
		organisation_txtbox.sendKeys(orgname);
	}
	
	public void enter_password(String pwd)
	{
		password_txtbox.sendKeys(pwd);
	}
	
	public void click_createACC()
	{
		btn_createAcc.click();
	}
	
	public String dashboard_visibility()
	{
		return(dashboard.getText());
		
	}
	
	public String error_text()
	{
		return(error_msg.getText());
	}
	
	public String error_already_mail_exists()
	{
		return(error_popup_mailExist.getText());
	}
	
	
	
	public void click_login()
	{
		link_login.click();
	}

}
