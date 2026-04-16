package seleniumRaj.Test_ReusableComponenets;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import seleniumRaj.DataResources.ExtenrReporterNg;

public class Listeners extends Base_ReusableTests implements ITestListener {
	ExtentTest test;
	ExtentReports report = ExtenrReporterNg.getReportObject(); // Calling Static Method using className
	ThreadLocal<ExtentTest> threadSafe = new ThreadLocal();

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName()); // To get the TestCase Name
		threadSafe.set(test); // it wll create a unique thread id
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadSafe.get().log(Status.PASS, "TestCase Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) { // if test is reached this block we are failing you and get the
													// error
		// Get the Screenshot on TestFailure
		// test.log(Status.FAIL, "TestCase is Failed");
		// To get Driver of that specific test case using result variable
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test.fail(result.getThrowable()); // it will through Error msg
		threadSafe.get().fail(result.getThrowable());
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SS and Attach it to Report
		threadSafe.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
