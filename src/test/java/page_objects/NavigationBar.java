package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By DailyDealsFeatured= By.linkText("Featured");
    private final By FallDeals = By.linkText("Pssst! First Deals of Fall are Here");
    private final By StoresLinkSection = By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]");
    private final By EbaySiteOfUnitedStates = By.linkText("United States");
    private final By SolutionsLink = By.linkText("Solutions");

    public WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }

    public NavigationBar mouseHoverToFeatured(){
        LOGGER.debug("Mouse Hover to the Featured Link");
        ActOn.element(driver,DailyDealsFeatured).mouseHover();
        return this;
    }
    public DailyDealsFeaturedPage navigateToFallDeals(){
        LOGGER.debug("Clicking on the Fall Products Link");
        ActOn.element(driver,FallDeals).click();
        return new DailyDealsFeaturedPage(driver);
    }
    public BooksStoresPage mouseHoverToStores(){
        LOGGER.debug("Mouse Hover to the Stores");
        ActOn.element(driver,StoresLinkSection).mouseHover();
        return new BooksStoresPage(driver);
    }
    public UnitedKingdomDomainPage mouseHoverToeBaySite() {
        LOGGER.debug("Mouse Hover over United States");
        ActOn.element(driver,EbaySiteOfUnitedStates).mouseHover();
        return new UnitedKingdomDomainPage(driver);
    }

    public RateCardTablePage mouseHoverToSolutions(){
        LOGGER.debug("Mouse Hover to the Solutions");
        ActOn.element(driver,SolutionsLink).mouseHover();
        return new RateCardTablePage(driver);
    }

}
