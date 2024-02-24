Feature: Feature to test basic search functionality after logging in

@fifthScenario
Scenario Outline: Search with valid query: <searchQuery> after logging in
Given : User opens the browser and enters the url
And : User enters the phone number from excel
Then : User clicks on get otp button
And :User enters the otp
Then : User closes info pop up button
When : User enters the search query "<searchQuery>"
And : User hits the enter key to search
Then : User should see expectedResults on the search Results page
And : User clicks on the desired search result "<desiredSearchResult>"
Then : User clicks on add to cart button
And : User clicks on cart icon
Then : User navigates to cart page and clicks on checkout
And : User closes the Browser


Examples:
|searchQuery	|desiredSearchResult	|
|pedigree     |Pedigree Chicken and Vegetables Adult Dry Dog Food|