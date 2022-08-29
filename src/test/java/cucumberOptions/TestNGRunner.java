package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports/lastExecution.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed-scenarios.txt"},
        tags = "@Regression"
)
public class TestNGRunner {

}