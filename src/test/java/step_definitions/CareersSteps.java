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
import page_objects.EbayCareersPage;
import utilities.ReadConfigFiles;

public class CareersSteps {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^user open ebay home page$")
    public void invokeeBaySearchPage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start eBay Job Title Test--------- ");
        LOGGER.info("User is in the eBay Search Page");
    }
    @And("^user navigate to careers link$")
    public void navigateToCareersLink() {
        new EbayCareersPage(driver)
                .clickOnCareers();
        LOGGER.info("Clicking on Careers link: ");
    }
    @When("^user performs required steps to find the desired job$")
    public void searchJob() throws InterruptedException {
        new EbayCareersPage(driver)
                .typeJobTittle("Senior iOS Engineer")
                .clickOnJobSearchButton();
        LOGGER.info("Display Searched Job :");
    }
    @Then("^the job title is \"(.+?)\"$")
    public void validateStoreName(String jobTitle) throws InterruptedException {
        new EbayCareersPage(driver)
                .clickOnSoftwareEngineer()
                .validateJobTitle(jobTitle);
        LOGGER.info("Job Title is Validate");
        LOGGER.info("------End eBay Job Title Test--------- ");
    }

}
