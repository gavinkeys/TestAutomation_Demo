package git.gavinkeys.testautomation_demo.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;

    public DriverManager(String browser) {
        initializeDriver(browser);
    }

    private void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/gavinkeys/Documents/MoJ/TestAutomation_Demo/src/test/java/driver/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/gavinkeys/Documents/MoJ/TestAutomation_Demo/src/test/java/driver/geckodriver");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser specified");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
