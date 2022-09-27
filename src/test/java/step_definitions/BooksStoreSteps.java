package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.BooksStoresPage;
import utilities.ReadConfigFiles;

public class BooksStoreSteps {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^a user is on the given website$")
    public void openeBaySearchPage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start eBay Books Store Name Test--------- ");
        LOGGER.info("User is in the eBay Search Page");
    }
    @And("^user navigate to stores$")
    public void navigateToStores() {
        new BooksStoresPage(driver)
                .mouseHoverToStores()
                .clickOnStores();
        LOGGER.info("Clicking on Stores link: ");
    }
    @When("^user performs required steps to find the stores$")
    public void findBooksStore(){
        new BooksStoresPage(driver)
                .typeStoresName("Books Of Valor")
                .clickOnSearchButton();
        LOGGER.info("Display Store Name :");
    }
    @Then("^the online store is \"(.+?)\"$")
    public void validateStoreName(String books){
        new BooksStoresPage(driver)
                .clickOnBooksOfValor()
                .validateBooksStore(books);
        LOGGER.info("Books Store Name is Validate");
        LOGGER.info("------End eBay Books Store Name Test--------- ");
    }
}
