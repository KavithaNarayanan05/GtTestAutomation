


## Gumtree Test automation challenge
This coding challenge comprises of two tasks - UI Test automation and API Test automation

##Github Project link
[![js-standard-style](https://img.shields.io/badge/GitHub-JavaProject-brightgreen.svg?style=flat)](https://github.com/KavithaNarayanan05/GtTestAutomation)

## Setup required
* Install IDE like Eclipse or Intellij
* Install Cucumber/Gherkin plugins on IDE for viewing feature files
* Install Apache Maven
* Install Java Runtime v1.8

## Getting GtTestAutomation project on your machine
* Use Terminal or cmd line tool to clone onto desired directory with following command -> git clone **https://github.com/KavithaNarayanan05/GtTestAutomation.git**
* Alternately, use Github desktop to clone using the above URL
* Can also be downloaded as a zip file -> https://github.com/KavithaNarayanan05/GtTestAutomation/archive/refs/heads/testk.zip


## How to install and run the project ?
1. **Clone**/Download the remote repository(as mentioned above) onto your local machine
2. Open your IDE and **launch** the project using File -> Open
3. Open the Terminal window using View -> Tool Windows -> **Terminal**
4. Type in **mvn clean install** _(this will install all the maven dependencies like the libraries and frameworks required to run the project and trigger the test as well)_
5. **mvn test** can also be used to run the tests _(this will run the features files for both API test and UI test consecutively)_
6. Use **mvn test -Dcucumber.filter.tags="@uitest"** to run Uitest alone
7. Use **mvn test -Dcucumber.filter.tags="@apitest"** to run Apitest alone
8. Once both tests have run, you see the **result on the console** of your IDE
9. To view Cucumber test report, open the directory where you've cloned/downloaded the project
10. Navigate to the following path -> target/cucumber-reports/**raw-cucumber-html-report.html**
11. Right click on the .html report file and open with any desired browser -> _(this will show you the **Cucumber test report** of the executed scenarios)_


## Tools and Techniques used

### 1. UI Test Automation
Using below set of frameworks and libraries, happy-path use-case of Gumtree search functionality has been automated
* Selenium
* Cucumber JVM
* Junit
* Java
* Github

The _UiTest.feature_ consists of BDD scenario with parameterization capability to run for different set of values. 


### 2.API Test Automation
Using following frameworks and libraries, API endpoint testing has been validated for happy-path and negative use-cases
* Selenium REST-assured
* Cucumber JVM
* Java
* Github

The ApiTest.feature contains BDD scenarios to validate the response obtained from the REST API based on search query. 

## Folder Structure
The test folder structure _src/test/java/_ is made up of
 * **features** - contains all the cucumber feature files which can be run individually as well
 * **stepdefinitions** - contains steps implementing the business use case
 * **pageobjects** - contains reusable piece of code for the UI page that can be used for identifying elements and performing actions on them
 * **utility** - contains Util package that has generic methods that can be reused at component level
 * **testrunner** - contains the RunnerTest java class file that invokes the test

### Other important files and folders
* **pom.xml** - conatins the maven dependencies and plugins required to run this test using selenium, junit and cucumber frameworks
* **drivers** - folder contains chrome driver executable file required to run the UI test
* **target** - folder contains compiled files and cucumber test reports

## URLs

https://www.gumtree.com.au/

https://ecg-api.gumtree.com.au/api/papi/ads/search?categoryId=0&categoryRedirected=1&includeTopAds=1&keyword=Table&locationId=3003435&page=1&size=20&sortType=DATE_D
