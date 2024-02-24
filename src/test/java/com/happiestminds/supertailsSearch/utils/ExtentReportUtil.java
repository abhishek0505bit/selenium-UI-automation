package com.happiestminds.supertailsSearch.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

// This class provides utility methods for Extent Reports functionality
public class ExtentReportUtil {

	// ExtentReports instance
	public static ExtentReports extent = new ExtentReports();

	// ExtentSparkReporter instance for report generation
	public static ExtentSparkReporter reporter = new ExtentSparkReporter(
			System.getProperty("user.dir") + "\\target\\reports\\extent-report.html");

	// ExtentTest logger
	public static ExtentTest logger1;

	static {
		// Attaching the ExtentSparkReporter to the ExtentReports instance
		extent.attachReporter(reporter);
	}

}
// The use of the static block in the code you've provided allows for the
// attachment of the ExtentSparkReporter to the ExtentReports instance when the
// class is loaded. The static block is executed when the class is loaded into
// memory, ensuring that this attachment is performed only once when the class
// is initialized. This is a common approach to perform one-time initializations
// in Java, and it ensures that the attachment of the reporter is a part of the
// class's static initialization process, making it available to all instances
// of the class.

