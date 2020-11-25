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


public class CustomListenerTest extends CommonBrowser implements ITestListener

{		
	ExtentReports ex=Extendreportgen.getObject(); //gettign from Extend report class and Method
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result)
	{
		test=ex.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

		//String text23 = result.getMethod().getMethodName();
		//test = ex.createTest(text23);

	}

	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS,"Test Passes");
		//test.log(Status.PASS, "Test Passes Successfully");
		
		
	}

	public void onTestFailure(ITestResult result) 
	{
		extentTest.get().fail(result.getThrowable());
		//test.fail(result.getThrowable());
		WebDriver driver = null;
		
		String testCaseName =result.getMethod().getMethodName();
		Object testObject = result.getInstance();
		Class<?> clazName= result.getTestClass().getRealClass();
		try {
			driver = (WebDriver)clazName.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testCaseName), testCaseName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		ex.flush();
	}

}
