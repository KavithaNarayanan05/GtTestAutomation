@apitest
Feature: API test to a search route

  Scenario Outline: (Happy Path) To validate response type, code, headers and data of a search route
    Given full response is retrieved for "<URL>"
    Then verify if status code of "<URL>" is 200
    Then validate the response type for "<URL>"
    And validate the response time for "<URL>"
    And validate the response headers for "<URL>"
  Examples:
   |URL|
   |https://ecg-api.gumtree.com.au/api/papi/ads/search?categoryId=0&categoryRedirected=1&includeTopAds=1&keyword=Table&locationId=3003435&page=1&size=20&sortType=DATE_DESCENDING|

  Scenario Outline: (Negative path) To fetch all the product IDs in the array and verify if the total ads size is 20
    Given verify if status code of "<URL>" is 200
    When the list of all ids in the response is fetched for "<URL>"
    Then Verify if the size of the list equals "<pagesize>" as in "<URL>"
  Examples:
  |pagesize|URL|
  |20 |https://ecg-api.gumtree.com.au/api/papi/ads/search?categoryId=0&categoryRedirected=1&includeTopAds=1&keyword=Table&locationId=3003435&page=1&size=20&sortType=DATE_DESCENDING|

