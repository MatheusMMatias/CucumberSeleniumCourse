package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.CartPage;
import utils.TestContextSetup;

public class CartPageStepDefinition {

    //Variables
    TestContextSetup testContextSetup;
    CartPage CartPage;

    //Constructor
    public CartPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.CartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    //Step Definitions
    @Then("the product should be there")
    public void theProductAndShouldBeThere() {
        Assert.assertEquals(CartPage.getProductName(),
                testContextSetup.homePageProductName);
    }

    @Then("the amount should be correct")
    public void theAmountShouldBeCorrect() {
        Assert.assertEquals(CartPage.getProductQuantity(),
                testContextSetup.homePageCartQuantity);
    }

    @Then("the Apply button should be available")
    public void theApplyButtonIsAvailable() {
        Assert.assertTrue(CartPage.verifyApplyButton());
    }

    @Then("the Place Order button should be available")
    public void thePlaceOrderButtonIsAvailable() {
        Assert.assertTrue(CartPage.verifyPlaceOrderButton());
    }
}