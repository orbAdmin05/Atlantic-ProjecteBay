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
import page_objects.UnitedKingdomDomainPage;
import utilities.ReadConfigFiles;

public class UnitedKingdomDomainSteps {

    private static Logger LOGGER = LogManager.getLogger(iPhonePurchaseSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^a user is on the ebay home page$")
    public void navigateToeBayHomePage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start Book Price is in Euro Test--------- ");
        LOGGER.info("User is in the eBay Home Page");
    }
    @And("^user navigate to united kingdom's page$")
    public void navigateToUnitedKingdomDomainPage(){
        new UnitedKingdomDomainPage(driver)
                .mouseHoverToeBaySite()
                .clickOnUnitedKingdom();
        LOGGER.info("User reach out United Kingdom Domain");
    }
    @When("^user add an item to the cart$")
    public void productAddToCart() throws InterruptedException {
        new UnitedKingdomDomainPage(driver)
                .typeSearchItem("Living History by Hillary Rodham Clinton New Book")
                .clickOnAcceptCookies()
                .selectCategories("Books, Comics & Magazines")
                .clickOnSearchButton()
                .selectBooksTopic()
                .selectBooksFormat()
                .selectBooksGenre()
                .selectBooksConditions()
                .clickOnBooks()
                .clickOnAddToBasket()
                .clickOnGoToBasket();
        LOGGER.info("Added Books to the Basket");
    }
    @Then("^user pay in euro instead of dollar which is \"(.+?)\"$")
    public void validateBooksPriceInEuro(String priceInEuro) {
        new UnitedKingdomDomainPage(driver)
                .validatePriceInEuro(priceInEuro);
        LOGGER.info("Books Price in Euro is Validated");
        LOGGER.info("------Edn Book Price is in Euro Test--------- ");
    }
}
