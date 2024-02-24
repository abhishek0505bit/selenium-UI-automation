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

public class Page3_ProductInfo {
	
	// driver and WebDriverWait declaration
	WebDriver driver;
	WebDriverWait wait;
	
//--------------------------------web elements----------------------------------------------------------------------------------- 
	
	// element : add to cart button
	@FindBy(xpath="//button[@id='AddToCart-template--16703736905966__main' and @class='btn btn--full pdp-atc add-to-cart ']")
	WebElement addToCartButton;
	
	// element : cart icon
	@FindBy(xpath="//a[@id='HeaderCartTrigger']")
	WebElement cartIcon;
	
//---------------------------------constructor-----------------------------------------------------------------------------------
	
	// initializes driver, wait and pageFactory elements
	public Page3_ProductInfo(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

//----------------------------------scenario 1, 4, 5 : methods------------------------------------- 
	
	// clicks on add to cart
	public void clickOnAddToCart() {
		
		// creating a test step for the extent report
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("click on add to cart Test");
		try {
			
			// wait for the add to cart button to be visible and clickable, then click on add to cart button 
			wait.until(ExpectedConditions.visibilityOf(addToCartButton));
			wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
			addToCartButton.click();
			
			// logs the sataus as pass if clicked on add to cart button, also logs in console
			logger1.log(Status.PASS,"clicked on add to cart button");
			Logs.log("pass", "DONE : clicked on add to cart button ");
		}catch(Exception e)
		{
			// logs the status as fail if couldn't click on add to cart icon
			logger1.log(Status.FAIL,"couldn't click on add to cart button due to " + e);
			Logs.log("error", "FAILED : couldn't click on add to cart button due to " + e);
			
		}
	}
	
	// click on cart icon
	public void clickOnCartIcon()
	{
		
		// creating a test step in the extent report 
		ExtentTest logger1 = ExtentReportUtil.extent.createTest("click on cart test");
		try {
			
			// wait for the cart icon to be visible, clickable, then click it 
			wait.until(ExpectedConditions.visibilityOf(cartIcon));
			wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
			cartIcon.click();
			
			// logs the status as pass if clicked on cart icon
			logger1.log(Status.PASS,"clicked on cart icon");
			Logs.log("pass", "DONE : clicked on cart icon ");
		}catch(Exception e)
		{
			// log if there's a failure while clicking on add to cart icon
			logger1.log(Status.FAIL,"couldn't click on cart icon due to " + e);
			Logs.log("error", "FAILED : couldn't click on cart icon due to " + e);
			
		}
		
	}


}
