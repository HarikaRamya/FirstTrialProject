package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ItestListenerImpl extends ExtentReportListener implements ITestListener {
	
	private static ExtentReports extent;

	public void onTestStart(ITestResult result) {
		extent=setUp();
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("Execution started");

	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("Execution Finished");

	}

}
