package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.ProductAddRemovePage;
import utilities.ReadConfigFiles;

public class ProductRemoveSteps {

    private static Logger LOGGER = LogManager.getLogger(iPhonePurchaseSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^user is on the ebay search page$")
    public void navigateToeBayHomePage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start Product Removed successfully Test--------- ");
        LOGGER.info("User is in the eBay Search Page");
    }
    @And("^user search the required product$")
    public void enterProductName(){
        new ProductAddRemovePage(driver)
                .typeProductName("mountain bike")
                .clickOnSearchButton();
        LOGGER.info("User Search the Product");
    }
    @And("^user add a product to the cart$")
    public void productAddToCart() throws InterruptedException {
        new ProductAddRemovePage(driver)
                .clickOnMountainBike()
                .clickOnAddToCart()
                .clickOnNoThanks();
        LOGGER.info("Added Product to the cart");
    }
    @When("^user remove the product from the cart$")
    public void ProductRemoveFromCart() throws InterruptedException {
        new ProductAddRemovePage(driver)
                .removeProductFormCart();
        LOGGER.info("Removed Product from the Cart");
    }
    @Then("^user see the message \"(.+?)\"$")
    public void validateRemovedProduct(String removedMessage) {
        new ProductAddRemovePage(driver)
                .validateRemove(removedMessage);
        LOGGER.info("User Removed Product Successfully");
        LOGGER.info("------End Product Removed successfully Test--------- ");
    }
}
