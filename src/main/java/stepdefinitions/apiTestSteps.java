package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.apiTestObjects;;

public class apiTestSteps {

    @Given("^full response is retrieved for \"([^\"]*)\"$")
    public void hitApiURL(String URL) throws Throwable {
        apiTestObjects.getResponseBody(URL);
    }

    @Then("^verify if status code of \"([^\"]*)\" is 200$")
    public boolean getResponseStatus(String URL) throws Throwable {
        return apiTestObjects.getResponseStatus(URL);
    }

    @Then("^validate the response type for \"([^\"]*)\"$")
    public void getResponseHeaders(String URL) throws Throwable {
        apiTestObjects.getResponseHeaders(URL);
    }

    @And("^validate the response time for \"([^\"]*)\"")
    public void getResponseTime(String URL) throws Throwable {
        apiTestObjects.getResponseTime(URL);
    }

    @And("^validate the response headers for \"([^\"]*)\"$")
    public void getResponseContentType(String URL) throws Throwable {
        apiTestObjects.getResponseContentType(URL);
    }

    @When("^the list of all ids in the response is fetched for \"([^\"]*)\"$")
    public void getListOfAds(String URL) throws Throwable {
        apiTestObjects.getAdIDs(URL);
    }

    @Then("^Verify if the size of the list equals \"([^\"]*)\" as in \"([^\"]*)\"$")
    public boolean getSizeOfAdsList(int pagesize, String URL) throws Throwable {
        return apiTestObjects.getSizeOfAdsList(pagesize,URL);
    }
}