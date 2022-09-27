package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DailyDealsFeaturedPage extends NavigationBar {

    private final By DailyDealsLink = By.xpath("//*[@id=\"gh-p-1\"]/a[contains(text(),\"Daily Deals\")]");
    private final By ActualFallDeals = By.xpath("//*[@id=\"pssst-first-deals-of-fall-are-here\"]/span");
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public DailyDealsFeaturedPage(WebDriver driver){
        super(driver);
    }

    public DailyDealsFeaturedPage clickOnDailyDeals(){
        LOGGER.debug("Clicking on Daily Deals: " );
        ActOn.element(driver,DailyDealsLink).click();
        return this;
    }
    public DailyDealsFeaturedPage validateFallDeals(String expectedDeals){
        LOGGER.debug("Validate Fall Deals is: "+expectedDeals);
        String actualDeals = ActOn.element(driver,ActualFallDeals).getTextValue();
        Assert.assertEquals(expectedDeals,actualDeals);
        return this;
    }
}
