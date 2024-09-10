package TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resource.*;


public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getReport();
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass");
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path = null;
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	public void onFinish(ITestResult result) {
		extent.flush();
	}


}
