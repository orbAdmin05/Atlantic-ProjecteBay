package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.eBaySearchPage;
import utilities.ReadConfigFiles;

public class iPhonePurchaseSteps {
    private static Logger LOGGER = LogManager.getLogger(iPhonePurchaseSteps.class);
    WebDriver driver = Hooks.driver;
    @Given("^a user on a given website to purchase the item$")
    public void navigateToeBayHomePage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start iPhone 14 Purchased successfully Test--------- ");
        LOGGER.info("User is in the eBay Search Page");
    }

    @When("^user see the search results upon a search for iPhone 14 from the search bar$")
    public void enterSearchItem(){
        new eBaySearchPage(driver)
                .typeSearchItem("iPhone 14")
                .selectCategories("Cell Phones & Accessories")
                .clickOnSearchButton()
                .setPriceRange("1000")
                .clickOnPriceArrow();
        LOGGER.info("Search Item Displayed upon entering the item name");
    }
    @And("^the user performs the required steps upon adding the item to the cart to purchase$")
    public void performsAllSteps() throws InterruptedException {
        new eBaySearchPage(driver)
                .clickOniPhone14()
                .clickOnAddToCart()
                .clickOnGoToCheckOut()
                .clickOnLightBox();
        LOGGER.info("After performed required steps user can proceed to check out page ");
    }
    @And("^the user adding the shipping address to continue purchase$")
    public void enterUserInformation() throws InterruptedException {
            new eBaySearchPage(driver)
                .enterFirstName("David")
                .enterLastName("Alaba")
                .enterStreetAddress("14828 Jamaica Ave")
                .enterCityName("Jamaica")
                .selectStateName("New York")
                .enterZipCode("11435")
                .enterEmailId("morbed11@gmail.com")
                .enterConfirmEmailId("morbed11@gmail.com")
                .enterPhoneNumber("9294446861")
                .clickOnDoneButton();
        LOGGER.info("After performed all required steps user will reach check out page ");
    }
    @Then("^user will reach at \"(.+?)\"$")
    public void itemPurchasedSuccessfully(String Checkout) {
        new eBaySearchPage(driver)
                .validateCheckOut(Checkout);
        LOGGER.info("User Purchased iPhone Successfully");
        LOGGER.info("------End iPhone 14 Purchased successfully Test--------- ");
    }

}
