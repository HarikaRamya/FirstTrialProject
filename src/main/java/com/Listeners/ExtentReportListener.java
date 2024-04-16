package com.Listeners;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {
	
	public static ExtentSparkReporter report=null;
	public static ExtentReports extent=null;
	public static ExtentTest test=null;
	
	
	public static ExtentReports setUp() {
		
		String reportLocation="./Reports/Extent_Report.html";
		report=new ExtentSparkReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report location initiated.....");
		
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "name");
		extent.setSystemInfo("OPerating System", System.getProperty("os.name"));
		extent.setSystemInfo("user Name", System.getProperty("user.name"));
		System.out.println("System info set in extent Report");
		
		
		return extent;
	}
	
	
	public static void testStepHandle(String testStatus, WebDriver driver, ExtentTest extentTest) throws Exception {
		switch(testStatus) {
		case "FAIL":
			extentTest.fail(MarkupHelper.createLabel("Test case is Failed: ", ExtentColor.RED));
			
			extentTest.addScreenCaptureFromPath(captureScreenShot(driver));
			if(driver!=null) {
				driver.quit();
			}
			break;
		case "PASS":
			extentTest.pass(MarkupHelper.createLabel("Test case is passed:", ExtentColor.GREEN));
			break;
		
		default:
			break;
		}
	}
	
	public static String captureScreenShot(WebDriver driver) throws Exception {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		String dest="C:\\Users\\Ramya Harika\\cucumberBDD\\BDDFramework\\screenShots\\"+getCurrentDateAndTime()+".png";
		File target=new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}
	
	private static String getCurrentDateAndTime() {
		String str=null;
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSSS");
		Date date=new Date();
		dateFormat.format(date);
		return str;
	}
}
