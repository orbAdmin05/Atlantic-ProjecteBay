package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.CamerasAndPhotoPage;
import utilities.ReadConfigFiles;

public class CamerasAndPhotoSteps {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^user is in eBay home page$")
    public void invokeeBaySearchPage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("eBayAppURL"));
        LOGGER.info("------Start eBay Cameras Brand Name Test--------- ");
        LOGGER.info("User is in the eBay Search Page");
    }
    @And("^user navigate to electronics$")
    public void navigateToElectronics(){
        new CamerasAndPhotoPage(driver)
                .mouseHoverToElectronics();
        LOGGER.info("Hover over electronics link: ");
    }
    @When("^user performs required steps to find cameras brand$")
    public void clickOnCamerasBrand(){
        new CamerasAndPhotoPage(driver)
                .ClickOnCamerasAndPhoto()
                .printCameraBrandName();
        LOGGER.info("Display all Cameras and Photo :");
    }
    @Then("^the brand name is \"(.+?)\"$")
    public void validateCamerasBrand(String nikon){
        new CamerasAndPhotoPage(driver)
                .ClickOnNikon()
                .validateCamerasBrand(nikon);
        LOGGER.info("Cameras Brand Name is Validate");
        LOGGER.info("------End eBay Cameras Brand Name Test--------- ");
    }
}
