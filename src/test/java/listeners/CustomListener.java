package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.CommonBrowser;
import resources.Extendreportgen;

public class CustomListener extends CommonBrowser implements ITestListener

{

	ExtentTest test;
	ExtentReports extentRe = Extendreportgen.getReportObject();
	

	public void onTestStart(ITestResult result) 
	{
		String text = result.getMethod().getMethodName();
		System.out.println("Test Success");
		test= extentRe.createTest(text);
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		test.log(Status.PASS, "TEST DESfasfdgf");
	}


	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Failure and Capture Screenshot");
		test.fail(result.getThrowable());
		
		WebDriver driver = null;
		String testcasename = result.getMethod().getMethodName();
		
		getScreenShotFailed (result.getMethod().getMethodName());
		//getScreenShotPath(testcasename, driver);
		
	}

	

	public void onFinish(ITestContext context) 
	{
		extentRe.flush();
	}

	
	
}
