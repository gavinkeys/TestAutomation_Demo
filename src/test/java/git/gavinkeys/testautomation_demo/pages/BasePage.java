package git.gavinkeys.testautomation_demo.pages;

import git.gavinkeys.testautomation_demo.cucumber.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;

    /**
     * Constructor for BasePage that initializes the WebDriver and WebDriverWait.
     *
     * @param driverManager The DriverManager to retrieve the WebDriver.
     */
    public BasePage(DriverManager driverManager) {
        try {
            this.driver = driverManager.getDriver();
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Initialize elements using PageFactory
            PageFactory.initElements(driver, this);
        } catch (Exception e) {
            // Handle the exception (e.g., log it, throw a custom exception, etc.)
            e.printStackTrace();
            // Rethrow the exception
            throw e;
        }
    }

    /**
     * Gets the WebDriver instance.
     *
     * @return The WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Navigates to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    public void navigateToURL(String url) {
        driver.get(url);
    }

    /**
     * Waits for the visibility of a WebElement.
     *
     * @param element The WebElement to wait for visibility.
     */
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for a WebElement to be clickable.
     *
     * @param element The WebElement to wait for click-ability.
     */
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Checks if a WebElement is displayed.
     *
     * @param element The WebElement to check for visibility.
     * @return true if the element is displayed, false otherwise.
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            e.printStackTrace();
            return false; // Element not displayed
        }
    }

    /**
     * Checks if an error message is displayed and prints it to the console.
     *
     * @param errorMessageElement The WebElement representing the error message.
     */
    public void errorMessageDisplayed(WebElement errorMessageElement) {
        if (isElementDisplayed(errorMessageElement)) {
            System.out.println("Error message is displayed: " + errorMessageElement.getText());
        } else {
            System.out.println("Error message is not displayed.");
        }
    }
}
