package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsFilteringPage extends NavigationBar {

    private final By SearchItemInputField = By.id("gh-ac");
    private final By SearchButton = By.id("gh-btn");
    private final By RamSize = By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[2]/div/a/div/span/input[@aria-label=\"16 GB\"]");
    private final By ScreenSize = By.xpath("//*[@id=\"x-refine__group_1__1\"]/ul/li[5]/div/a/div/span/" +
                                   "input[@aria-label=\"16-16.9 in\"]");
    private final By OperatingSystem = By.xpath("//*[@id=\"x-refine__group_1__2\"]/ul/li[6]/div/a/div/span/" +
                                        "input[@aria-label=\"Windows 11 Home\"]");
    private final By Processor = By.xpath("//*[@id=\"x-refine__group_1__4\"]/ul/li[7]/div/a/div/span/input");
    private final By BrandName = By.xpath("//*[@id=\"x-refine__group_1__4\"]/ul/li[3]/div/a/div/span/input");
    private final By ProductCondition = By.xpath("//*[@id=\"x-refine__group__2\"]/ul/li[1]/div/a/div/span/input");
    private final By MinimumPriceRange = By.xpath("//*[@id=\"s0-51-12-0-1-2-6-0-6[3]-0-" +
                                             "textrange-beginParamValue-textbox\"]");
    private final By PriceArrow = By.xpath("//*[@id=\"s0-51-12-0-1-2-6-0-6[3]-0-" +
                                   "textrange\"]/div/div[3]/button");
    private final By SearchResult = By.xpath("//*[@id=\"mainContent\"]/div[1]/div[2]/div[2]/div[1]/div[1]/h1");
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public ProductsFilteringPage(WebDriver driver){super(driver);}

    public ProductsFilteringPage typeItemName(String value){
        LOGGER.debug("Typing Product Name: ");
        ActOn.element(driver,SearchItemInputField).setValue(value);
        return this;
    }
    public ProductsFilteringPage clickOnSearchButton(){
        LOGGER.debug("Clicking on Search Button: ");
        ActOn.element(driver,SearchButton).click();
        return this;
    }
    public ProductsFilteringPage clickOnRamSize(){
        LOGGER.debug("Clicking on RAM Size: ");
        ActOn.element(driver,RamSize).click();
        return this;
    }
    public ProductsFilteringPage clickOnScreenSize(){
        LOGGER.debug("Clicking on Screen Size: ");
        ActOn.element(driver,ScreenSize).click();
        return this;
    }
    public ProductsFilteringPage clickOnOperatingSystem(){
        LOGGER.debug("Clicking on Operating System: ");
        ActOn.element(driver,OperatingSystem).click();
        return this;
    }
    public ProductsFilteringPage clickOnProcessor(){
        LOGGER.debug("Clicking on Processor: ");
        ActOn.element(driver,Processor).click();
        return this;
    }
    public ProductsFilteringPage clickOnBrand(){
        LOGGER.debug("Clicking on Product Brand: ");
        ActOn.element(driver,BrandName).click();
        return this;
    }
    public ProductsFilteringPage clickOnCondition(){
        LOGGER.debug("Clicking on Product Condition: ");
        ActOn.element(driver,ProductCondition).click();
        return this;
    }
    public ProductsFilteringPage clickOnMinPrice(String value){
        LOGGER.debug("Typing Minimum Price : ");
        ActOn.element(driver,MinimumPriceRange).setValue(value);
        return this;
    }
    public ProductsFilteringPage clickOnPriceArrow(){
        LOGGER.debug("Clicking on Price Arrow Sign: ");
        ActOn.element(driver,PriceArrow).click();
        return this;
    }
    public ProductsFilteringPage captureFilteredResult(){
        String str =ActOn.element(driver,SearchResult).getTextValue();
        LOGGER.debug("Filter Result is : " +str);
        return this;
    }

}
