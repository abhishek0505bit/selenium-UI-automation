package com.happiestminds.supertailsSearch.scenarios;

//import org.apache.logging.log4j.Logger;

import com.happiestminds.supertailsSearch.pages.Page1_Search;
import com.happiestminds.supertailsSearch.pages.Page2_SearchResults;
import com.happiestminds.supertailsSearch.pages.Page3_ProductInfo;
import com.happiestminds.supertailsSearch.pages.Page4_Cart;
import com.happiestminds.supertailsSearch.setupBrowser.Browser;
import com.happiestminds.supertailsSearch.utils.Logs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scn_01_02_searchFunctionalityWithoutLogin_steps extends Browser {

	
	// declaration of page objects
	Page1_Search page1;
	Page2_SearchResults page2;
	Page3_ProductInfo page3;
	Page4_Cart page4;

	// Step : User opens the browser and enters the url
	@Given(": User opens the browser and enters the url")
	public void user_opens_the_browser_and_enters_the_url() {
		Logs.log("info", "setting up the browser");
		setup(); // chrome is passed from browserInfo.properties
		getURL(); // superTails is passed from browserInfo.properties
		page1 = new Page1_Search(driver);
		page2 = new Page2_SearchResults(driver);
		page3 = new Page3_ProductInfo(driver);
		page4 = new Page4_Cart(driver);
	}

	// Step : User closes the login popup
	@And(": User closes the Login popup")
	public void user_closes_the_login_popup() {
		Logs.log("info", "closing the login pop up button by clicking on close button");
		page1.closeLoginPopup();// closes the login pop up
	}

	// Step : User enters the search query
	@When(": User enters the search query {string}")
	public void user_enters_the_search_query(String string) {
		Logs.log("info", "user is entering the search query");
		page1.provideSearchQuery(string);// provides the search query in search box
	}

	// Step : User hits the enter key to search
	@And(": User hits the enter key to search")
	public void user_hits_the_enter_key_to_search() {
		Logs.log("info", "user is clicking on the search button ");
		page1.clickSearchButton();// clicks on search button

	}

	// Step : User should see expected results on the search results page
	@Then(": User should see expectedResults on the search Results page")
	public void user_should_see_expected_results_on_the_search_results_page() {
		Logs.log("info", "user is checking whether search results are visible or not");
		page2.verifySearchResultsfAvailability();// verifies whether search results are shown or not

	}

	// Step : User click on the desired search result
	@And(": User clicks on the desired search result {string}")
	public void user_clicks_on_the_desired_search_result(String string) throws InterruptedException {
		Logs.log("info", "user is clicking on the desired search result ");
		page2.clickOnDesiredSearchResultIfPresent(string);// clicks on the the search result if it is present

	}

	// Step : User clicks on add to cart button
	@Then(": User clicks on add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		
		Logs.log("info", "user is clicking on add to cart button ");
		page3.clickOnAddToCart();// clicks on add to cart button

	}

	// Step : User clicks on cart icon
	@And(": User clicks on cart icon")
	public void user_clicks_on_cart_icon() {
		
		Logs.log("info", "user is clicking on cart icon");
		page3.clickOnCartIcon();// clicks on cart icon

	}

	// Step : User navigates to cart page and clicks on checkout
	@Then(": User navigates to cart page and clicks on checkout")
	public void user_navigates_to_cart_page_and_clicks_on_checkout() {
		Logs.log("info", "user is clicking on checkout option");
		page4.clickOnCheckoutButton();// clicks on checout button

	}

	// Step : User closes the browser
	@And(": User closes the Browser")
	public void user_closes_the_browser() {
		
		Logs.log("info", "user is closing the browser");
		end();// tears down the process : browser close

	}

	// Scenario 2 : for invalid search query----------

	// Step : User should not see expected results on the search results page
	@Then(": User should not see expectedResults on the search Results page")
	public void user_should_not_see_expected_results_on_the_search_results_page() {
		
		Logs.log("info", "user is verfying the results for invalid search query");
		page2.verifySearchResultsForInvalidQuery();// verifies whether search results are being shown for invalid query
													// or not

	}
}
