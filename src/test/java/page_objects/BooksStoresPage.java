package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksStoresPage extends NavigationBar {

    private final By StoresLink = By.linkText("Stores");
    private final By StoresInputField =By.name("store_search");
    private final By SearchButton = By.xpath("//*[@id=\"mainContent\"]/section[1]/form/button/span");
    private final By BooksOfValor = By.linkText("BOOKS OF VALOR");
    private final By ActualBooksStore = By.xpath("/html/body/div[8]/div[2]/h1/a");

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public BooksStoresPage(WebDriver driver) {
        super(driver);
    }
    public BooksStoresPage clickOnStores(){
        LOGGER.debug("User is in the stores Page");
        ActOn.element(driver,StoresLink).click();
        return this;
    }
    public BooksStoresPage typeStoresName(String value){
        LOGGER.debug("Typing store name: ");
        ActOn.element(driver,StoresInputField).setValue(value);
        return this;
    }
    public BooksStoresPage clickOnSearchButton(){
        LOGGER.debug("Clicking on Search Button: ");
        ActOn.element(driver,SearchButton).click();
        return this;
    }
    public BooksStoresPage clickOnBooksOfValor(){
        LOGGER.debug("Clicking on Books of Valor: ");
        ActOn.element(driver,BooksOfValor).click();
        return this;
    }
    public BooksStoresPage validateBooksStore(String expectedBooksStore){
        LOGGER.debug("Validate Store Name is: " +expectedBooksStore);
        String actualBrand = ActOn.element(driver,ActualBooksStore).getTextValue();
        Assert.assertEquals(expectedBooksStore,actualBrand);
        return this;
    }
}
