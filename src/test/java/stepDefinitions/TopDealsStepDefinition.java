package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.TopDealsPage;
import utils.TestContextSetup;

public class TopDealsStepDefinition {

    //Variables
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    //Constructor
    public TopDealsStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    //Step Definitions
    @Then("^the user search with the same name (.*) in top deals page$")
    public void theUserSearchWithTheSameNameInTopDealsPageAndItShouldAppear(String productShortName) throws InterruptedException {
        Thread.sleep(200);
        switchToTopDealsPage(testContextSetup.pageObjectManager.getTopDealsPage());
        TopDealsPage TopDealsPage = testContextSetup.pageObjectManager.getTopDealsPage();
        TopDealsPage.searchProduct(productShortName);
        Thread.sleep(200);
        offerPageProductName = TopDealsPage.getProductName();
    }

    @Then("it should appear and match home page")
    public void itShouldAppearAndMatchHomePage() {
        Assert.assertEquals(offerPageProductName, testContextSetup.homePageProductName);
    }

    //Methods
    public void switchToTopDealsPage(TopDealsPage TopDealsPage) {

        if (testContextSetup.driver.getCurrentUrl().equalsIgnoreCase(TopDealsPage.topDealsPageUrl)) {
            return;
        } else {
            HomePage HomePage = testContextSetup.pageObjectManager.getHomePage();
            HomePage.goToTopDealsPage();
            testContextSetup.genericUtils.switchToChildWindow();
        }
    }
}