package com.APItest.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testAPI.constants.SourcePath;

public class GenerateReports {
	protected static ExtentReports reports;
	protected static ExtentTest test;
	private static String resultpath = SourcePath.GENERATE_REPORT_PATH;		
	public static void teststart() {
		test = reports.startTest(test.getTest().getName());
		test.log(LogStatus.INFO, test.getTest().getName());
		System.out.println(test.getTest().getName());
		System.out.println(test.getTest().getName());
	}
	public static void onstart() {
		System.out.println(resultpath + "  ReportLocation");
		reports = new ExtentReports(resultpath + "ExtentReport.html");
		test = reports.startTest("");
		//reports.startTest(m.getName());
	}
	public static void onSuccess() {
		test.log(LogStatus.PASS, "Test is pass");

	}
	public static void onFailure() {
		test.log(LogStatus.FAIL, "Test is fail");

	}
	public static void onSkip() {
		test.log(LogStatus.SKIP, "Test is skipped");

	}
	public static void onend() {
		reports.endTest(test);
		reports.flush();

	}
}
