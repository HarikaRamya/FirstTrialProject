package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failedrerun.txt",
		glue= {"stepDefinitions"},
		monochrome=true,
		plugin= {"pretty", "html:test-output/cucumber.html"},
		tags= "@smokeTest, @RegressionTest"		)
public class FailedRerun {

}
