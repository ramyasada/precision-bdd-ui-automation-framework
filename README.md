# Precision UI BDD Automation Framework

A Java-based UI test automation framework for automating e-commerce user
journeys using Selenium WebDriver, Cucumber BDD, and TestNG.

**GitHub Repository:**
[precision-bdd-ui-automation-framework](https://github.com/ramyao8/precision-bdd-ui-automation-framework)\
**Primary Branch:** `main`

------------------------------------------------------------------------

## Table of Contents

1.  [Project Overview](#1-project-overview)
2.  [Tech Stack](#2-tech-stack)
3.  [Prerequisites](#3-prerequisites)
4.  [Project Structure](#4-project-structure)
5.  [Setup and Installation](#5-setup-and-installation)
6.  [Running Tests](#6-running-tests)
7.  [Automated Scenarios](#7-automated-scenarios)
8.  [Allure Reporting](#8-allure-reporting)
9.  [Logging](#9-logging)
10. [Git Workflow](#10-git-workflow)

------------------------------------------------------------------------

## 1. Project Overview

The **Precision UI BDD Automation Framework** is designed to automate
user interactions and validate functionality in an e-commerce web
application.

The framework uses the **Behaviour Driven Development (BDD)** approach
with Cucumber. Test scenarios are written in Gherkin syntax in feature
files, while their implementation is maintained in Java step definition
classes. Selenium WebDriver is used for browser automation, and TestNG
is used to execute the tests.

### Key Features

-   UI automation using Selenium WebDriver.
-   BDD test scenarios using Cucumber feature files.
-   Page Object Model (POM) to separate page interactions from test
    steps.
-   Driver and browser option management through factory classes.
-   Reusable utilities for configuration, logging, screenshots, and
    waits.
-   Test execution through TestNG runners.
-   Allure reporting for test execution results.

------------------------------------------------------------------------

## 2. Tech Stack

  Technology / Tool    Purpose
  -------------------- ---------------------------------
  Java 21              Programming language
  Selenium WebDriver   Browser automation
  Cucumber             BDD and Gherkin-based scenarios
  TestNG 7.12.0        Test execution
  Maven                Build and dependency management
  Log4j2               Logging
  Allure Reports       Test execution reporting
  Git                  Version control
  GitHub               Source code hosting
  Eclipse IDE          Development environment

Check the `pom.xml` file for the exact dependency and plugin versions
used by the project.

------------------------------------------------------------------------

## 3. Prerequisites

Install the following before running the project:

  Software             Requirement
  -------------------- ---------------------------------------------------------
  JDK                  Java 21
  Maven                Installed and configured in PATH
  Browser              Browser supported by the project's driver configuration
  Allure Commandline   Allure 2.x, for viewing Allure reports
  Git                  For cloning and version control
  Eclipse IDE          Optional, for importing and running the project

### Verify the installations

``` bash
java -version
mvn -version
git --version
allure --version
```

The `allure --version` command is needed only if you want to use the
Allure command-line reporting commands.

------------------------------------------------------------------------

## 4. Project Structure

The following structure is based on the current Eclipse project layout.

``` text
precision-ui-bdd-automation-framework/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── drivers/
│   │   │   │   ├── DriverFactory.java
│   │   │   │   └── OptionsFactory.java
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   └── SearchMobilePage.java
│   │   │   │
│   │   │   └── utils/
│   │   │       ├── ConfigReader.java
│   │   │       ├── LogsFactory.java
│   │   │       ├── ScreenShotUtil.java
│   │   │       └── WaitUtil.java
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   │   └── Hooks.java
│       │   │
│       │   ├── runners/
│       │   │   ├── ParallelTestRunner.java
│       │   │   └── TestRunner.java
│       │   │
│       │   └── stepdefinitions/
│       │       ├── ProductSteps.java
│       │       └── SearchForPhoneSteps.java
│       │
│       └── resources/
│           ├── features/
│           │   ├── f1_SearchForIPhone.feature
│           │   └── f2_AddProduct.feature
│           │
│           ├── allure.properties
│           └── log4j2.xml
│
├── allure-report/                 # Generated Allure HTML report (if generated)
├── target/                        # Maven build and test output (generated)
│   ├── allure-results/
│   ├── cucumber-reports/
│   ├── generated-sources/
│   ├── generated-test-sources/
│   ├── logs/
│   ├── maven-status/
│   └── surefire-reports/
│
├── .gitignore
├── master-testng.xml
├── parallel-testng.xml
├── pom.xml
└── README.md
```

**Note:** `target/` and `allure-report/` contain generated output. They
are not source-code folders and should normally be excluded from Git
using `.gitignore`. The exact contents of `target/` can change after
each build or test execution.

### Important folders and files

  -----------------------------------------------------------------------
  Folder / File                       Description
  ----------------------------------- -----------------------------------
  `drivers/`                          Creates and manages WebDriver
                                      instances and browser options

  `pages/`                            Page Object classes containing page
                                      locators and actions

  `utils/`                            Reusable configuration, logging,
                                      screenshot, and wait utilities

  `hooks/`                            Cucumber setup and teardown hooks

  `runners/`                          TestNG-Cucumber runner classes

  `stepdefinitions/`                  Java implementations of the Gherkin
                                      steps

  `features/`                         Cucumber feature files containing
                                      test scenarios

  `config.properties`                 Application and framework
                                      configuration

  `allure.properties`                 Allure result output configuration

  `log4j2.xml`                        Log4j2 logging configuration

  `master-testng.xml`                 TestNG suite configuration

  `parallel-testng.xml`               TestNG suite configuration for
                                      parallel execution

  `pom.xml`                           Maven dependencies and build
                                      configuration
  -----------------------------------------------------------------------

------------------------------------------------------------------------

## 5. Setup and Installation

### Step 1 --- Clone the repository

``` bash
git clone https://github.com/ramyao8/precision-bdd-ui-automation-framework.git
cd precision-bdd-ui-automation-framework
```

### Step 2 --- Build the project

``` bash
mvn clean compile
```

This removes the previous Maven build output and compiles the project
source code.

### Step 3 --- Run the tests

``` bash
mvn clean test
```

Maven downloads the dependencies declared in `pom.xml`, compiles the
project, and executes the tests using the configured test runner.

------------------------------------------------------------------------

## 6. Running Tests

Run the commands from the project root directory.

### Run the configured test suite

``` bash
mvn clean test
```

### Run using the TestNG suite XML files

Run the suite configured in `master-testng.xml`:

``` bash
mvn test -Dsurefire.suiteXmlFiles=master-testng.xml
```

Run the suite configured in `parallel-testng.xml`:

``` bash
mvn test -Dsurefire.suiteXmlFiles=parallel-testng.xml
```

These commands depend on the Maven Surefire configuration in `pom.xml`.
Alternatively, in Eclipse, right-click the relevant XML suite file and
select **Run As → TestNG Suite**.

------------------------------------------------------------------------

## 7. Automated Scenarios

The current feature files shown in the project are:

  -----------------------------------------------------------------------
  Feature File                        Purpose
  ----------------------------------- -----------------------------------
  `f1_SearchForIPhone.feature`        Automates searching for a phone
                                      using the application's search
                                      functionality

  `f2_AddProduct.feature`             Automates adding a selected product
                                      and validating cart-related
                                      behaviour
  -----------------------------------------------------------------------

The product/cart workflow includes validations implemented in the
corresponding feature and step definition files. Refer to those files
for the exact steps and assertions.

------------------------------------------------------------------------

## 8. Allure Reporting

The framework uses **Allure Reports** to display test execution results.

### View the Allure report

After executing the tests, run:

``` bash
allure serve target/allure-results
```

This command serves the Allure results and opens the report in a
browser.

If your `allure.properties` file specifies a different results
directory, use that configured path instead.

### Generate a static HTML report

``` bash
allure generate target/allure-results --clean -o allure-report
```

### Open the generated report

``` bash
allure open allure-report
```

The report contains the test execution information collected by Allure.
The available details depend on the results and attachments produced
during the test run.

------------------------------------------------------------------------

## 9. Logging

The project uses **Log4j2** for logging.

-   `log4j2.xml` contains the logging configuration.
-   `LogsFactory.java` provides the project's logger utility.
-   The `target/logs/` directory is shown in the current project output
    and is used for generated log files.

Logs are useful for tracing test execution and investigating failures.

------------------------------------------------------------------------

## 10. Git Workflow

The project source code is maintained in GitHub on the `main` branch.

### Check the current branch

``` bash
git branch
```

### Pull the latest changes

``` bash
git pull origin main
```

### Stage and commit changes

``` bash
git add .
git commit -m "Describe your changes"
```

### Push changes to GitHub

``` bash
git push origin main
```

------------------------------------------------------------------------

## Author

**Ramya Sada**\
GitHub: [ramyao8](https://github.com/ramyao8)

------------------------------------------------------------------------

*This README documents the current Precision UI BDD Automation
Framework. Update it whenever the project structure, test scenarios,
configuration, or execution commands change.*
