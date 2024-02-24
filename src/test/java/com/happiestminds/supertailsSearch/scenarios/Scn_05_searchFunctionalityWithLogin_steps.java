package com.happiestminds.supertailsSearch.scenarios;

import java.util.Scanner;

import com.happiestminds.supertailsSearch.pages.Page1_Search;
import com.happiestminds.supertailsSearch.setupBrowser.Browser;
import com.happiestminds.supertailsSearch.utils.Logs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Scn_05_searchFunctionalityWithLogin_steps extends Browser {

	// declaration of page objects
	Page1_Search page1 = new Page1_Search(driver);

	// Step : User enters the phone number from excel
	@And(": User enters the phone number from excel")
	public void user_enters_the_phone_number_from_excel() {
		// logs the message with green color in console
		Logs.log("info", "user is entering the phone number " );
		page1.enterPhoneNumber();// enters the phone number in input field
	}

	// Step : User clicks on get otp button
	@Then(": User clicks on get otp button")
	public void user_clicks_on_get_otp_button() {

		Logs.log("info", "user is clicking on the get otp button " );
		page1.clickGetOTPButton();// clicks on get otp button to get otp

	}

	// Step : User enter the otp
	@And(":User enters the otp")
	public void user_enters_the_otp() {
		Logs.log("info", " user is entering the otp " );
		System.out.println("Enter OTP here[FAST] : ");// asking the user to input the otp

		// Taking input from the console
		Scanner input = new Scanner(System.in);
		String otp = input.next();

		page1.enterOTP(otp);// enters the otp in the input field

		input.close();// closing the Scanner object
	}

	// Step : User closes info pop up button
	@Then(": User closes info pop up button")
	public void user_closes_info_pop_up_button() {
		page1.closeInfoPopup();// closes the info pop up
	}

}
