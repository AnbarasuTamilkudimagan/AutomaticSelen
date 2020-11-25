package Sanity;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import resources.CommonBrowser;
import resources.HomePageObjects;

import org.testng.annotations.Test;

public class CTest extends CommonBrowser
{
	WebDriver driver;
	@BeforeMethod
	public void verifyLogin() throws IOException
	{
		driver=startBrowser();
	}
	
	@BeforeMethod
	public void verifyPropFile() throws IOException
	{
		Properties properties = propfile();
	}
	
	@Test(enabled =true, priority=1)
	public void thirdTest()
	{
		System.out.println("Third test CTest-Sanity");
		HomePageMethod();
		
		System.out.println("Third test CTest-ENDDD");
		//Assert.assertEquals("Anbu", "My Account");
	}
	
	  @AfterMethod 
	  public void closeDriver() 
	  { 
		 driver.close(); 
	  }
	  
}
