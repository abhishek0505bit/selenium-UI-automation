Feature: Feature to test basic search functionality

@firstScenario
Scenario Outline: Search with valid query: <searchQuery> without logging in
Given : User opens the browser and enters the url
And : User closes the Login popup
When : User enters the search query "<searchQuery>"
And : User hits the enter key to search
Then : User should see expectedResults on the search Results page
And : User clicks on the desired search result "<desiredSearchResult>"
Then : User clicks on add to cart button
And : User clicks on cart icon
Then : User navigates to cart page and clicks on checkout
And : User closes the Browser

Examples:
|searchQuery |desiredSearchResult|
|pedigree    |Pedigree Chicken and Vegetables Adult Dry Dog Food|

#----------------------------------------------------------------------------------------------------------------

@secondScenario
Scenario Outline: Search with invalid query: <searchQuery> without logging in
Given : User opens the browser and enters the url
And : User closes the Login popup
When : User enters the search query "<searchQuery>"
And : User hits the enter key to search
Then : User should not see expectedResults on the search Results page
And : User closes the Browser

Examples:
|searchQuery |
|afn;gaigeg	 |
|.&^%$$%^&() |