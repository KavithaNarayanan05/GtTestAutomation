package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import support.util;
import java.time.Duration;
import java.util.List;


public class uiTestPage {

    WebDriver driver;

    public uiTestPage(WebDriver driver) throws Exception {
            this.driver = driver;
    }

    public void dismissModalDialog() throws Exception{
            if (driver.findElement(By.id("gumtree-modal-0")).isDisplayed()) {
                driver.findElement(By.cssSelector("a.button.button--primary.warning__button-hide")).click();}
    }

    public void typeSearchQuery(String searchquery)throws Exception{
        driver.findElement(By.id("search-query")).sendKeys(searchquery);
    }

    public void selectCategory(String category) throws Throwable {
        driver.findElement(By.id("categoryId-wrp")).click();
        List<WebElement> categoryDropdown = driver.findElements(By.xpath("//div[@id='categoryId-wrpwrapper']/ul/li"));
        util.clickDropdownElementByValue(categoryDropdown, "Electronics & Computer");
    }

    public void confirmSearchquery()throws Exception{
        driver.findElement(By.id("search-query")).click();
    }

    public void typeRegion(String region) throws Exception{
        driver.findElement(By.id("search-area")).sendKeys(region);
    }

    public void selectRadius(String radius) throws Throwable {
        driver.findElement(By.id("srch-radius-wrp")).click();
        new FluentWait(driver).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='srch-radius-wrpwrapper']/ul/li"))));
        List<WebElement> radiusDropdown = driver.findElements(By.xpath("//div[@id='srch-radius-wrpwrapper']/ul/li"));
        util.clickDropdownElementByValue(radiusDropdown, radius);
    }

    public void submitSearchquery()throws Throwable{
        driver.findElement(By.cssSelector("button.header__search-button")).click();
    }

    public void implicitWaitForPageToLoad()throws Throwable{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    public void verifyIfResultSectionIsDisplayed()throws Throwable{
        WebElement adsSection = driver.findElement(By.xpath("//div[@class='user-ad-collection-new-design__wrapper--row']"));
        adsSection.isDisplayed();
        adsSection.findElement(By.xpath("//a[contains(@id, 'user-ad-')]"));
    }

    public void selectRandomAdFromResults() throws Throwable{
        List<WebElement> adsList = driver.findElements(By.xpath("//a[contains(@id, 'user-ad-')]"));
        util.clickRandomAdFromList(adsList);
    }

    public String getAdPageTitle() throws Throwable{
        return driver.getTitle();
    }

    public void verifyIfAdPageHasNumericAdId()throws Throwable{
        String numericAdID = driver.findElement(By.cssSelector("span.breadcrumbs__summary")).getText();
        if(numericAdID.contains("[0-9]+"));
    }

    public boolean verifyIfSimilarAdsPresent() throws Throwable{
        List<WebElement> similarAdsList = driver.findElements(By.xpath("//a[contains(@id, 'user-ad-')]"));
        return util.verifyIfItemsPresent(similarAdsList);
    }
}
