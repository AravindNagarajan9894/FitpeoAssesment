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

### Clone the Repository
Clone the project from the repository:
```bash
git clone https://github.com/AravindNagarajan9894/FitpeoAssesment.git
```bash
## Running the Automation Scripts

1. Run Tests with Master XML
This XML file executes the tests sequentially in a single browser environment.
 Navigate to the testng.xml file in the project.
 Right-click and select Run As > TestNG Suite.

2. Run Cross-Browser Tests
This configuration allows tests to run in multiple browsers.
Navigate to the testng-cross-browser.xml file.
Right-click and select Run As > TestNG Suite.

3. Run Tests in Parallel
This XML file runs tests in parallel across different browsers.
Navigate to the testng-parallel.xml file.
Right-click and select Run As > TestNG Suite.



