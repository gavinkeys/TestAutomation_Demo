package git.gavinkeys.testautomation_demo.cucumber;

import git.gavinkeys.testautomation_demo.pages.BasePage;
import git.gavinkeys.testautomation_demo.pages.HomePage;
import git.gavinkeys.testautomation_demo.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TestHooks {

    // Instances of PageObjects (BasePage, LoginPage, and HomePage) for interactions with web pages
    private BasePage basePage;
    private LoginPage loginPage;
    private HomePage homePage;

    // Private constructor to prevent external instantiation
    public TestHooks() {
    }

    /**
     * Setup method executed before each scenario.
     * Initializes WebDriver and creates instances of PageObjects.
     */
    @Before
    public void setUp() {
        // Retrieve the browser type from the system property, defaulting to 'chrome'
        String browser = System.getProperty("browser", "chrome");

        // Initialize a new instance of DriverManager with the specified browser
        DriverManager driverManager = new DriverManager(browser);

        // Create instances of the PageObjects (BasePage, LoginPage, and HomePage) using the DriverManager
        // These PageObjects will encapsulate the interactions with their respective web pages
        basePage = new BasePage(driverManager);
        loginPage = new LoginPage(driverManager);
        homePage = new HomePage(driverManager);
    }

    /**
     * Teardown method executed after each scenario.
     * Closes the WebDriver.
     */
    @After
    public void tearDown() {
        // Close WebDriver after each scenario
        if (basePage != null) {
            WebDriver driver = basePage.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }

    /**
     * Gets the instance of BasePage.
     *
     * @return The BasePage instance.
     */
    public BasePage getBasePage() {
        return basePage;
    }

    /**
     * Gets the instance of LoginPage.
     *
     * @return The LoginPage instance.
     */
    public LoginPage getLoginPage() {
        return loginPage;
    }

    /**
     * Gets the instance of HomePage.
     *
     * @return The HomePage instance.
     */
    public HomePage getHomePage() {
        return homePage;
    }
}
