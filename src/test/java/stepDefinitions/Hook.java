package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hook {

    //Variables
    TestContextSetup testContextSetup;
    WebDriver driver;

    //Constructor
    public Hook(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.driver = this.testContextSetup.testBase.webDriverManager();
    }

    //Hooks
    @After
    public void afterScenario(){
        testContextSetup.driver.quit();
    }

    @AfterStep
    public void inCaseOfFail(Scenario scenario) throws IOException {
        if(scenario.isFailed()){ //Taking screenshot on failed scenarios
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] byteImage = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(byteImage, "image/png", "image");
        }
    }
}