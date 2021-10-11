package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(		
		features={"Feature"},
		glue={"StepDefinations"	},
		dryRun=false,
		monochrome=true,
		publish=true,	
		plugin = {"pretty","summary", "json:target/cucumber.json","html:target/CucumberReports/reports.html"},
		tags= "@PositiveScenerio or @NegativeScenerio or @PositiveTesting"		
		)

public class TestRunner {
	
}
