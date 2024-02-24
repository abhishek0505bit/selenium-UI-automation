package com.happiestminds.supertailsSearch.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.happiestminds.supertailsSearch.excel.Excel;
import com.happiestminds.supertailsSearch.screenshots.Screenshot;
import com.happiestminds.supertailsSearch.utils.ExtentReportUtil;
import com.happiestminds.supertailsSearch.utils.Logs;

public class Page1_Search {

	// driver and WebDriverWait declaration
	WebDriver driver;
	WebDriverWait wait;

//--------------------------------scenario 1 : web elements---------------------------------------------------------

	// element : search box
	@FindBy(xpath = "//input[@id='mainfrm']")
	WebElement searchBox;

	// element : search button
	@FindBy(xpath = "//button[@class='text-link site-header__search-btn site-header__search-btn--submit active']")
	WebElement searchButton;

	// element : my account
	@FindBy(xpath = "//a[@href='/account']")
	WebElement myAccount;

	// element : close login pop up button
	@FindBy(xpath = "//img[@onclick='closeLoginModal()']")
	WebElement closeLoginPopupButton;

//---------------------------------scenario 5 : web Elements-------------------------------------------------------------------------------------

	// element : phone number field
	@FindBy(xpath = "//*[@id=\'userNumber\']")
	WebElement phoneNumberField;

	// element : get otp button
	@FindBy(xpath = "//*[@id=\'getOTPButton\']")
	WebElement getOTPButton;

	// element : otp input field
	@FindBy(xpath = "//*[@id=\'otpForm\']/form/div[2]/input")
	WebElement otpField;

	// element : info popup
	@FindBy(xpath = "//*[@id=\"userInfoOverlay\"]/div/div[1]/div[2]/img")
	WebElement infoPopup;

//----------------------------------------constructor--------------------------------------------------------------------

	// initializes driver, wait and pageFactory elements
	public Page1_Search(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

//-------------------------------------common methods for all scenarios------------------------------------------------	

	// closes login popup
	public void closeLoginPopup() {

		// creating a test step in extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Close Login pop up test");

		try {
			// wait for the close Login pop up button to be visible, then click
			wait.until(ExpectedConditions.visibilityOf(closeLoginPopupButton));
			closeLoginPopupButton.click();

			// log the status as pass if clicked, also log in the console logger
			logger1.log(Status.PASS, "pop up closed");
			Logs.log("pass", "DONE : login popup closed successfully");

		} catch (Exception e) {

			// log if there's a failure while clicking the button
			logger1.log(Status.FAIL, "popup could not be closed due to exception: " + e);
			Logs.log("error", "FAILED : pop up could not be closed due to " + e);
		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

	// provides search query in the search box
	public void provideSearchQuery(String searchQuery) {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Provide Search Query Test");

		try {
			// wait for the search box to be visible, then send keys
			wait.until(ExpectedConditions.visibilityOf(searchBox));
			searchBox.sendKeys(searchQuery);

			// log the status as pass if search query provided, also log in the logger
			logger1.log(Status.PASS, "Provided search query: " + searchQuery);
			Logs.log("pass", "DONE : user entered the search query successfully");

		} catch (Exception e) {

			// log if there's a failure while providing search query
			logger1.log(Status.FAIL, "Search query couldn't be provided due to exception: " + e);
			Logs.log("error", "FAILED : search query couldn't be provided due to " + e);

		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();
	}

	// clicks the search button
	public void clickSearchButton() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Click Search Button Test");

		try {

			// wait for the search box to be visible and clickable, then click it and send
			// keys
			wait.until(ExpectedConditions.visibilityOf(searchBox));
			wait.until(ExpectedConditions.elementToBeClickable(searchBox));
			searchBox.click();
			searchBox.sendKeys(Keys.ENTER);

			// log the status as pass if search button clicked, also log in console
			logger1.log(Status.PASS, "Clicked search button");
			Logs.log("pass", "DONE : user searched for the provided query");

		} catch (Exception e) {

			// log if there's a failure while clicking the search button
			logger1.log(Status.FAIL, "Search button couldn't be clicked due to exception: " + e);
			Logs.log("error", "FAILED : search query couldn't be searched due to " + e);

		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

	// clicks my account button
	public void clickMyAccount() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Click My Account Button Test");

		try {
			// wait for visibility of my account icon, then click
			wait.until(ExpectedConditions.visibilityOf(myAccount));
			myAccount.click();

			// log the status as pass if clicked on my account, also log in console
			logger1.log(Status.PASS, "Clicked on 'My Account' link");

		} catch (Exception e) {
			// log if there's a failure whlle clicking on my account
			logger1.log(Status.FAIL, "'My Account' link couldn't be clicked due to exception: " + e);

		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();
	}

//----------------------------scenario 3: blank search query methods------------------------------------------------------------------------

	// it will check whether the user is on the same page or redirected to any other
	// page
	public void verifyPageTitle() {

		// crating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Verify whether user is on same page Test");

		try {

			String currentTitle = driver.getTitle();// stores the current title
			String expectedTitle = "Online Pet Store, Shop Pet Supplies and Products: Supertails";// expected title

			// performing assertion whether the current title is same as expected title
			Assert.assertEquals(currentTitle, expectedTitle);

			// log the status as pass if search results found, also log in console
			logger1.log(Status.PASS, "Verified : User is on the same page");
			Logs.log("pass", "PASS : User is on the same page");
		} catch (AssertionError e) {

			// implicity wait of 5 sec
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// ADD SCREENSHOT TO THE EXTENT REPORT
			String screenshotPath = Screenshot.captureScreenshot("scenario3");
			logger1.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); // Add
			// log the status as fail if it fails
			logger1.log(Status.FAIL, "User is not in the same page even after searching for the blank query");
			Logs.log("error", "FAILED : user is not on the same page even after searching for the blank query " + e);
			// fails as it is showing results for blank query
			Assert.fail("showing results for blank query");

		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();
	}

//-----------------------------scenario 5: search functionality with login methods---------------------------------------

	// enters phone number
	public void enterPhoneNumber() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Enter Phone Number Test");

		try {

			// wait for the phone number field to be visible, clickable and then click it
			wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
			wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
			phoneNumberField.click();

			// extract the data from exceo
			String data = Excel.getDataFromExcel();

			// fill the phone number field with excel data
			phoneNumberField.sendKeys(data);

			// logger logs the status as pass if phone number is entered successfully, also
			// log in the console
			logger1.log(Status.PASS, "Successfully entered phone number: " + data);
			Logs.log("pass", "DONE : user entered the phone number : " + data);

		} catch (Exception e) {

			// log if there's a failure while entering the phone number
			logger1.log(Status.FAIL, "Phone number couldn't be entered due to " + e);
			Logs.log("error", "FAILED : user couldn't eneter the phone number " + e);
		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

	// clicks get otp button
	public void clickGetOTPButton() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Get OTP Test");

		try {

			// wait for the visibility of get otp button
			wait.until(ExpectedConditions.visibilityOf(getOTPButton));

			// if get otp button is enabled: wait for it to be clickable, then click it
			if (getOTPButton.isEnabled()) {
				wait.until(ExpectedConditions.elementToBeClickable(getOTPButton));
				getOTPButton.click();

			}

			// log the status as pass if get otp button is clicked successfully
			logger1.log(Status.PASS, "Get OTP button clicked sucessfully");
			Logs.log("pass", "PASS : otp button clicked successfully ");

		} catch (Exception e) {

			// log if there's a failure while clicking the get otp button
			logger1.log(Status.FAIL, "Failed to click the get otp button due to " + e);
			Logs.log("error", "FAILED : otp button couldn't be clicked due to " + e);
		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

	// enters otp
	public void enterOTP(String otp) {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Enter OTP Test");

		try {

			// enters the otp after 3 seconds
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// wait for the otp field to be visible and clickable, then click it and send
			// the otp
			wait.until(ExpectedConditions.visibilityOf(otpField));
			wait.until(ExpectedConditions.elementToBeClickable(otpField));
			otpField.click();
			otpField.sendKeys(otp);

			// log the status as pass if otp entered successfully, also log in console
			logger1.log(Status.PASS, "OTP entered successfully");
			Logs.log("pass", "DONE : OTP entered successfully");

		} catch (Exception e) {

			// log if there's a failure while otp couldn'e be entered
			logger1.log(Status.FAIL, "OTP couldn't be entered due to " + e);
			Logs.log("error", "FAILED : OTP couldn't be entered due to " + e);
		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

	// closes info pop up
	public void closeInfoPopup() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Close Info popup Test");

		try {

			// wait for the info popup to be visible and clickable, then click it
			wait.until(ExpectedConditions.visibilityOf(infoPopup));
			wait.until(ExpectedConditions.elementToBeClickable(infoPopup));
			infoPopup.click();

			// log the status as pass if info pop up closed, also log in the console
			logger1.log(Status.PASS, "Info pop up closed successfully");
			Logs.log("pass", "DONE : info popup closed successfully");
		} catch (Exception e) {

			// log if there's a failure while closing the info popup
			logger1.log(Status.SKIP, "Info popup could not be clicked because sometimes its not visible");
			Logs.log("warn", "Info popup couldn't be clicked because sometimes it is not visible , exception : " + e);

		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();
	}

}
