package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAgreementPolicesPage extends NavigationBar{

    private final By PolicesLink = By.linkText("Policies");
    private final By MemberBehaviourPolices = By.linkText("Member behavior policies");
    private final By UserAgreementPolices = By.linkText("User Agreement");
    private final By PaymentServicesPolices = By.linkText("14. Payment Services");
    private final By ActualPaymentServicesText = By.xpath("//*[@id=\"article_content\"]/div[2]/div[2]/" +
                                                   "div/div/div/h2[14]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public UserAgreementPolicesPage(WebDriver driver){super(driver);}

    public UserAgreementPolicesPage clickOnPolices(){
        LOGGER.debug("Clicking on Polices Link ");
        ActOn.element(driver,PolicesLink).click();
        return this;
    }
    public UserAgreementPolicesPage clickOnMemberBehaviourPolices(){
        LOGGER.debug("Clicking on Member behavior policies Link ");
        ActOn.element(driver,MemberBehaviourPolices).click();
        return this;
    }
    public UserAgreementPolicesPage clickOnUserAgreement(){
        LOGGER.debug("Clicking on User Agreement Link ");
        ActOn.element(driver,UserAgreementPolices).click();
        return this;
    }
    public UserAgreementPolicesPage clickOnPaymentServices(){
        LOGGER.debug("Clicking on Payment Services Link ");
        ActOn.element(driver,PaymentServicesPolices).click();
        return this;
    }
    public UserAgreementPolicesPage validatePaymentServicesPolices(String expectedPaymentServicesText){
        LOGGER.debug("Validate Payment Services Polices: " +expectedPaymentServicesText);
        String actualPaymentServicesText = ActOn.element(driver,ActualPaymentServicesText).getTextValue();
        Assert.assertEquals(expectedPaymentServicesText,actualPaymentServicesText);
        return this;
    }
}
