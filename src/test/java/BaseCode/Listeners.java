package BaseCode;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReportGenerator.ExtentReportNG;

public class Listeners extends basecode implements ITestListener {

	ExtentTest test;
	ExtentReports extent =ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
	test=extent.createTest(result.getMethod().getMethodName());

	extentTest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
    		
	 extentTest.get().log(Status.PASS, "Test passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());//console output
    	try {
			Driver = (WebDriver)  result.getTestClass().getRealClass().getField("Driver")
					.get(result.getInstance());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),Driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    	//ScreenShot,Attach to report
		
		

	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		

	}
}
