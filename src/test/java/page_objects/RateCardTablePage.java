package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RateCardTablePage extends NavigationBar{

    private final By AffiliatesLink = By.linkText("Affiliates");
    private final By RateCardLink = By.linkText("Rate Card");
    private final By ActualRateCard = By.xpath("//*[@class=\"wysiwyg\"][text()=\"Rate card as of August 24 2020:\"]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public RateCardTablePage(WebDriver driver) {
        super(driver);
    }
    public RateCardTablePage clickOnAffiliates(){
        LOGGER.debug("User is in the eBay Partner Network Page");
        ActOn.element(driver,AffiliatesLink).click();
        return this;
    }
    public RateCardTablePage clickOnRateCard(){
        LOGGER.debug("Clicking On Rate Card Link");
        ActOn.element(driver,RateCardLink).click();
        return this;
    }
    public RateCardTablePage validateRateCard(String expectedRateCard){
        LOGGER.debug("Validate Rate Card : " +expectedRateCard);
        String acutalRateCard = ActOn.element(driver,ActualRateCard).getTextValue();
        Assert.assertEquals(expectedRateCard,acutalRateCard);
        return this;
    }


}
