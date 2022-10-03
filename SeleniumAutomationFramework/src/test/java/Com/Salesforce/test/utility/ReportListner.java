package Com.Salesforce.test.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Com.Salesforce.test.basetest.BaseTest;

public  class ReportListner extends BaseTest implements ITestListener {

	@Override

	public void onTestSuccess(ITestResult result) {
		GenerateReports.logger.log(Status.PASS,MarkupHelper.createLabel(result.getName()+ "is passTest",ExtentColor.GREEN )) ;

	}

	@Override
	public void onTestFailure(ITestResult result) {
		GenerateReports.logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()  + "is Failed",ExtentColor.RED));
		String failedpath=Takescreeshotofscreenfailed();
		try {
			GenerateReports.logger.addScreenCaptureFromPath(failedpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * try { GenerateReports.logger.log(Status.FAIL,result.getName() ,
		 * MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build()); }
		 * catch (IOException e) {
		 * GenerateReports.logger.fail("Failed but screenschot couldn't take"); }
		 */

	}

	@Override
	public void onFinish(ITestContext Result) {
		System.out.println("Test finished");
	}

	@Override
	public void onStart(ITestContext Result) {
		System.out.println("Test is starting");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		System.out.println("Test finished");

	}
}
