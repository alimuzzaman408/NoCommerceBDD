package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features={"Feature/AddCustomer.feature"},
		glue={"StepDefinations"	},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"}
	
		

		)


public class TestRunner {

}
