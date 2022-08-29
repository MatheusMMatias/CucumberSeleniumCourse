package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //Variables
    public WebDriver driver;
    By search = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("h4.product-name");
    //By productName = By.xpath("//h4[@class='product-name']"); -- Same as above
    By topDealsPageLink = By.linkText("Top Deals");
    By inputProductQuantity = By.xpath("//input[@value]");
    By cartProductQuantity = By.xpath("//div[@class='cart-preview active']" +
            "//div//div//p[@class='quantity'][normalize-space()]");
    By incrementButton = By.className("increment");
    By addToCartButton = By.xpath("//button[normalize-space()='ADD TO CART']");
    By cartPreviewButton = By.xpath("//img[@alt='Cart']");
    By cartPageButton = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void searchProduct(String productShortName) {
        driver.findElement(search).sendKeys(productShortName);
    }

    public String getProductName() {
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public Integer getInputQuantity() {
        return Integer.parseInt(driver.findElement(inputProductQuantity).getAttribute("value"));
    }

    public Integer getCartQuantity() {
        if (!(driver.findElement(cartPageButton).isDisplayed())) {
            cartPreview();
            System.out.println("It was not displayed");
        };
        return Integer.parseInt(driver.findElement(cartProductQuantity).getText().split("N*")[0].trim());
    }

    public void goToTopDealsPage() {
        driver.findElement(topDealsPageLink).click();
    }

    public void goToCartPage() throws InterruptedException {
        cartPreview();
        driver.findElement(cartPageButton).click();
    }

    public void addProduct() {
        driver.findElement(incrementButton).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void cartPreview() {
        if (!(driver.findElement(cartPageButton).isDisplayed()))
            driver.findElement(cartPreviewButton).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }
}