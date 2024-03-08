package git.gavinkeys.testautomation_demo.pages;

import git.gavinkeys.testautomation_demo.cucumber.DriverManager;
import git.gavinkeys.testautomation_demo.utils.LoggerUtil;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPage extends BasePage {

    private static final Logger LOGGER = LoggerUtil.getLogger(HomePage.class);

    // Constructors
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
    @FindBy(how = How.CSS, using = ".error-message-container > h3:nth-child(1)")
    private WebElement loginErrorMessage;

    // Page Actions

    /**
     * Checks if the login page is visible.
     *
     * @return true if the login page logo is displayed, false otherwise.
     */
    public boolean isLoginPageVisible() {
        try {
            boolean isDisplayed = homePageLogo.isDisplayed();
            if (isDisplayed) {
                LOGGER.log(Level.INFO, "Login page logo is displayed.");
            } else {
                LOGGER.log(Level.INFO, "Login page logo is not displayed.");
            }
            return isDisplayed;
        } catch (NoSuchElementException e) {
            // Log the error
            LOGGER.log(Level.SEVERE, "Error checking login page visibility: " + e.getMessage(), e);
            return false;
        }
    }

    /**
     * Enters the provided username into the username input field.
     *
     * @param username The username to enter.
     */
    public void enterUsername(String username) {
        try {
            waitForVisibility(usernameInput);
            usernameInput.sendKeys(username);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error entering username: " + e.getMessage(), e);
        }
    }

    /**
     * Enters the provided password into the password input field.
     *
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        try {
            waitForVisibility(passwordInput);
            passwordInput.sendKeys(password);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error entering password: " + e.getMessage(), e);
        }
    }

    /**
     * Clicks the login button.
     */
    public void clickLogin() {
        try {
            waitForClickable(loginButton);
            loginButton.click();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error clicking login button: " + e.getMessage(), e);
        }
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

    /**
     * Gets the WebElement representing the login error message.
     *
     * @return The WebElement representing the login error message.
     */
    public WebElement getErrorMessageElement() {
        return loginErrorMessage;
    }
}
