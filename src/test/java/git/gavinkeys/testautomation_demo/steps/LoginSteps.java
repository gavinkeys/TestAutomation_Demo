package git.gavinkeys.testautomation_demo.steps;

import git.gavinkeys.testautomation_demo.cucumber.DriverManager;
import git.gavinkeys.testautomation_demo.pages.BasePage;
import git.gavinkeys.testautomation_demo.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private LoginPage loginPage;
    private BasePage basePage;

    @Before
    public void setUp() {
        // Initialize WebDriver before each scenario
        String browser = System.getProperty("browser", "chrome");

        // Initialize WebDriver using the DriverManager class
        DriverManager driverManager = new DriverManager(browser);
        basePage = new BasePage(driverManager);
        loginPage = new LoginPage(driverManager);
    }

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

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        loginPage.navigateToURL(url);
    }

    @Given("I enter the username {string}")
    public void i_enter_the_username(String username) {
        loginPage.enterUsername(username);
    }

    @Given("I enter the password {string}")
    public void i_enter_the_password(String password) {
        loginPage.enterPassword(password);
    }

    @Given("I login to saucedemo")
    public void i_login_to_saucedemo(String username, String password) {
        loginPage.fullLogin(username, password);
    }

    @Then("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }
}
