package com.happiestminds.supertailsSearch.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.happiestminds.supertailsSearch.utils.ExtentReportUtil;
import com.happiestminds.supertailsSearch.utils.Logs;

public class Page4_Cart {

	// driver and WebDriverWait declaration
	WebDriver driver;
	WebDriverWait wait;

//-----------------------------scenario 1, 4, 5 : web elements----------------------------- 

	// element : checkout button
	@FindBy(xpath = "//button[@type='submit'  and @name='checkout' ]")
	WebElement checkoutButton;

	// element : continue shopping button
	@FindBy(xpath = "//a[text()='Continue shopping']")
	WebElement continueShoppingButton;

//--------------------------------------constructor----------------------------------------

	// intializes the driver, wait and pagefactory elements
	public Page4_Cart(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

//-------------------------------scenario 1, 4, 5 : methods--------------------------------	

	// clicks on checkout button
	public void clickOnCheckoutButton() {
		// creating a test step in the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("click on checkout Button Test");
		try {
			try {
				// wait for the checkout button to be visible and clickable, then click it
				wait.until(ExpectedConditions.visibilityOf(checkoutButton));
				wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
				checkoutButton.click();

				// logs the status as pass if clicked on checkout button successfully
				logger1.log(Status.PASS, "clicked on checkout button successfully");
				Logs.log("pass", "DONE : clicked on checkout button");

			} catch (Exception e) {
				// if checkout button is not visible, then wait for continue shopping button to
				// be visible
				// and then click it
				wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
				wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
				continueShoppingButton.click();

				// sometimes it asks to shop more to increase the weight of the bag
				System.out.println("Sometimes checkout button is not visible...");

				// logs in the console about the info : checkout button is not visible due less
				// items in cart
				Logs.log("info",
						"Sometimes checkout button is not visible due to less items in cart so clicking on CONTINUE SHOPPING");

			}

		} catch (Exception e) {
			// if both the elements not found, log the status as fail, also log in the
			// console
			logger1.log(Status.FAIL, "couldn't click on checkout button due to " + e);
			Logs.log("error", "FAILED : couldn't click on checkout button due to " + e);

		}

	}

}
