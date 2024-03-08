# Test Automation Demo

This project is a test automation framework for web applications using Java, Selenium, and Cucumber. It follows the Page Object Model (POM) design pattern and utilizes Cucumber for behavior-driven development (BDD).

## Features

- **Modular Structure:** Organized into distinct components for pages, steps, and hooks.
- **Page Object Model (POM):** Follows POM for better code organization and maintenance.
- **WebDriver Management:** Utilizes a `DriverManager` for setting up and tearing down the WebDriver.
- **Browser Support:** Supports Chrome and Firefox browsers.
- **Cucumber Integration:** Leverages Cucumber for BDD, defining scenarios with Gherkin syntax.
- **BasePage:** Base class for Page Objects, providing common methods for interacting with the WebDriver.
- **Page Objects (Login, Home):** Represent specific web pages and encapsulate interactions.
- **TestHooks:** Manages setup and teardown tasks using Cucumber's `@Before` and `@After` annotations.
- **Logging:** Implements Java's logging (`java.util.logging`) for error messages.
- **Dependency Injection:** Utilizes PicoContainer for dependency injection.
- **Error Handling:** Includes error handling in certain methods for robustness.

# Running Tests
## Prerequisites

- Java 21 or later
- Maven
- ChromeDriver (for Chrome) and GeckoDriver (for Firefox) executable in the project directory.

### Command Line Execution

To run all tests using Maven, execute the following command in the project root directory:

```bash
mvn clean test -Dbrowser=chrome
```

To run specific scenarios execute the following command in the project root directory (replace tags as required from login.feature file):
```bash
mvn clean test -Dbrowser=chrome -Dcucumber.filter.tags="@HappyPath or @EmptyCredentials" 
```

Replace chrome with firefox to determine which browser will be used.

## Getting Started

1. Clone the repository.
2. Ensure the required dependencies are installed.
3. Customize browser configurations in the `TestHooks` class.
4. Run tests using Maven.

## Usage

- Define scenarios in feature files.
- Implement step definitions in the `steps` package.
- Create additional Page Objects for new web pages.

## Folder Structure

- **src/test/java:** Contains test-related Java source files.
  - **driver:** Chrome and Firefox drivers
  - **git/gavinkeys/testautomation_demo:**
    - **cucumber:** Test hooks and PicoContainer configuration.
    - **pages:** BasePage, HomePage, LoginPage classes.
    - **steps:** Step classes detailing test steps.
    - **utils:** Contains the LoggerUtil
  - **TestRunner.java:** Test runner class
- **src/test/resources:** Contains feature folder and files
  - **features:** Contains login.feature file
