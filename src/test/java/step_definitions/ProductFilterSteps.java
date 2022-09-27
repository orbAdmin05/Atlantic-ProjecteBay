package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.ProductsFilteringPage;
import utilities.ReadConfigFiles;

public class ProductFilterSteps {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^user navigate to ebay home page$")
    public void openeBaySearchPage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start Product Filter Result Test--------- ");
        LOGGER.info("User is in the eBay Search Page");
    }
    @And("^user search the product$")
    public void navigateToInputField(){
        new ProductsFilteringPage(driver)
                .typeItemName("laptop")
                .clickOnSearchButton();
        LOGGER.info("User enter product name : ");
    }
    @When("^user apply the filtering$")
    public void performFiltering(){
        new ProductsFilteringPage(driver)
                .clickOnRamSize()
                .clickOnScreenSize()
                .clickOnOperatingSystem()
                .clickOnProcessor()
                .clickOnBrand()
                .clickOnCondition()
                .clickOnMinPrice("1000")
                .clickOnPriceArrow();
         LOGGER.info("User applied filter");
    }
    @Then("^user check the filter result$")
    public void getFilterResult(){
        new ProductsFilteringPage(driver)
                .captureFilteredResult();
        LOGGER.info("Displayed the filter Result ");
        LOGGER.info("------End Product Filter Result Test--------- ");

    }

}
