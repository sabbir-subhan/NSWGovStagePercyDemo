package runnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
							glue = "stepDefinations",
							plugin = {"pretty","html:Report"},
							monochrome = true)
public class RunJunitTest {	
}

