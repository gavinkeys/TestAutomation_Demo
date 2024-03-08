package git.gavinkeys.testautomation_demo.steps;

import git.gavinkeys.testautomation_demo.cucumber.TestHooks;
import git.gavinkeys.testautomation_demo.pages.BasePage;
import git.gavinkeys.testautomation_demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

public class LoginSteps {

    private LoginPage loginPage;
    private final TestHooks testHooks;
    private final BasePage basePage;

    // Constructor to initialize TestHooks and BasePage
    public LoginSteps(TestHooks testHooks) {
        this.testHooks = testHooks;
        this.basePage = testHooks.getBasePage();
        this.loginPage = testHooks.getLoginPage();
    }

    // Step Definitions

    /**
     * Given step: Navigates to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        basePage.navigateToURL(url);
    }

    /**
     * Given step: Enters the provided username into the username input field.
     *
     * @param username The username to enter.
     */
    @Given("I enter the username {string}")
    public void i_enter_the_username(String username) {
        loginPage.enterUsername(username);
    }

    /**
     * Given step: Enters the provided password into the password input field.
     *
     * @param password The password to enter.
     */
    @Given("I enter the password {string}")
    public void i_enter_the_password(String password) {
        loginPage.enterPassword(password);
    }

    /**
     * Given step: Performs a full login by entering the username, password, and clicking the login button.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    @Given("I login to saucedemo")
    public void i_login_to_saucedemo(String username, String password) {
        loginPage.fullLogin(username, password);
    }

    /**
     * Verifies that the user is on the login page by checking the visibility of the login page elements.
     */
    @And("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.isLoginPageVisible();
    }

    /**
     * Then step: Clicks the login button.
     */
    @Then("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    /**
     * Then step: Verifies if the specified error message is displayed.
     *
     * @param errorMessage The expected error message.
     */
    @Then("I see the {string} error message")
    public void i_see_the_error_message(String errorMessage) {
        WebElement errorMessageElement = loginPage.getErrorMessageElement();
        
        loginPage.errorMessageDisplayed(errorMessageElement);
    }
}
