Feature: Feature to test advanced search functionality after applying filters

@fourthScenario
Scenario Outline: Search with valid query: <searchQuery> without logging in and applying filters
Given : User opens the browser and enters the url
And : User closes the Login popup
When : User enters the search query "<searchQuery>"
And : User hits the enter key to search
Then : User should see expectedResults on the search Results page
And : User clicks on brand "<brand>" and lifestage "<lifeStage>" filter option
Then : User selects the brand "<brand_checkbox>" and lifestage "<lifeStage_checkbox>" from filter
And : User clicks on the desired filtered search result
Then : User clicks on add to cart button
And : User clicks on cart icon
Then : User navigates to cart page and clicks on checkout
And : User closes the Browser

Examples:
|searchQuery	|brand	|lifeStage	|brand_checkbox	|lifeStage_checkbox|
|litter				|Brand	|Life Stage	|M-Pets					|Kitten				 		 |
|henlo				|Brand	|Life Stage	|Pedigree				|Adult						 |	