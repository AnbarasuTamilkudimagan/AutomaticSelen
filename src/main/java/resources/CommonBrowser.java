package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonBrowser 
{
	public static WebDriver driver;
	//public static WebDriver startBrowser(String browser, String url) throws IOException
	public static Properties properties;
	
	
	public static WebDriver startBrowser() throws IOException
	
	{
		Properties properties = propfile();
	
		String browser = properties.getProperty("browser");
		
		if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://Kishore//Selenium-Appium//geckodriver-v0.27.0-win64//geckodriver.exe");//if u give Webdriver then it wont work
			driver = new FirefoxDriver();
			//driver.get(url);
			//driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Kishore//Selenium-Appium//chromedriver_win32//chromedriver.exe");//if u give Webdriver then it wont work
			driver = new ChromeDriver();
		}
		
		String urlname=properties.getProperty("url");
		driver.get(urlname);
		//driver.get(Constants.url); //Using Interface-COnstants
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public static  Properties propfile() throws IOException
	{	
		properties = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Anbarasu T//SELENIUM_ANBU//MavenExamples//src//main//java//resources//browser.properties");
		properties.load(fis);
		return properties;
	}
	
	//public String getScreenShotFailed(String testMethodName) 
	public String takeScreenShotOnTestFailure(String testCaseName,WebDriver driver) throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//try {
			String destination=System.getProperty("user.dir")+"//screenshots//"+testCaseName+".jpg";
			FileUtils.copyFile(scrFile, new File(destination));
			return destination;
		//} catch (IOException e) {
		//	e.printStackTrace();
		
		//}
		
	}
	
	
	public void HomePageMethod()
	{
		
		//System.out.println("Entered 2TCs--Home page method");
		HomePageObjects home=PageFactory.initElements(driver, HomePageObjects.class);
		
		String emailvalue = properties.getProperty("emailp");
		String pwdvalue = properties.getProperty("pwdp");
		//System.out.println(emailvalue);
		//System.out.println(pwdvalue);
		String PageTitle=home.login_demo(emailvalue	, pwdvalue); //using COnstants */
		
		if (PageTitle.equalsIgnoreCase("My Account"))
		{
			Assert.assertEquals(PageTitle, "My Account");
			System.out.println("Success, & Verified Page title after login is --"+PageTitle);
		}
		else
		{
			Assert.assertEquals(PageTitle, "My Account");
			System.out.println("FAILURE, & Page title after login is --"+PageTitle);
		}
	}
	
	public void MobilePageMethod()
	{
		MobileMenuPageObjects MobileMenuL=PageFactory.initElements(driver, MobileMenuPageObjects.class);
		String MobilePageName=MobileMenuL.MobileMenu();
		System.out.println("Mobile Page name is "+MobilePageName);
		Assert.assertEquals(MobilePageName, "Mobile");

	}
	
	public String ProductPageMethod()
	{
		MobileMenuPageObjects MobileMenuL=PageFactory.initElements(driver, MobileMenuPageObjects.class);
		String ProductValue=MobileMenuL.MobilePriceMethod();
		System.out.println("First Product Price is  "+ProductValue);
		//Assert.assertEquals(ProductValue, "Mobile");
		return ProductValue;

	}
	
	public String ProductDetailsPage()
	{
		MobileMenuPageObjects MobileMenuL=PageFactory.initElements(driver, MobileMenuPageObjects.class);
		String ProductValueinDetailsPage=MobileMenuL.ProductDetailMethod();
		System.out.println("Product price in Details page "+ProductValueinDetailsPage);
		//Assert.assertEquals(ProductValueinDetailsPage, "Mobile");
		return ProductValueinDetailsPage;
	}
	
	/*Set<String> ids = driver.getWindowHandles();
	Iterator<String> it = ids.iterator();
	String parentwindow = it.next();
	driver.switchTo().window(parentwindow);*/
}
