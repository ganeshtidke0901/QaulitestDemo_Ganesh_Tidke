package uk.brentwood.test.ganesh.testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * 
 * @author ganesh
 * 
 *         This class act as a TestNG runner to trigger cucumber framework by passing different
 *         options e.g stepdefinition path, feature path
 *
 */
@CucumberOptions(features = "src/test/resources/features", glue = {
		"uk.brentwood.test.ganesh.stepdefinations" }, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:target/index.html",
				"json:target/cucumber.json" }, tags = "@smoke")

public class TestNGTest extends AbstractTestNGCucumberTests {

	// -Ddataproviderthreadcount=2
	/**
	 *	This method helps running scenarios in parallel where we need to pass  dataproviderthreadcount value(thread count) as system properties
	 */
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
