package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectManager {

    //Variables
    public HomePage HomePage;
    public TopDealsPage TopDealsPage;
    public CartPage CartPage;
    public WebDriver driver;

    //Constructor
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    //PageObjects Factory Constructors
    public HomePage getHomePage(){
        HomePage = new HomePage(driver);
        return HomePage;
    }

    public TopDealsPage getTopDealsPage(){
        TopDealsPage = new TopDealsPage(driver);
        return TopDealsPage;
    }

    public CartPage getCartPage(){
        CartPage = new CartPage(driver);
        return CartPage;
    }

}
