package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.core.gherkin.Pickle;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="\\Users\\Ramya Harika\\cucumberBDD\\BDDFramework\\src\\main\\java\\Feature\\login.feature",
		glue= {"stepDefinitions"},
		tags= "@smokeTest",
		monochrome=true,
		
		plugin= {"pretty", "html:test-output/cucumber.html", "rerun:target/failedrerun.txt"}
			)
public class TestRunner extends AbstractTestNGCucumberTests{
	private TestNGCucumberRunner testNGCucumberRunner;
		
		@BeforeClass(alwaysRun=true)
		public void setUpClass() {
			testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		}
		
		@Test(groups="cucumber", description="Run Cucumber Tests", dataProvider="features")
		public void feature(PickleWrapper wrapper, FeatureWrapper featureWrapper) {
			testNGCucumberRunner.runScenario(wrapper.getPickle());
		}
		
		@DataProvider
		public Object[][] features(){
			return testNGCucumberRunner.provideScenarios();
		}
		
		@AfterClass
		public void tearDown() {
			testNGCucumberRunner.finish();
		}
}
