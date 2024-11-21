package com.api.Suite.utils;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.relevantcodes.extentreports.DisplayOrder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Reporter;

public class ExtentReportListener implements ITestListener{
	protected static ExtentReports reports;
	protected static ExtentTest test;
	private static String resultpath = getResultPath();


	public static void deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {

			Date d= new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".";
		resultpath = System.getProperty("user.dir") + "/reports/"+fileName;
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	String ReportLocation =  resultpath;

	public void onTestStart(ITestResult result) {

		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		System.out.println(result.getTestClass().getTestName());
		System.out.println(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "Test is pass");

	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "Test is fail");

	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println(ReportLocation + "  ReportLocation");
		reports = new ExtentReports(ReportLocation + "ExtentReport.html",true, DisplayOrder.NEWEST_FIRST);
		test = reports.startTest("");
		reports.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
		// optional
		reports.addSystemInfo("QA", "NameOFQA MEMBER").addSystemInfo(
				"Environment", "STAGING OR QA");
	}

	public void onFinish(ITestContext context) {
		List<String> reporterLogs = Reporter.getOutput();
		for (String log : reporterLogs) {
			test.log(LogStatus.INFO, log);
		}
		reports.endTest(test);
		reports.flush();

	}

	private void appendReporterLogs() {
		List<String> reporterLogs = Reporter.getOutput();
		for (String log : reporterLogs) {
			test.log(LogStatus.INFO, log);
		}
	}
	

}