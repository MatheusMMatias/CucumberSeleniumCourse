package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    //Variables
    public WebDriver driver;

    //Methods
    public WebDriver webDriverManager() throws IOException {

        //Loading properties file to exclude hardcoded variables such as browser web driver and web app url
        FileInputStream fileInputStream = new FileInputStream("src\\test\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String mainBrowser = properties.getProperty("browser");
        String url = properties.getProperty("QAUrl");

        //Assigning browser from terminal execution with -Dbrowser=x
        String mavenBrowser = System.getProperty("browser");
        String browser = mavenBrowser!=null ? mavenBrowser : mainBrowser;

        if (driver == null) {
            if(browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver.exe");
                this.driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "D:/EdgeDriver/msedgedriver.exe");
                this.driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                //code for Firefox WebDriver
            }
            driver.get(url);
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); ImplicitlyWait not working very well
            //cause some scenarios to fail intermittently
        }
        return driver;
    }
}