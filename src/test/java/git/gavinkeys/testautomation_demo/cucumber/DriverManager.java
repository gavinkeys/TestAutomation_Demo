package git.gavinkeys.testautomation_demo.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;

    /**
     * Initializes the WebDriver based on the specified browser.
     * @param browser The browser to use ("chrome" or "firefox").
     * @throws IllegalArgumentException if an invalid browser is specified.
     */
    private void initializeDriver(String browser) {
        String driversPath = System.getProperty("user.dir") + "/src/test/java/driver/";

        if (browser.equalsIgnoreCase("chrome")) {
            // Set the system property for ChromeDriver
            System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver");
            // Initialize ChromeDriver
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Set the system property for GeckoDriver
            System.setProperty("webdriver.gecko.driver", driversPath + "geckodriver");
            // Initialize FirefoxDriver
            driver = new FirefoxDriver();
        } else {
            // Throw an exception for an invalid browser
            throw new IllegalArgumentException("Invalid browser specified");
        }
    }

    /**
     * Constructor that initializes the WebDriver with the specified browser.
     * @param browser The browser to use (e.g., "chrome" or "firefox").
     */
    public DriverManager(String browser) {
        initializeDriver(browser);
    }

    /**
     * Retrieves the initialized WebDriver instance.
     * @return The WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }
}
