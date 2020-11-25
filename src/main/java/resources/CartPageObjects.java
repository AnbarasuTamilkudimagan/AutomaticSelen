package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageObjects 
{
	public WebDriver driver;
	//WebElement element;
	
	
	public CartPageObjects (WebDriver driver)// Constructor and point to the local variable
	
	{
		this.driver= driver;
	}
	

	@FindBy (css="input[class='input-text qty']") WebElement updateqtyvar;
	
	@FindBy (css="button[class='button btn-update']") WebElement updateButton;
	@FindBy (css="p[class='item-msg error']") WebElement UpdateQtyErrorMessage;
	@FindBy (css="//button[class='button2 btn-empty']") WebElement EmptyCartaction;
	
	
	
	public boolean updateQty() throws InterruptedException
	{
		boolean text1;
		String text2 = null;
		String pageTitlename = driver.getTitle();
		System.out.println("page title is  "+pageTitlename);
		System.out.println("Entered in Update qty--cart page obejcts");
		updateqtyvar.sendKeys("1000");
		System.out.println("Updated the qty");
		Thread.sleep(1000);
		updateButton.click();
		System.out.println("Update button clicked");
		text2= UpdateQtyErrorMessage.getText();
		System.out.println(text2);
		text1=UpdateQtyErrorMessage.getText().contains("The maximum quantity allowed for purchase is 500.");
		if (text1)
			{
				EmptyCartaction.click();
				text2= UpdateQtyErrorMessage.getText();
						System.out.println(text2);
						//Boolean result= True;
				
			}
		else
			{
				System.out.println("User is not updated qty more than 500");
			}
		
		return true;
		//return driver;
		
	}
}
