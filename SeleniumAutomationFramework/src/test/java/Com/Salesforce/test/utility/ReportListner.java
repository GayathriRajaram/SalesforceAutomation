package Com.Salesforce.test.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public  class ReportListner implements ITestListener {

	@Override

	public void onTestSuccess(ITestResult result) {
		GenerateReports.logger.log(Status.PASS,MarkupHelper.createLabel(((ITestContext) GenerateReports.logger).getName()+ "is passTest",ExtentColor.GREEN )) ;
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		GenerateReports.logger.log(Status.FAIL,MarkupHelper.createLabel(((ITestContext) GenerateReports.logger).getName()  + "is Failed",ExtentColor.RED));

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
