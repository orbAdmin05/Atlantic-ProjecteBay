package page_objects;

import command_providers.ActOn;
import command_providers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class UnitedKingdomDomainPage extends NavigationBar {

    private final By UnitedKingdomSite = By.linkText("United Kingdom");
    private final By SearchItemInputField = By.id("gh-ac");
    private final By AcceptCookies = By.cssSelector("#gdpr-banner-accept");
    private final By CategoryDropDown = By.id("gh-cat");
    private final By SearchButton = By.id("gh-btn");
    private final By BooksTopic = By.xpath("//*[@id=\"x-refine__group_1__1\"]/ul/li[1]/div/a/div/span/input");
    private final By BooksFormat = By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input");
    private final By BooksGenre = By.xpath("//*[@id=\"x-refine__group_1__2\"]/ul/li[1]/div/a/div/span/input");
    private final By BooksCondition = By.xpath("//*[@id=\"x-refine__group__2\"]/ul/li[1]/div/a/div/span/input");
    private final By LivingHistory = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span");
    private final By ActualPriceInEuro = By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span");
    private final By AddToBasket = By.xpath("//*[@id=\"atcRedesignId_btn\"]");
    private final By GoToBasket = By.xpath("//*[@id=\"atcRedesignId_overlay-atc-container\"]/div/div[1]/div[2]/div[2]/a[2]/span/span");
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public UnitedKingdomDomainPage(WebDriver driver){
        super(driver);
    }

    public UnitedKingdomDomainPage clickOnUnitedKingdom(){
        LOGGER.debug("Clicking on United Kingdom");
        ActOn.element(driver,UnitedKingdomSite).click();
        LOGGER.debug("The New Domain is: " +driver.getCurrentUrl());
        return this;
    }
    public UnitedKingdomDomainPage typeSearchItem(String value){
        LOGGER.debug("Typing Search Item : " +value);
        ActOn.element(driver,SearchItemInputField).setValue(value);
        return this;
    }
    public UnitedKingdomDomainPage clickOnAcceptCookies() throws InterruptedException {
        LOGGER.debug("Clicking on Accept Cookies : ");
        Thread.sleep(3000);
        ActOn.element(driver,AcceptCookies).click();
        return this;
    }
    public UnitedKingdomDomainPage selectCategories(String category){
        LOGGER.debug("Select the Categories : " + category);
        ActOn.element(driver,CategoryDropDown).selectValue(category);
        return this;
    }
    public UnitedKingdomDomainPage clickOnSearchButton(){
        LOGGER.debug("Display the Search Item : ");
        ActOn.element(driver,SearchButton).click();
        return this;
    }
    public UnitedKingdomDomainPage selectBooksTopic(){
        LOGGER.debug("Select Books Topic : ");
        ActOn.element(driver,BooksTopic).click();
        return this;
    }
    public UnitedKingdomDomainPage selectBooksFormat(){
        LOGGER.debug("Select Books Format : ");
        ActOn.element(driver,BooksFormat).click();
        return this;
    }
    public UnitedKingdomDomainPage selectBooksGenre(){
        LOGGER.debug("Select Books Genre : ");
        ActOn.element(driver,BooksGenre).click();
        return this;
    }
    public UnitedKingdomDomainPage selectBooksConditions(){
        LOGGER.debug("Select Books Condition : ");
        ActOn.element(driver,BooksCondition).click();
        return this;
    }
    public UnitedKingdomDomainPage clickOnBooks(){
        LOGGER.debug("Clicking On Living History: ");
        ActOn.element(driver,LivingHistory).click();
        return this;
    }
    public UnitedKingdomDomainPage clickOnAddToBasket(){
        Set<String> childWindowHandles = driver.getWindowHandles();
        for (String handle : childWindowHandles) {
            driver.switchTo().window(handle);
        }
        LOGGER.debug("Books added to the Basket : ");
        ActOn.element(driver,AddToBasket).click();
        return this;
    }
    public UnitedKingdomDomainPage clickOnGoToBasket() throws InterruptedException {
        Thread.sleep(3000);
        LOGGER.debug("Clicking on GoToBasket Button ");
        ActOn.element(driver,GoToBasket).click();
        return this;
    }
    public UnitedKingdomDomainPage validatePriceInEuro(String expectedBookPriceInEuro){
        LOGGER.debug("Validate to Price in Euro : " +expectedBookPriceInEuro);
        String actualBookPriceInEuro = ActOn.element(driver,ActualPriceInEuro).getTextValue();
        Assert.assertEquals(expectedBookPriceInEuro,actualBookPriceInEuro);
        return this;
    }
}
