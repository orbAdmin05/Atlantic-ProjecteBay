package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.UserAgreementPolicesPage;
import utilities.ReadConfigFiles;

public class UserAgreementPolicesSteps {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^user is in the ebay home page$")
    public void userGoToeBayHomePage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start Payment Services Polices Test--------- ");
        LOGGER.info("User is in the eBay Home Page");
    }
    @And("^user navigate to policies$")
    public void navigateToPolices(){
        new UserAgreementPolicesPage(driver)
                .clickOnPolices();
        LOGGER.info("User open the Polices Link");
    }
    @When("^user performs all the required steps$")
    public void agreementPolices(){
        new UserAgreementPolicesPage(driver)
                .clickOnMemberBehaviourPolices()
                .clickOnUserAgreement()
                .clickOnPaymentServices();
        LOGGER.info("User find out Payment Services Polices");
    }
    @Then("^user will see the article \"(.+?)\"$")
    public void validatePolices(String polices){
        new UserAgreementPolicesPage(driver)
                .validatePaymentServicesPolices(polices);
        LOGGER.info("Payment Services Polices Validated");
        LOGGER.info("------End Payment Services Polices Test--------- ");
    }
}
