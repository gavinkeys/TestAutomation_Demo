package git.gavinkeys.testautomation_demo.pages;

import git.gavinkeys.testautomation_demo.cucumber.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage(DriverManager driverManager) {
        super(driverManager);
    }

    // Locators
    @FindBy(how = How.ID, using = "user-name")
    private WebElement usernameInput;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInput;
    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;
    @FindBy(how = How.CLASS_NAME, using = "login_logo")
    private WebElement homePageLogo;

    // Page Actions

    /**
     * Checks if the login page is visible.
     *
     * @return true if the login page logo is displayed, false otherwise.
     */
    public boolean isLoginPageVisible() {
        return homePageLogo.isDisplayed();
    }

    /**
     * Enters the provided username into the username input field.
     *
     * @param username The username to enter.
     */
    public void enterUsername(String username) {
        waitForVisibility(usernameInput);
        usernameInput.sendKeys(username);
    }

    /**
     * Enters the provided password into the password input field.
     *
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        waitForVisibility(passwordInput);
        passwordInput.sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLogin() {
        waitForClickable(loginButton);
        loginButton.click();
    }

    /**
     * Performs a full login by entering the username, password, and clicking the login button.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    public void fullLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
