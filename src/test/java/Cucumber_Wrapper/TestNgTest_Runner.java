package Cucumber_Wrapper;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Cucumber can't run on its own it needs to depends on TestNg or Junit
// we can't use groups/Data Provide in cucumber in like TestNg 
// to Run the Test we have to provide paths 
@CucumberOptions(features = "src/test/java/Cucumber_Wrapper", 
		glue = "seleniumRaj.stepDefinitions", 
		monochrome = true,
		tags ="@ErrorValidations",
		plugin = {"html:target/cucumber.html" }
		)
public class TestNgTest_Runner extends AbstractTestNGCucumberTests {
	
}
