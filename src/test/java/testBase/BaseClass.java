package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public Properties p;
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() throws IOException
	{
		FileInputStream file = new FileInputStream(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String setRandomString()
	{
		String generated_randomString = RandomStringUtils.randomAlphabetic(5); 
		return generated_randomString;
	}
	
	 
	
	public String setRandomNum()
	{
		
		String generated_randomNumber = RandomStringUtils.randomNumeric(9); 
		return generated_randomNumber;
	}
	
	public String setRandomAlphaNum()
	{
		
		String generated_String = RandomStringUtils.randomAlphabetic(5);
		String generated_Number = RandomStringUtils.randomNumeric(9); 
		return (generated_String + "#" + generated_Number) ;
	}
	
	public String captureScreen(String tname) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot) driver;
		File sourcefile = ss.getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String targetfile_path = ".//screenshots/"+ tname + "_" + timestamp +".png";
		
		File targetfile = new File(targetfile_path);
		sourcefile.renameTo(targetfile);
		return targetfile_path;
	}

}
