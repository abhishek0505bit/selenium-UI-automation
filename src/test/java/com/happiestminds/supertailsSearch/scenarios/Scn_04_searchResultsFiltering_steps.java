package com.happiestminds.supertailsSearch.scenarios;

import com.happiestminds.supertailsSearch.pages.Page1_Search;
import com.happiestminds.supertailsSearch.pages.Page2_SearchResults;
import com.happiestminds.supertailsSearch.pages.Page3_ProductInfo;
import com.happiestminds.supertailsSearch.pages.Page4_Cart;
import com.happiestminds.supertailsSearch.setupBrowser.Browser;
import com.happiestminds.supertailsSearch.utils.Logs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Scn_04_searchResultsFiltering_steps extends Browser {

	// declaration of page objects
	Page1_Search page1;
	Page2_SearchResults page2;
	Page3_ProductInfo page3;
	Page4_Cart page4;

	// Step : User clicks on brand and lifestage filter option
	@And(": User clicks on brand {string} and lifestage {string} filter option")
	public void user_clicks_on_brand_and_lifestage_filter_option(String string, String string2) {
		Logs.log("info", "user is clicking on brand and lifestage filters");
		page2 = new Page2_SearchResults(driver);
		page2.filterSearchResults(string, string2);// clicks on brand and lifeStage filter
	}

	// Step : User selects the brand and lifestage from filter
	@Then(": User selects the brand {string} and lifestage {string} from filter")
	public void user_selects_the_brand_and_lifestage_from_filter(String string, String string2) {
		// logs the message with green color in console
		Logs.log("info", "user is filtering the results based on the filter ");
		page2.selectBrandNLifestage(string, string2);// selects the option from brand and lifestage filters

	}

	// Step : User clicks on the desired filtered search result
	@And(": User clicks on the desired filtered search result")
	public void user_clicks_on_the_desired_filtered_search_result() {
		Logs.log("info", "user is clicking on the desired filtered result");
		page2.clickOnFirstResultIfPresent();// clicks on first search result after applying filter if present

	}

}
