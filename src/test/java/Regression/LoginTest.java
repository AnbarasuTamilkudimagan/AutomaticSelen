package Regression;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.CommonBrowser;
import resources.Constants;
import resources.HomePageObjects;
import resources.MobileMenuPageObjects;

//@Listeners(CustomListener.class)
public class LoginTest extends CommonBrowser
{


	private static final TimeUnit SECONDS = null;

	@BeforeMethod
	void verifyLogin() throws IOException
	{
		driver =startBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	void verifyPropFile() throws IOException
	{
		Properties properties = propfile();
	}
	
	
	@Test(enabled =true, priority=1)
	void LoginTestcaseTest() throws IOException, InterruptedException
	{
		
		HomePageMethod();
		HomePageObjects home=PageFactory.initElements(driver, HomePageObjects.class);
		
		home.dashboard();
		System.out.println("------------------");
		System.out.println("FIRST TESTCASE");
		System.out.println("------------------");
		//Seocnd verification
		MobilePageMethod();

		List<WebElement> hrefList =driver.findElements(By.xpath("//li[@class='item last']/div/h2/a"));
		
		System.out.println("Before Sorted the Products");
		System.out.println("---------------------------------");
		for (WebElement we: hrefList)
		{
			System.out.print(we.getText()+" ");
		}
		
		Select selectDropdown = new Select (driver.findElement(By.xpath("//div[@class='sorter']/div/select")));
		selectDropdown.selectByVisibleText("Name");
		
		List<WebElement> hrefList1 =driver.findElements(By.xpath("//li[@class='item last']/div/h2/a"));
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("After Sorted the Products");
		System.out.println("---------------------------------");
		for (WebElement we1: hrefList1)
		{
			System.out.print(we1.getText()+" ");
		}
		System.out.println();
		System.out.println("---------------------------------");
		//driver.close();
	}
	
	  @Test(enabled =true, priority=2) 
	  void CompareCostofTwoProductTest() throws IOException, InterruptedException 
	  {
	
		  HomePageMethod(); 
		  HomePageObjects home=PageFactory.initElements(driver, HomePageObjects.class); 
		  home.dashboard();
		  System.out.println("------------------");
			System.out.println("SECOND TESTCASES");
			System.out.println("------------------");
		  MobilePageMethod();
		  
		  String ProductValueinMenuPage = ProductPageMethod(); 
		  String ProductValueinDetailPageVAlue = ProductDetailsPage(); 
		  
		  if (ProductValueinMenuPage.contentEquals(ProductValueinDetailPageVAlue)) 
			  {
				  System.out.println("Value present in Details page is EQUAL"); 
			  } 
		  else 
			  {
				  System.out.println("Value present in Details page is NOT EQUAL"); 
			  } 
	  }
	  
	  
	  
	  @Test(enabled =true, priority=3) 
	  void CanaddAvailableProductsqtyTest() throws IOException, InterruptedException 
	  {
	
		  HomePageMethod(); 
		  HomePageObjects home=PageFactory.initElements(driver, HomePageObjects.class); 
		  home.dashboard();
		  System.out.println("------------------");
			System.out.println("THIRD TESTCASES");
			System.out.println("------------------");
		  MobilePageMethod();
		  
		  //Add to cart from Sony Xperia
		  boolean AddtocartValue = AddToCart();
		 
		  
		  //String ProductValueinMenuPage = ProductPageMethod(); 
		  //String ProductValueinDetailPageVAlue = ProductDetailsPage(); 
		  
		//  if (ProductValueinMenuPage.contentEquals(ProductValueinDetailPageVAlue)) 
			//  {
				//  System.out.println("Value present in Details page is EQUAL"); 
			  //} 
		  //else 
			//  {
				//  System.out.println("Value present in Details page is NOT EQUAL"); 
			  //} 
	  }
	  
	  
	  private boolean AddToCart() {
		// TODO Auto-generated method stub
		return false;
	}

	@AfterMethod 
	  public void closeDriver() 
	  { 
		 driver.close(); 
	  }
	 
	
}
