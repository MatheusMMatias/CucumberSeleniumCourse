package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed-scenarios.txt",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/lastExecution.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestNGRunnerFailed {

}