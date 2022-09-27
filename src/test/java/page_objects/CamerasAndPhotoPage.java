package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CamerasAndPhotoPage extends NavigationBar {

    private final By ElectronicsLink = By.linkText("Electronics");
    private final By CamerasPhoto = By.linkText("Cameras & Photo");
    private final By NikonCamera = By.linkText("Nikon");
    private final By BrandSection = By.xpath("//*[@id=\"s0-16-12-0-1[2]-0-0-0\"]");
    private final By ActualCamerasBrand = By.xpath("/html/body/div[4]/div[2]/h1/span");

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public CamerasAndPhotoPage(WebDriver driver){
        super(driver);
    }

    public CamerasAndPhotoPage mouseHoverToElectronics(){
        LOGGER.debug("Mouse Hover to the Electronics Link");
        ActOn.element(driver,ElectronicsLink).mouseHover();
        return this;
    }
    public CamerasAndPhotoPage ClickOnCamerasAndPhoto(){
        LOGGER.debug("Clicking on the Cameras and Photo Link");
        ActOn.element(driver,CamerasPhoto).click();
        return this;
    }
    public CamerasAndPhotoPage ClickOnNikon(){
        LOGGER.debug("Clicking on the Nikon Link");
        ActOn.element(driver,NikonCamera).click();
        return this;
    }
    public CamerasAndPhotoPage printCameraBrandName(){
        LOGGER.debug("Clicking on the Nikon Link");
        WebElement shopByBrandsSection = driver.findElement(BrandSection);
        LOGGER.debug("Total Number of Cameras Brand is: " +shopByBrandsSection.findElements(By.tagName("a")).size());
        List<WebElement> brandsLinks = shopByBrandsSection.findElements(By.tagName("a"));
        for (WebElement Links:brandsLinks) {
            LOGGER.debug("Cameras Brand Name is : " +  Links.getText());
        }
        return this;
    }
    public CamerasAndPhotoPage validateCamerasBrand(String expectedBrand){
        LOGGER.debug("Validate Cameras Brand Name is: "+expectedBrand);
        String actualBrand = ActOn.element(driver,ActualCamerasBrand).getTextValue();
        Assert.assertEquals(expectedBrand,actualBrand);
        return this;
    }

}
