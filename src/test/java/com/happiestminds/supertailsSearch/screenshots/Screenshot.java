package com.happiestminds.supertailsSearch.screenshots;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.happiestminds.supertailsSearch.setupBrowser.Browser;
import com.happiestminds.supertailsSearch.utils.Logs;

//This class is responsible for capturing screenshots during test execution
public class Screenshot extends Browser {

	// method to capture screenshot
	public static String captureScreenshot(String fileName) {

		String screenshotPath = "";

		try {
			// Take a screenshot of the entire page
			Logs.log("info", "::: Taking screenshot 📷📷 :::");// logging that capture is done

			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);// temporary stored

			// Save the screenshot to a desired location
			File destination = new File(System.getProperty("user.dir") + "\\target\\Screenshots\\" + fileName + ".png");
			FileUtils.copyFile(sourceFile, destination);

			screenshotPath = destination.getAbsolutePath(); // Get the absolute path of the captured screenshot
			Logs.log("pass", "Taken screenshot : capture done");// logging that capture is done
		} catch (Exception e) {

			// handling exception while taking screenshot
			Logs.log("error", "Exception at Capture - Screenshot due to " + e);
		}

		return screenshotPath;
	}

}