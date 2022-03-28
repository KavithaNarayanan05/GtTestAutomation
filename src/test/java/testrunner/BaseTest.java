package testrunner;

import io.cucumber.java.AfterAll;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static WebDriver driver;

    @Before
    public static WebDriver useInitializedDriver() throws Exception{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        return driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


}