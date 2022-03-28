package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import testrunner.BaseTest;
import pageobjects.uiTestPage;


public class UiTestSteps {

    WebDriver uiTestDriver;
    uiTestPage testPage;

    String actualTitle = "Gumtree: Australia's Free Marketplace. Find a car, job, furniture & more";
    String searchPageTitle = "sennheiser in Sydney Region, NSW | Electronics & Computer | Gumtree Australia Free Local Classifieds"; //Have used 'sennheiser' as 'sennheiser headphones' was fetching 0 results

    @Given("^user is on Gumtree \"([^\"]*)\"")
    public void navigatetoGumtreeHomepage(String URL) throws Throwable {

        //Initializing WebDriver and Page Objects
        uiTestDriver = BaseTest.useInitializedDriver();
        testPage = new uiTestPage(uiTestDriver);

        //Navigating to Gumtree Homepage
        uiTestDriver.get(URL);

        //Fetch and assert PageTitle
        String pageTitle = uiTestDriver.getTitle();
        Assert.assertEquals(pageTitle, actualTitle);

        //Closing the warning modal dialog
        testPage.dismissModalDialog();
    }

    @When("^user inputs \"([^\"]*)\"$")
    public void typeSearchQuery(String searchquery) throws Throwable {

        //Typing in the search query
        testPage.typeSearchQuery(searchquery);
    }

    @When("^selects \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"")
    public void selectDropDownOptions(String category, String region, String radius) throws Throwable {

        //Selecting the Category from dropdown
        testPage.selectCategory(category);

        //Confirming the Search query
        testPage.confirmSearchquery();

        //Typing in the region
        testPage.typeRegion(region);

        //Selecting the radius value from dropdown
        testPage.selectRadius(radius);
    }

    @When("^clicks the submit button$")
    public void clickSearchIcon() throws Throwable {

        //Submitting the Search
        testPage.submitSearchquery();
    }

    @Then("^respective search results are displayed$")
    public void validateSearchResults() throws Throwable {

        //Waiting for the results page to load
        testPage.implicitWaitForPageToLoad();

        //Asserting the search page title to match the expected title
        Assert.assertEquals(searchPageTitle, uiTestDriver.getTitle());

        //Verify if Results section is displayed for that particular search query
        testPage.verifyIfResultSectionIsDisplayed();
    }


    @When("^a random ad page is clicked$")
    public void clickRandomAd() throws Throwable {

        //Selecting a random ad result
        testPage.selectRandomAdFromResults();
    }

    @Then("^respective ad details page opens$")
    public void verifyAdDetails() throws Throwable {

        //Waiting for the randomly selected Ad page to load
        testPage.implicitWaitForPageToLoad();

        //Verifying if the Ad page has opened
        Assert.assertNotEquals(searchPageTitle, testPage.getAdPageTitle());
    }

    @Then("^verify if numeric ad id is displayed on the breadcrumbs$")
    public void verifyNumericAdIdInBreadcrumbs() throws Throwable {

        //Verifying if the breadcrumb contains the numeric Ad Id
        testPage.verifyIfAdPageHasNumericAdId();
    }

    @Then("^verify atleast one similar ad is displayed on the page$")
    public boolean verifySimilarAdIsDisplayed() throws Throwable {

        //Verify if similar ads are displayed
        return testPage.verifyIfSimilarAdsPresent();
    }
}


