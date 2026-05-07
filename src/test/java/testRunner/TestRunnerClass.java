package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//features"},
				glue= {"stepDefinitions","hooks"}, 
				plugin= {"pretty", "html:target/cucumber-html-reports/myreport.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"rerun:target/rerun.txt"},
				dryRun=false,
				monochrome=true,
				publish=true )
public class TestRunnerClass 
{

}
