User Documentation: Selenium Cucumber Project

1. Introduction:
   - This user documentation provides an overview of the Selenium Cucumber project structure and its key components.

2. Project Structure:
   - The project follows a modular structure with the following packages:
     - com.happiestminds.supertailsSearch.pages:
       - This package contains the page classes that store information about each page using the PageFactory approach.
     - com.happiestminds.supertailsSearch.scenarios:
       - This package contains the step definitions for all the features used in the project.
     - com.happiestminds.supertailsSearch.screenshots:
       - This package contains the screenshot class responsible for capturing screenshots when a test fails.
     - com.happiestminds.supertailsSearch.setupBrowser:
       - This package contains the Browser class responsible for browser configuration.
     - com.happiestminds.supertailsSearch.testRunner:
       - This package contains the TestRunner class, which runs all the scenarios in one go.

3. Resources Folder:
   - The resources folder contains the following files:
     - features folder:
       - This folder contains all the cucumber feature files where scenarios and steps are defined.
     - browserInfo.properties:
       - This file stores browser information in a key-value format, which is accessed by the Browser class for configuration.
     - log4j2.properties:
       - This file contains the log4j properties for logging purposes.

4. Generated Reports:
   - The project generates the following reports:
     - Cucumber Report:
       - This report provides detailed information on the execution status of each scenario.
     - ExtentReport:
       - This report offers a comprehensive view of the test execution, including test results, logs, and screenshots.
     - AllureReport:
       - This report provides a visually appealing representation of test execution, including detailed test steps, attachments, and statistics.
     - TestNG Report:
       - This report displays the test results in a structured manner, including test status, duration, and error details.

5. Usage Instructions:
   - To use the Selenium Cucumber project, follow these steps:
     1. Set up the project by importing it into your preferred IDE.
     2. Update the browserInfo.properties file with the desired browser configuration.
     3. Write feature files in the features folder, specifying scenarios and steps.
     4. Implement the step definitions in the scenarios package to define the behavior for each step.
     5. Utilize the page classes in the pages package to interact with web elements on different pages.
     6. Run the TestRunner class to execute all the scenarios.
     7. Access the generated reports (Cucumber Report, ExtentReport, AllureReport, TestNG Report) in the respective folders for detailed test results.

6. Additional Considerations:
   - Ensure that all required dependencies are included and up to date.
   - Customize the reports and logging configurations as per project requirements.
   - Refer to the documentation of the specific tools used (such as Cucumber, Selenium, TestNG, Allure) for advanced usage and troubleshooting.

7. Dependencies:
- org.apache.logging.log4j:log4j-core (version 2.22.0):
	- Log4j is a logging framework used for generating logs in the application. This dependency provides the core functionality of Log4j.

- io.qameta.allure:allure-testng (version 2.24.0):
	- Allure is a test report generation framework that provides detailed and visually appealing reports. This dependency integrates Allure with TestNG, enabling the generation of Allure reports for TestNG-based tests.

- io.cucumber:cucumber-junit (version 7.14.0):
	- Cucumber is a behavior-driven development (BDD) framework that allows the creation of test scenarios in a human-readable format. This dependency integrates Cucumber with JUnit, enabling the execution of Cucumber scenarios using JUnit.

- org.slf4j:slf4j-api (version 2.0.7):
	- Simple Logging Facade for Java (SLF4J) is a logging framework that provides a common interface for various logging frameworks. This dependency provides the SLF4J API.

- org.slf4j:slf4j-simple (version 2.0.7):
	- This is a simple SLF4J binding implementation used for testing purposes. It allows the logging information to be displayed on the console during test executions.

- io.cucumber:cucumber-testng (version 7.14.0):
	- This dependency provides integration between Cucumber and TestNG, allowing the execution of Cucumber scenarios using TestNG.

- info.cukes:gherkin (version 2.12.2):
	- Gherkin is a domain-specific language used to write Cucumber feature files. This dependency provides the Gherkin parser, enabling the interpretation of feature files.

- io.cucumber:cucumber-core (version 7.15.0):
	- This dependency provides the core functionality of Cucumber, including the execution engine and supporting classes.

- io.cucumber:cucumber-java (version 7.15.0):
	- This dependency provides the Java implementation for Cucumber, allowing step definitions to be written in Java.

- io.cucumber:cucumber-picocontainer (version 5.7.0):
	- PicoContainer is a lightweight dependency injection container. This dependency integrates PicoContainer with Cucumber, allowing step definitions to leverage dependency injection.

- io.cucumber:cucumber-expressions (version 10.1.0):
	- Cucumber Expressions provide a way to map plain text to method arguments in step definitions. This dependency provides the support for Cucumber Expressions.

- org.seleniumhq.selenium:selenium-java (version 4.16.1):
	- Selenium is a popular framework for automating web browsers. This dependency provides the Java bindings for Selenium, allowing interaction with web browsers programmatically.

- org.apache.poi:poi-ooxml (version 5.2.3):
	- Apache POI is a library for working with Microsoft Office documents. This dependency specifically provides support for reading and writing Office Open XML (OOXML) file formats.

- junit:junit (version 4.13.2):
	- JUnit is a widely-used unit testing framework for Java. This dependency provides the necessary libraries for writing and executing JUnit tests.

- com.fasterxml.jackson.core:jackson-databind (version 2.16.0):
	- Jackson is a popular library for working with JSON data in Java. This dependency provides the core functionality of Jackson, including data binding between Java objects and JSON.

- org.testng:testng (version 7.4.0):
	- TestNG is a testing framework that provides advanced testing features and flexibility. This dependency provides the TestNG library for executing tests and generating reports.