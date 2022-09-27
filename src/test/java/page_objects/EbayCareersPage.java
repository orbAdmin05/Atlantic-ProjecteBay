package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayCareersPage extends NavigationBar{

    private final By CareersLink = By.linkText("Careers");
    private final By JobTitle = By.id("career-search-keyword");
    private final By SearchButton = By.xpath("//*[@id=\"job-search-form\"]/div/form/div/button");
    private final By SenioriosEngineerLink = By.xpath("//*[@id=\"search-results-list\"]/ul/li[1]/a/h2");
    private final By ActualJobTitleText = By.xpath("//*[@id=\"main-content\"]/div[1]/section/div[1]/h1");
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public EbayCareersPage(WebDriver driver){super(driver);}

    public EbayCareersPage clickOnCareers(){
        LOGGER.debug("User is in the stores Page");
        ActOn.element(driver,CareersLink).click();
        return this;
    }
    public EbayCareersPage typeJobTittle(String value) throws InterruptedException {
        LOGGER.debug("Typing Job Tittle: ");
        Thread.sleep(3000);
        ActOn.element(driver,JobTitle).setValue(value);
        return this;
    }
    public EbayCareersPage clickOnJobSearchButton() throws InterruptedException {
        LOGGER.debug("Clicking on Search Button ");
        Thread.sleep(3000);
        ActOn.element(driver,SearchButton).click();
        return this;
    }
    public EbayCareersPage clickOnSoftwareEngineer() throws InterruptedException {
        LOGGER.debug("Clicking on Senior ios Engineer: ");
        Thread.sleep(3000);
        ActOn.element(driver,SenioriosEngineerLink).click();
        return this;
    }
    public EbayCareersPage validateJobTitle(String expectedJobTitleText){
        LOGGER.debug("Validate Job Title is: " +expectedJobTitleText);
        String actualJobTitleText = ActOn.element(driver,ActualJobTitleText).getTextValue();
        Assert.assertEquals(expectedJobTitleText,actualJobTitleText);
        return this;
    }
}
