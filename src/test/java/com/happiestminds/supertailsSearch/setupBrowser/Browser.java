package com.happiestminds.supertailsSearch.setupBrowser;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.happiestminds.supertailsSearch.utils.ExtentReportUtil;
import com.happiestminds.supertailsSearch.utils.Logs;

// This class is responsible for setting up the web browser and configuring WebDriver
public class Browser {

	// declaration of web driver
	public static WebDriver driver;

	// method to set up the browser
	public static WebDriver setup() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("STARTING THE SCENARIO");
		try {

			// sets the driver name to the value with key = browser
			String driverName = readDataFromBrowserinfoProperties("browser");

			// opens the respective web browser defined in properties file
			switch (driverName) {

			case ("chrome"): {
				driver = new ChromeDriver();
				break;
			}

			case ("edge"): {
				driver = new EdgeDriver();
				break;
			}

			case ("firefox"): {
				driver = new FirefoxDriver();
				break;
			}

			}

			// logs the status as pass if successfully opened the browser, also logs in the
			// console
			logger1.log(Status.PASS, "Browser set up successful for browser: " + driverName);
			Logs.log("pass", "browser set up successful");

		} catch (Exception e) {
			// logs the status as fail, when failed to setup the browser
			logger1.log(Status.FAIL, "Failed to setup the browser");
			Logs.log("error", "browser setup unsuccessful");

		}
		return driver;
	}

	// method to navigate to the url
	public static void getURL() {
		driver.get(readDataFromBrowserinfoProperties("url"));
		driver.manage().window().maximize();
	}

	// method to tear down the process, close the browser
	public static void end() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("CLOSING THE SCENARIO");
		try {

			driver.quit();// closes the browser

			// logs the status as pass if browser is closed successfully, also logs in the
			// console
			logger1.log(Status.PASS, "whole scenario passed successfully, closing the browser");
			Logs.log("pass", "browser closed successfully");
		} catch (Exception e) {

			// logs the status as fail if browser is not closed
			logger1.log(Status.FAIL, "Failed to setup the browser");
			Logs.log("error", "browser closing unsuccessful");
		}

	}

	// read the data from properties file
	public static String readDataFromBrowserinfoProperties(String data) {
		String browserData = null;
		try {

			// path to properties file
			String filePath = System.getProperty("user.dir") + "/src/test/resources/browserInfo.properties";
			FileReader filereader = new FileReader(filePath);
			Properties p = new Properties();
			p.load(filereader);
			browserData = p.getProperty(data);// gets the value with key : {data}
		} catch (Exception e) {
			
			// handle the exception if there is any exception while fetching the data
			Logs.log("error","exception at reading data from properties file");
		}
		return browserData;
	}

}
