package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.RateCardTablePage;
import utilities.ReadConfigFiles;

public class RateCardSteps {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^a user open ebay home page$")
    public void openHomePage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start eBay Rate Card Test--------- ");
        LOGGER.info("User is in the eBay Home Page");
    }
    @And("^user open up affiliates service$")
    public void openAffiliatesLink() {
        new RateCardTablePage(driver)
                .clickOnAffiliates()
                .mouseHoverToSolutions();
        LOGGER.info("Clicking on Affiliates link: ");
    }
    @When("^user perform required steps to find rate card table$")
    public void clickOnRateCard(){
        new RateCardTablePage(driver)
                .clickOnRateCard();
        LOGGER.info("Clicking on Rate Card");
    }
    @Then("^user see \"(.+?)\" table$")
    public void validateeBayRateCard(String ratecard){
        new RateCardTablePage(driver)
                .validateRateCard(ratecard);
        LOGGER.info("eBay Rate Card is Validated");
        LOGGER.info("------End eBay Rate Card Test--------- ");
    }
}
