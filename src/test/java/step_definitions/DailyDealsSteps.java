package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.DailyDealsFeaturedPage;
import utilities.ReadConfigFiles;

public class DailyDealsSteps {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^a user is on the eBay Home Page$")
    public void navigateToeBaySearchPage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start eBay Fall Daily Deals Test--------- ");
        LOGGER.info("User is in the eBay Search Page");
    }
    @And("^user navigate to daily Deals$")
    public void clickOnDailyDealsLink(){
        new DailyDealsFeaturedPage(driver)
                .clickOnDailyDeals();
        LOGGER.info("Open Daily Deals Featured page: ");
    }
    @When("^user click on daily deals to check fall products$")
    public void clickOnPumaProducts(){
        new DailyDealsFeaturedPage(driver)
                .mouseHoverToFeatured()
                .navigateToFallDeals();
        LOGGER.info("Clicking on Fall Products:");
    }
    @Then("^the fall feature is \"(.+?)\"$")
    public void validatePumaDailyDeals(String deals){
        new DailyDealsFeaturedPage(driver)
                .validateFallDeals(deals);
         LOGGER.info("Fall Daily Deals is Validate");
        LOGGER.info("------End eBay Fall Daily Deals Test--------- ");
    }
}
