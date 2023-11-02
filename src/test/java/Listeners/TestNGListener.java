package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporter;
import Resources.TakeScreenshot;

public class TestNGListener implements ITestListener {

	WebDriver wd=null;
	TakeScreenshot ts=new TakeScreenshot();
	ExtentTest extenTest;
	ExtentReports extentReport=ExtentReporter.getExtentReport();
	ThreadLocal<ExtentTest> extentThread= new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		extenTest = extentReport.createTest(result.getName()+" execution started");
		 extentThread.set(extenTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentThread.get().log(Status.PASS, result.getName()+" got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentThread.get().fail(result.getThrowable());
		
		try {
			wd=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("wd").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
		ts.getScreenshot(wd, result.getName());
		extentThread.get().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png", result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
