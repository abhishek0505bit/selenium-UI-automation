
package com.happiestminds.supertailsSearch.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {
		"com.happiestminds.supertailsSearch.scenarios" }, tags = "@firstScenario or @secondScenario or @thirdScenario or @fourthScenario or @fifthScenario", plugin = {
				"pretty", "html:target/cucumber-reports.html" }, monochrome = true, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}

// pretty: html: target/cucumber reports.html
//is used to specify the output formats for the test reports. It indicates that
// the Cucumber test reports should be generated in two formats: "pretty" and
// "html," with the HTML report being saved in the
// "target/cucumber-reports.html" directory.

// Additionally, "monochrome = true" is used to output the console in
// monochrome, which typically means it would not use any colors or special
// formatting.

// publish = true" could be a custom flag set for publishing the reports,
