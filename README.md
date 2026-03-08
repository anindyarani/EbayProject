eBay Advanced Search Testing Project

Overview
This project focuses on testing the Advanced Search module of the eBay website. The testing is conducted using both manual and automation approaches, with a primary focus on ensuring the search functionality works correctly under different scenarios.

The project is divided into two main automation test scenarios:
Search with Multiple Filters Applied – verifying the system can handle multiple simultaneous filters correctly.
Search by Category – validating that users can search for products accurately using specific categories.

Manual testing is also conducted to cover the Advanced Search module comprehensively, while automation testing is focused on these two main scenarios.


Testing Approach
Manual Testing
Manual testing covers all key functionalities in the Advanced Search module, including filter validation, search result accuracy, and UI behavior.
Helps ensure exploratory and edge-case scenarios are validated that may not be included in automation.

Automation Testing
Automation focuses on the two main scenarios:
Multiply Filters Applied
Search by Category

Implemented using Selenium WebDriver with Java.

Tests are executed on both Google Chrome and Mozilla Firefox to ensure cross-browser compatibility.

Automation Setup
Java JDK 11 or higher
Chrome and Firefox browsers installed
IDE (e.g., IntelliJ IDEA, Eclipse)


Tools & Technologies
Selenium WebDriver (Java) – for automation testing
ChromeDriver & GeckoDriver – for running tests on Chrome and Firefox
Maven – dependency and project management
TestNG – test framework


Notes
Automation testing only covers the two main scenarios listed above.
Manual testing is conducted for complete coverage of Advanced Search functionality.
