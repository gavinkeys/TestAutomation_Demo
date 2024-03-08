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

## Running the Tests

### Prerequisites

Make sure you have the following installed on your machine:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 21 or later)
- [Maven](https://maven.apache.org/download.cgi)
- IDE [Built using Intellij community edition](https://www.jetbrains.com/idea/download/?fromIDE=&section=mac)

## Installation
### Windows

#### JDK:
   1. Download the JDK from the Oracle website.
   2. Run the installer and follow the instructions to install Java.
   3. Set the JAVA_HOME environment variable to the path where the JDK is installed.

#### Maven:
   1. Download the binary zip archive from the Maven download page.
   2. Extract the archive to your desired location.
   3. Add the bin directory of the created directory to the PATH environment variable.

### macOS

#### JDK:
   1. Download the JDK from the Oracle website.
   2. Open the downloaded dmg file and follow the instructions to install Java.

#### Maven:
   1. Maven can be installed using Homebrew. If you don’t have Homebrew installed, you can install it from the Homebrew website.
   2. Once Homebrew is installed, you can install Maven by running brew install maven in the terminal.

### Linux

#### JDK:
   1. Download the JDK from the Oracle website.
   2. Extract the tar.gz file to your desired location.
   3. Set the JAVA_HOME environment variable to the path where the JDK is installed.

#### Maven:
   1. Maven can be installed using the package manager for your specific Linux distribution. For example, on Ubuntu, you can install Maven by running sudo apt install maven in the terminal.


# Setup Steps

## 1. Clone the Repository:
git clone https://github.com/gavinkeys/TestAutomation_Demo.git

## 2. Run Tests:
### For Chrome:
```bash
mvn clean test -Dbrowser=chrome
```

### For Firefox:
```bash
mvn clean test -Dbrowser=firefox
```

# 3. Optional: Run Specific Tags:
 To run specific tags, use the `-Dcucumber.filter.tags` option:

 For example, to run tests with tags "@HappyPath or @EmptyCredentials":
```bash
mvn clean test -Dbrowser=chrome -Dcucumber.filter.tags="@HappyPath or @EmptyCredentials"
```

# 4. Generate Cucumber Reports
 HTML test reports are generated and stored in the root/reports folder

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
