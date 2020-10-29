package resources;

import java.lang.module.ModuleDescriptor.Exports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extendreportgen 
{
	
	static ExtentReports extent;
	public static ExtentReports getReportObject() //This reusable method will call everywhere for rpeorts
	{
		String path = System.getProperty("user.dir")+ "\\extent_report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Autmation Report");
		reporter.config().setDocumentTitle("Testcase results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kishore");
		
		return extent;
		
	}
	
}
