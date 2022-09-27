package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ProductAddRemovePage extends NavigationBar{

    private final By SearchInputField = By.id("gh-ac");
    private final By SearchButton = By.id("gh-btn");
    private final By MountainBike = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span");
    private final By AddToCart = By.id("isCartBtn_btn");
    private final By NoThanksMessage = By.xpath("//*[@id=\"ADDON_0\"]/div/div[2]/div/div[4]/div/button[1]");
    private final By RemoveProduct = By.xpath("//*[@class=\"left-section\"]/div/div/div/ul/li/div/div/div/div[2]/span[2]/button");
    private final By ActualRemoveMessage = By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/div[1]/span/span/span");
    ////*[@id="mainContent"]/div/div[3]/div[1]/div/div[1]/span/span/span
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public ProductAddRemovePage(WebDriver driver) {
        super(driver);
    }

    public ProductAddRemovePage typeProductName(String value){
        LOGGER.debug("Typing Product Name: " +value);
        ActOn.element(driver,SearchInputField).setValue(value);
        return this;
    }
    public ProductAddRemovePage clickOnSearchButton(){
        LOGGER.debug("Display the Product: ");
        ActOn.element(driver,SearchButton).click();
        return this;
    }
    public ProductAddRemovePage clickOnMountainBike(){
        LOGGER.debug("Selected Mountain Bike: ");
        ActOn.element(driver,MountainBike).click();
        return this;
    }
    public ProductAddRemovePage clickOnAddToCart() throws InterruptedException {
        Set<String> newWindowHandles = driver.getWindowHandles();
        for (String handle : newWindowHandles) {
            driver.switchTo().window(handle); // move to new tab
        }
        LOGGER.debug("Mountain Bike Added to the Cart: ");
        Thread.sleep(3000);
        ActOn.element(driver,AddToCart).click();
        return this;
    }
    public ProductAddRemovePage clickOnNoThanks() throws InterruptedException {
        LOGGER.debug("Clicking on No Thanks");
        Thread.sleep(3000);
        ActOn.element(driver,NoThanksMessage).click();
        return this;
    }
    public ProductAddRemovePage removeProductFormCart() throws InterruptedException {
        LOGGER.debug("The product is no longer displayed in the cart");
        Thread.sleep(3000);
        ActOn.element(driver,RemoveProduct).click();
        return this;
    }
    public ProductAddRemovePage validateRemove(String expectedRemoveMessage){
        LOGGER.debug("Validate to remove product : " +expectedRemoveMessage);
        //String ActualRemoveMessage = "You don't have any items in your cart.";
        String actualRemoveMessage = ActOn.element(driver, ActualRemoveMessage).getTextValue();
        Assert.assertEquals(expectedRemoveMessage,actualRemoveMessage);
        return this;
    }

}
