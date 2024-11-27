# Automation Assessment - Setup and Execution Guide

## Assessment Overview

This assessment automates the **Validate Total Recurring Reimbursement** functionality for FitPeo using Selenium WebDriver and the Page Object Model (POM) design pattern. It includes configurations for cross-browser and parallel execution using TestNG.

---

## Prerequisites

Ensure the following tools and dependencies are installed and configured:

- **Java Development Kit (JDK):** Version 8 or above.
- **IDE:** Eclipse.
- **TestNG Plugin:** Installed in the IDE for test execution.

---

## Setup

### 1.Clone the Repository
Clone the project from the repository:

git clone https://github.com/AravindNagarajan9894/FitpeoAssesment.git

### 2.Import the Project into IDE.

### 3.Install Dependencies:
Open the pom.xml file.
Right-click and select Maven > Update Project to download all dependencies.

---

### Running the Automation Scripts

### 1. Run Tests with Master XML
This XML file executes the tests sequentially in a single browser environment.
 Navigate to the testng.xml file in the project.
 Right-click and select Run As > TestNG Suite.

### 2. Run Cross-Browser Tests
This configuration allows tests to run in multiple browsers.
Navigate to the testng-cross-browser.xml file.
Right-click and select Run As > TestNG Suite.

### 3. Run Tests in Parallel
This XML file runs tests in parallel across different browsers.
Navigate to the testng-parallel.xml file.
Right-click and select Run As > TestNG Suite.

---

## Viewing Test Results

### TestNG Report:
After execution, a detailed TestNG HTML report is generated in the test-output folder.
Open the index.html file to view the report.

### Logs:
Log files are generated in the logs directory (configured in log4j2.xml).
Default file: automation.log.

---
