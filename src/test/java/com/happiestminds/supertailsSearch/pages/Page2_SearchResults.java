package com.happiestminds.supertailsSearch.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.happiestminds.supertailsSearch.screenshots.Screenshot;
import com.happiestminds.supertailsSearch.utils.ExtentReportUtil;
import com.happiestminds.supertailsSearch.utils.Logs;

public class Page2_SearchResults {

	// driver and WebDriverWait declaration
	WebDriver driver;
	WebDriverWait wait;

//--------------------------------scenario 1 : web elements-------------------------------------------------------	

	// element : search results found
	@FindBy(xpath = "//span[@class='findify-components--text findify-components-search--query']")
	WebElement searchResultsFound;

	// List of web elements : search Results
	@FindAll(@FindBy(xpath = "//h2[@class='findify-components--text findify-components--cards--product__title']"))
	List<WebElement> searchResults;

//--------------------------------scenario 2 : web eLements------------------------------------------------------

	// element : results not found
	@FindBy(xpath = "//span[@class='findify-components--text']")
	WebElement searchResultsNotFound;

//--------------------------------scenario 4 : web elements------------------------------------------------------ 

	// List of web elements : search Filters
	@FindAll(@FindBy(xpath = "//button[@class='findify-components--button findify-components--facet__title']/span"))
	List<WebElement> searchFilters;

	// List of web elements : brand filters
	@FindAll(@FindBy(xpath = "//*[@id='facet-custom_fields.custom_brand']/section/button/span[1]"))
	List<WebElement> brandFilters;

	// List of web elements : life stage filters
	@FindAll(@FindBy(xpath = "//*[@id='facet-custom_fields.custom_life_stage']/section/button/span[1]"))
	List<WebElement> lifestageFilters;

	// element : search result after filter
	@FindBy(xpath = "//ul[@class='findify-components-common--grid']/li")
	WebElement searchResultAfterFilter;

//---------------------------------------constructor--------------------------------------------------------------------------------------------

	// initializes driver, wait and pageFactory elements
	public Page2_SearchResults(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

//--------------------------------scenario 1 : valid search query methods--------------------------------------------------------------------------------------------

	// clicks on desired search result product if present
	public void clickOnDesiredSearchResultIfPresent(String query) {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Click on Desired Search Result Test");
		try {
			// wait for the search results to be visible
			wait.until(ExpectedConditions.visibilityOf(searchResultsFound));

			// iterate through each search result element
			for (WebElement result : wait.until(ExpectedConditions.visibilityOfAllElements(searchResults))) {
				try {
					// check if the text of the search result matches the desired query
					if (result.getText().equalsIgnoreCase(query)) {

						// wait for the element to be clickable, then click on it
						wait.until(ExpectedConditions.elementToBeClickable(result));
						result.click();

						// log the status as pass if clicked, also log in the console logger
						logger1.log(Status.PASS, "clicked on desired search Result");
						Logs.log("pass", "DONE : clicked on desired search result");

						break;// exit the loop after clicking on desired search result
					}
				} catch (StaleElementReferenceException e) {
					// Handle the stale element reference exception by waiting for the elements
					// again
					wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
				}
			}

		} catch (Exception e) {

			// log if there's a failure while clicking the desired search result
			logger1.log(Status.FAIL, "couldn't click on desired search result due to " + e);
			Logs.log("error", "FAILED : couldn't click on desired search result due to " + e);
		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

	// verify whether search results are visible or not
	public void verifySearchResultsfAvailability() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Search Results availability Test");
		try {
			try {

				// wait for the search results to be visible
				wait.until(ExpectedConditions.visibilityOf(searchResultsFound));

				// log the status as pass if search results found, also log in the console
				// logger
				Logs.log("pass", "Verified : Search Results Found");

				logger1.log(Status.PASS, "search results found");
			} catch (Exception e) {

				// log if there's a failure while finding search results
				wait.until(ExpectedConditions.visibilityOf(searchResultsNotFound));
				Logs.log("info", "Search Results Not Found");
			}

		} catch (Exception e) {

			// log if there's a failure while finding the search results
			logger1.log(Status.FAIL, "exception occurred at finding search results due to " + e);
			Logs.log("error", "FAILED : no element found while searching for search results " + e);
		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

//---------------------------scenario 2 : invalid query methods-------------------------------------------------------------------

	// verify search results for invalid query
	public void verifySearchResultsForInvalidQuery() {

		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("Search Results availability Test");

		try {

			// wait for the search results not found to be visible
			wait.until(ExpectedConditions.visibilityOf(searchResultsNotFound));

			// log the status as pass if 'search results not found' message is found, also
			// log in console
			logger1.log(Status.PASS, "Search Results should not be shown for invalid query");
			Logs.log("pass", "DONE : search results should not be displayed for invalid query");

		} catch (Exception e) {

			// capture the screenshot if this test fails and log the status as Fail, also
			// log in console
			// ADD THE SCREENSHOT TO THE EXTENT REPORT 
			String screenshotPath = Screenshot.captureScreenshot("scenario2");
			logger1.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			Logs.log("error", "Assertion Fail: search results being displayed even for invalid search query " + e);
			logger1.log(Status.FAIL, "FAIL : results being displayed even for invalid search query");
																												

			// throw assertion fail: if search results being displayed for invalid query
			Assert.fail("search Results being displayed for invalid query");
		}

		// Erases any previous data on a relevant report and creates a whole new report
		ExtentReportUtil.extent.flush();

	}

//-----------------------------scenario 4: search Filters methods-------------------------------------------------

	// filter search Results method
	public void filterSearchResults(String string, String string2) {

		// iterate through each search filter element
		for (WebElement searchFilter : wait.until((ExpectedConditions.visibilityOfAllElements(searchFilters)))) {

			// check if text of search filter matches with any of the arguments
			if (searchFilter.getText().equalsIgnoreCase(string) || searchFilter.getText().equalsIgnoreCase(string2)) {

				// wait for the element to be visible and clickable , then click it
				wait.until(ExpectedConditions.visibilityOf(searchFilter));
				wait.until(ExpectedConditions.elementToBeClickable(searchFilter));
				searchFilter.click();
				Logs.log("pass", "DONE : clicked on " + searchFilter.getText() + " filter");
			}
		}

	}

	// select Brand and LifeStage Filter
	public void selectBrandNLifestage(String string, String string2) {

		// based on user input brand filter is applied
		// iterate inside each brand filter element
		for (WebElement brandFilter : wait.until(ExpectedConditions.visibilityOfAllElements(brandFilters))) {

			// check if the text of brand filter element matches the passed argument
			if (brandFilter.getText().equalsIgnoreCase(string)) {

				// wait for the element to be visible and clickable, then click it
				wait.until(ExpectedConditions.visibilityOf(brandFilter));
				wait.until(ExpectedConditions.elementToBeClickable(brandFilter));
				brandFilter.click();
			}
		}

		// based on user input the lifeStage filter is applied
		// iterate inside each life stage filter element
		for (WebElement lifestageFilter : wait.until(ExpectedConditions.visibilityOfAllElements(lifestageFilters))) {

			// check if the text of life stage filter element matches the passed argument
			if (lifestageFilter.getText().equalsIgnoreCase(string2)) {

				// wait for the element to be visible and clickabe, then click it
				wait.until(ExpectedConditions.visibilityOf(lifestageFilter));
				wait.until(ExpectedConditions.elementToBeClickable(lifestageFilter));
				lifestageFilter.click();

			}
		}
	}

	// clicks on first element after filtering results
	public void clickOnFirstResultIfPresent() {

		try {

			// wait for the search result element after applying filter to be visible and
			// clickabe, then click it
			wait.until(ExpectedConditions.visibilityOf(searchResultAfterFilter));
			wait.until(ExpectedConditions.elementToBeClickable(searchResultAfterFilter));
			searchResultAfterFilter.click();
			Logs.log("pass", "DONE : clicked on the desired result");

		} catch (Exception e) {

			// log an error in the console, if not able to click
			Logs.log("error", "No product found to be clicked");
		}

	}
}
