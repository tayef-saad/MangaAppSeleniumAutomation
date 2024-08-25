# MangaAppSeleniumAutomation
## Project Information

- **Project:**  Automation Test
- **Tested Application URL:** [https://myalice-automation-test.netlify.app](https://myalice-automation-test.netlify.app)
- **Automation Tool:** Selenium WebDriver
- **Programming Language:** Java
- **Browser:** Google Chrome

## Overview

This automation script is designed to test three main features of the Manga web application:

1. **Login Functionality**
2. **Manga Search and Display**
3. **Manga Details Modal**

The script performs these actions using Selenium WebDriver in Java with the Chrome browser.

### 1. Login Functionality

**Objective:**  
- To verify that the login functionality works correctly.

**Test Steps:**

1. **Open the Application:**
   - The script launches the Chrome browser and navigates to the application URL.

2. **Verify Login Page Display:**
   - The script checks if the login page is correctly displayed by verifying the presence of the login title.

3. **Enter Credentials:**
   - The script enters the username (`testuser`) and password (`password`) into their respective fields.

4. **Login:**
   - The script clicks the "Login" button.
   - After a successful login, the user should be redirected to the manga search page.

**Code Details:**

- **Method:** `performActionOnLoginPage()`
- **Key Functions:**
  - `setTextAndPerformAction()`: Enters text into the username and password fields.
  - `clickOnButton()`: Clicks on the login button.
  - `delay()`: Introduces a delay for actions to ensure proper loading and interaction.

### 2. Manga Search and Display

**Objective:**  
- To verify that searching for manga returns the correct results.

**Test Steps:**

1. **Ensure Search Page Display:**
   - After login, the script verifies that the search page is displayed.

2. **Search for Manga Titles:**
   - The script enters the search term "Naruto" and clicks the "Search" button.
   - The script then repeats this process for "One Piece" and "Seven Deadly Sins".

3. **Verify Search Results:**
   - The script checks that the correct manga cards are displayed for each search term.
   - A search with no results should display a "No manga found" message.

**Code Details:**

- **Method:** `performActionsOnSearchPage()`
- **Key Functions:**
  - `setTextAndPerformAction()`: Inputs search terms.
  - `clickOnButton()`: Executes the search action.
  - `searchTextArea.clear()`: Clears the search input field between searches.

### 3. Manga Details Modal

**Objective:**
- To verify that the manga details modal displays the correct information.

**Test Steps:**

1. **Open Manga Details Modal:**
   - After performing a search, the script clicks on the "Details" link of a manga card.

2. **Verify Modal Display:**
   - The script checks that the modal appears and displays the correct manga information (image, name, summary).

3. **Close Modal:**
   - The script clicks the "Close" button on the modal.
   - It verifies that the modal is closed and no longer visible.

**Code Details:**

- **Method:** `performActionsOnSearchPage()`
- **Key Functions:**
  - `clickOnButton()`: Opens the details modal.
  - `driver.findElement(By.xpath())`: Identifies elements like the details link and close button.

## Execution Environment:
- **Browser Driver Path:** The script specifies the path to the ChromeDriver in the `launchBrowser()` method.
- **Browser Setup:** The script configures the Chrome browser for automation and starts the session.
- **Dependencies:** Ensure that the ChromeDriver is properly installed and accessible via the path specified in the script.

This documentation provides an overview of the script's functionality, test cases, and how it interacts with the application. It serves as a guide for understanding and extending the automation tests.
