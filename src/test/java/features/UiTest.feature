@uitest
Feature: UI test on Gumtree homepage to retrieve, validate and verify results

  Scenario Outline: To validate the search functionality on Gumtree webUI
    Given user is on Gumtree "<URL>"
    When user inputs "<searchquery>"
    And selects "<category>", "<region>" and "<distance>"
    And clicks the submit button
    Then respective search results are displayed
    When a random ad page is clicked
    Then respective ad details page opens
    Then verify if numeric ad id is displayed on the breadcrumbs
    Then verify atleast one similar ad is displayed on the page
Examples:
    |URL| searchquery | category | region | distance |
    |https://www.gumtree.com.au/| Sennheiser| Electronics & Computer | Sydney Region, NSW | 20km |