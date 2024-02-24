Feature: Feature to test basic search functionality for blank search query


@thirdScenario
Scenario: Search with blank query without logging in
Given : User opens the browser and enters the url
And : User closes the Login popup
When : User does not enter the search query
And : User hits the enter key to search
Then : User should remain on the same page
And : User closes the Browser
