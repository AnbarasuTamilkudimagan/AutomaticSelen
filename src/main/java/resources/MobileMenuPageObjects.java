package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MobileMenuPageObjects 
{
	private WebDriver driver;

	public MobileMenuPageObjects (WebDriver driver)// Constructor and point to the local variable
	{
		this.driver= driver;
	}
	
	//@FindBy (xpath="//li[@class='level0 nav-1 first']") WebElement MobileMenu;
	@FindBy (css="li[class=\"level0 nav-1 first\"]") WebElement MobileMenu;
	
	
	public String MobileMenu()
	{
		MobileMenu.click();
		String MobileMenuTitle = driver.getTitle();
		return MobileMenuTitle;
	}
	
}
