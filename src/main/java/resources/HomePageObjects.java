
package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePageObjects 
{
	public WebDriver driver;
	//WebElement element;
	
	
	public HomePageObjects (WebDriver driver)// Constructor and point to the local variable
	{
		this.driver= driver;
	}
	

	@FindBy (xpath="//input[@id='email']") WebElement emailname;
	@FindBy (xpath="//input[@id='pass']") WebElement password;
	@FindBy (id="send2") WebElement submit;
	
	@FindBy (xpath="//p[@class='welcome-msg']") WebElement welcomem;
	
	public String login_demo(String ename, String pword)
	{
		//System.out.println("Entered 2TCs--Login Demo TCs");
		
		emailname.sendKeys(ename);
		//System.out.println("Provided email");
		password.sendKeys(pword);
		submit.click();	
		String Pagetitle=driver.getTitle();
		return Pagetitle;
		
	}
	
	public void dashboard()
	{
		String text1 =welcomem.getText();
		if (text1.contentEquals("WELCOME, ANBARASU T T!"))
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
