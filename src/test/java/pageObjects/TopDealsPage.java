package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopDealsPage {

    //Variables
    public WebDriver driver;
    By search = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("tr td:nth-child(1)");
    public String topDealsPageUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";


    //Constructor
    public TopDealsPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String productShortName){
        driver.findElement(search).sendKeys(productShortName);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
