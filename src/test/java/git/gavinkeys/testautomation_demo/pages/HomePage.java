package git.gavinkeys.testautomation_demo.pages;

import git.gavinkeys.testautomation_demo.cucumber.DriverManager;
import git.gavinkeys.testautomation_demo.utils.LoggerUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage extends BasePage {

    // Logger for error handling
    private static final Logger LOGGER = LoggerUtil.getLogger(HomePage.class);

    // Constructors
    public HomePage(DriverManager driverManager) {
        super(driverManager);
    }

    // Locators
    @FindBy(how = How.CSS, using = ".title")
    private WebElement productsTitle;
    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    private WebElement cartLinkButton;
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    private WebElement menuButton;
    @FindBy(how = How.CLASS_NAME, using = "product_sort_container")
    private WebElement productSortDropdown;
    @FindBy(how = How.ID, using = "logout_sidebar_link")
    private WebElement logoutButton;

    private static final String securePageURL = "https://www.saucedemo.com/inventory-item.html?id=4";

    // Page Actions

    /**
     * Checks if the home page is visible by verifying the presence of the products title.
     *
     * @return true if the products title is displayed, false otherwise.
     */
    public boolean isHomePageVisible() {
        try {
            waitForVisibility(productsTitle);
            return productsTitle.isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error checking home page visibility: " + e.getMessage(), e);
            return false;
        }
    }

    /**
     * Logs out of the Sauce Demo by clicking on the menu button and then the logout button.
     */
    public void logoutOfSauceDemo() {
        try {
            waitForClickable(menuButton);
            menuButton.click();
            waitForClickable(logoutButton);
            logoutButton.click();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during logout: " + e.getMessage(), e);
        }
    }

    /**
     * Navigates to the secure page using the securePageURL string.
     * Assumes that the securePageURL variable is set with the appropriate URL.
     */
    public void navigateToSecurePage() {
        try {
            navigateToURL(securePageURL);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error navigating to secure page: " + e.getMessage(), e);
        }
    }
}
