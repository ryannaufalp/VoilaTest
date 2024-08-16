package VoilaTest.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class WebDriverProvider {

    private WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            System.out.println("Initializing WebDriver...");
            System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

