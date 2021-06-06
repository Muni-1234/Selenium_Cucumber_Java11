package config;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	                //features = {"src/test/resources/features"},
	                features = "src/test/resources/features/orangehrm.feature",
	                glue = {"StepDefinitions"},
	                dryRun = false,
	                monochrome = true,
	                plugin = {"json:target/cucumber.json", "html:target/site.cucumber-pretty"},
	                tags = {"@UAT"}	
)

public class Test_Runner {

}