package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.TestContextSetup;
import org.junit.Assert;

public class HomePageStepDefinition {

    //Variables
    TestContextSetup testContextSetup;
    HomePage HomePage;

    //Constructor
    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.HomePage = testContextSetup.pageObjectManager.getHomePage();
    }

    //Step Definitions
    @Given("the user is on GreenKart home page")
    public void theUserIsOnGreenKartHomePage() {
        Assert.assertTrue(HomePage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^the user search for (.+) and product is shown$")
    public void theUserSearchForAndProductIsShown(String productShortName) throws InterruptedException {
        HomePage.searchProduct(productShortName);
        Thread.sleep(1000);
        testContextSetup.homePageProductName = HomePage.getProductName();
    }

    @When("^the user add (\\d*) units of the product$")
    public void theUserAddUnitsOfTheProduct(Integer quantity) {
        while (HomePage.getInputQuantity() < quantity) {
            HomePage.addProduct();
        }
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        HomePage.addToCart();
        HomePage.cartPreview();
        testContextSetup.homePageCartQuantity = HomePage.getCartQuantity();
    }

    @When("the user goes to the cart page")
    public void theUserGoesToTheCartPage() throws InterruptedException {
        HomePage.goToCartPage();
        //TimeUnit.SECONDS.sleep(1);
        Thread.sleep(1000); //For some reason, thread sleep + implicit wait causes tests to fail - need further investigation
        Assert.assertTrue(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase(
                testContextSetup.pageObjectManager.getCartPage().CartPageUrl));
    }
}