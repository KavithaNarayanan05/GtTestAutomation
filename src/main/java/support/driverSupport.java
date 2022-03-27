package support;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class driverSupport {

    private static WebDriver driver;

    @BeforeAll
    public static WebDriver useInitializedDriver() throws Exception{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        return driver = new ChromeDriver();
    }

    @AfterAll
    public static void killDriver() throws Exception{
        driver.close();
        driver.quit();
    }
}
