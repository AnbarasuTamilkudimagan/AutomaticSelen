package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonBrowser 
{
	public static WebDriver driver;
	//public static WebDriver startBrowser(String browser, String url) throws IOException
	public static Properties properties;
	public static WebDriver startBrowser() throws IOException
	
	{
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Anbarasu T//SELENIUM_ANBU//MavenExamples//src//main//java//resources//browser.properties");
		properties.load(fis);
		String browser = properties.getProperty("browser");
		//String url = properties.getProperty("url");
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
		//driver.get(url);
		//driver.manage().window().maximize();
		return driver;
		
	}
	
	public static Properties propfile() throws IOException
	{
		properties = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Anbarasu T//SELENIUM_ANBU//MavenExamples//src//main//java//resources//browser.properties");
		properties.load(fis);
		return properties;
	}
}