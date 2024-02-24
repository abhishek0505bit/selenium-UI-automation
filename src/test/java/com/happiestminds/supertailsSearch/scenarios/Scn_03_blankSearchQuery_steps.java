package com.happiestminds.supertailsSearch.scenarios;

import com.happiestminds.supertailsSearch.pages.Page1_Search;
import com.happiestminds.supertailsSearch.setupBrowser.Browser;
import com.happiestminds.supertailsSearch.utils.Logs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scn_03_blankSearchQuery_steps extends Browser {

	// declaration of page objects
	Page1_Search page1 = new Page1_Search(driver);

	// Step : User doesn't enter the search query
	@When(": User does not enter the search query")
	public void user_does_not_enter_the_search_query() {
		// logs the message with green color in console
		Logs.log("info", "user doesn't enter any search query");
		// leaving this space empty as user is not performing any action
	}

	// Step : User should remain on the same page
	@Then(": User should remain on the same page")
	public void user_should_remain_on_the_same_page() {
		Logs.log("info", "verifying whether user is on the same page or not");
		page1.verifyPageTitle();// verifies that user should remain on the same page when searching for blank
								// query
	}

}
