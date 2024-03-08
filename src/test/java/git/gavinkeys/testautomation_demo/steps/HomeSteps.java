package git.gavinkeys.testautomation_demo.steps;

import git.gavinkeys.testautomation_demo.cucumber.TestHooks;
import git.gavinkeys.testautomation_demo.pages.BasePage;
import git.gavinkeys.testautomation_demo.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    private HomePage homePage;
    private final TestHooks testHooks;
    private final BasePage basePage;

    // Constructor to initialize TestHooks and BasePage
    public HomeSteps(TestHooks testHooks) {
        this.testHooks = testHooks;
        this.basePage = testHooks.getBasePage();
        this.homePage = testHooks.getHomePage();
    }

    // Step Definitions

    /**
     * Given step: Verifies that the user has successfully logged in and the home page is visible.
     */
    @Given("I have successfully logged in")
    public void i_have_successfully_logged_in() {
        homePage.isHomePageVisible();
    }

    /**
     * Then step: Logs out from the application.
     */
    @Then("I logout")
    public void i_logout() {
        homePage.logoutOfSauceDemo();
    }

    /**
     * Navigates to a secure page without logging in.
     */
    @When("I access a secure page without logging in")
    public void i_access_a_secure_page_without_logging_in() {
        homePage.navigateToSecurePage();
    }
}
