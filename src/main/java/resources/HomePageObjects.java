package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePageObjects 
{
	public WebDriver driver;
	
	public HomePageObjects (WebDriver driver)// Constructor and point to the local variable
	{
		this.driver= driver;
	}
	@FindBy (xpath="//input[@id='email']") WebElement emailname;
	@FindBy (xpath="//input[@id='pass']") WebElement password;
	@FindBy (id="send2") WebElement submit;
	@FindBy (xpath="//p[@class='welcome-msg']") WebElement welcomem;
	
	public void login_demo(String ename, String pword)
	{
		emailname.sendKeys(ename);
		password.sendKeys(pword);
		submit.click();	
		
	}
	
	public void dashboard()
	{
		System.out.println("Kishore --Enetred Dashboard");
		String text =welcomem.getText();
		System.out.println("got welcome message"+text);
		if (text.contentEquals("WELCOME, ANBARASU T T!"))
			{
				Assert.assertTrue(true);
				System.out.println("SUCCESS MAIN PAGE");
			}
		else
			{
				Assert.assertTrue(false);
				System.out.println("FAILURE MAIN PAGE");
			}
	}
	
}
