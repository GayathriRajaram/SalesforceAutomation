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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReports {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static GenerateReports obj;
	private GenerateReports() {
		
	}
	public static GenerateReports getInstane() {
		if(obj==null) {
			obj=new GenerateReports();
		}
		return obj;
	}
	public void startExtentReports() {
		htmlReporter =new ExtentHtmlReporter(Constants.GENERATE_REPORT_PATH);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Salesforce");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "TestSree");
		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("SalesForce regression tests");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	public void startsingleTestReport(String testname) {
		logger=extent.createTest(testname);
	}
	
	public void logTestinfo(String message) {
		logger.log(Status.INFO,  message);
	}
	public void logTestpassed(String testcaseName) throws IOException {
		
		logger.log(Status.PASS,MarkupHelper.createLabel(testcaseName + "is passTest",ExtentColor.GREEN )) ;
		//attachScreeshot(Constants.GENERATE_REPORT_PATH);
	}
	public void logTestfail(String testcaseName) throws Exception {
		logger.log(Status.FAIL,MarkupHelper.createLabel(testcaseName  + "is Failed",ExtentColor.RED));
		logger.log(Status.FAIL, testcaseName, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
	

		}
	public void logTestskip(String testcaseName) {
		logger.log(Status.SKIP, MarkupHelper.createLabel(testcaseName  +"is skipped ", ExtentColor.BLACK));
	}
	
	public void endReport() {
		extent.flush();
	}
	public void logTestFailedWithException(Exception exception) {
		logger.log(Status.ERROR,exception);

	}
   public void attachScreeshot(String path) throws IOException {
		
		logger.addScreenCaptureFromPath(path);
	}
	
}
