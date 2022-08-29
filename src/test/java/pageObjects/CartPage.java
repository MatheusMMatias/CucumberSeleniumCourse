package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    //Variables
    public WebDriver driver;
    By productName = By.xpath("//p[@class='product-name']");
    By productQuantity = By.xpath("//p[@class='quantity']");

    public By applyButton = By.xpath("//button[@class='promoBtn']");
    public By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");

    public String CartPageUrl = "https://rahulshettyacademy.com/seleniumPractise/#/cart";

    //Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName(){
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public Integer getProductQuantity(){
        return Integer.parseInt(driver.findElement(productQuantity).getText());
    }

    public Boolean verifyApplyButton(){
        return driver.findElement(applyButton).isDisplayed();
    }

    public Boolean verifyPlaceOrderButton(){
        return driver.findElement(placeOrderButton).isDisplayed();
    }
}
