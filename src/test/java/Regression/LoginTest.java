package Regression;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.CommonBrowser;
import resources.Constants;
import resources.HomePageObjects;

public class LoginTest extends CommonBrowser
{
	@BeforeTest
	void verifyLogin() throws IOException
	{
		driver =startBrowser();
	}
	
	@BeforeTest
	void verifyPropFile() throws IOException
	{
		Properties properties = propfile();
	}
	
	@Test
	void Testcaseone() throws IOException
	{
		//WebDriver driver=CommonBrowser.startBrowser("chrome", "http://live.demoguru99.com/index.php/customer/account/login/");
		//driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.get(Constants.url); //Using Interface-COnstants
		driver.manage().window().maximize();
		
		HomePageObjects home=PageFactory.initElements(driver, HomePageObjects.class);
		//home.login_demo("anbarasu2808@gmail.com", "Kishore@03");
		String emailvalue = properties.getProperty("emailp");
		String pwdvalue = properties.getProperty("pwdp");
		
		home.login_demo(emailvalue, pwdvalue); //using COnstants */
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentwindow = it.next();
		driver.switchTo().window(parentwindow);
		
		System.out.println("before execute Dashboard");
		home.dashboard();
		System.out.println("After execute Dashboard");
	}
}
