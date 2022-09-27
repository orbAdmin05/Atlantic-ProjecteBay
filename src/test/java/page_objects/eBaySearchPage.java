package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class eBaySearchPage extends NavigationBar {
    private final By SearchItemInputField = By.id("gh-ac");
    private final By CategoryDropDown = By.id("gh-cat");
    private final By SearchButton = By.id("gh-btn");
    private final By MinimumPriceInputField = By.id("s0-51-12-0-1-2-6-0-6[2]-0-textrange-beginParamValue-textbox");
    private final By PriceArrow = By.xpath("//*[@id='s0-51-12-0-1-2-6-0-6[2]-0-textrange']/div/div[3]/button");
    private final By AppleIphone14 = By.xpath("//*[@id='srp-river-results']/ul/li[2]/div/div[2]/a/div/span");
    private final By AddToCartButton = By.xpath("//div/div/div/div[2]/div[2]/div/span/a[@id='isCartBtn_btn']");
    private final By GoToCheckOutButton = By.xpath("//*[@id='mainContent']/div/div[4]/div/div[1]/button");
    private final By ContinueAsGuestButton = By.xpath("//*[@id=\"gxo-btn\"]");
    private final By FirstNaneInputField = By.id("firstName");
    private final By LastNameInputField = By.id("lastName");
    private final By StreetAddressInputField = By.id("addressLine1");
    private final By CityInputField = By.id("city");
    private final By StateDropDown = By.id("stateOrProvince");
    private final By ZipCodeInputField = By.id("postalCode");
    private final By EmailInputField = By.id("email");
    private final By ConfirmEmailInputField = By.id("emailConfirm");
    private final By PhoneNumberInputField = By.id("phoneNumber");
    private final By DoneButton = By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div[1]/section[2]/div[3]/div/" +
            "div/div/div[2]/div[1]/form/div/div/div[1]/button");
    private final By AddNewCardRadioButton = By.xpath("//*[@id=\"mainContent\"]//input[@name=\"radio-group-paymentMethod\"][@value=\"CC\"");
    private final By CardNumberInputField = By.id("cardNumber");
    private final By ExpirationDateInputField = By.id("cardExpiryDate");
    private final By SecurityCodeInputField = By.id("securityCode");
    private final By DoneButtonForCreditCard = By.xpath("//*[@id=\"mainContent\"]//button[@type=\"submit\"]" +
            "[@data-test-id=\"ADD_CARD\"]");
    private final By ActualInvalidCardErrorMessage = By.id("cardNumber-error");
    private final By ActualCheckOutPageText = By.xpath("//*[@id=\"root\"]/div/h1");
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public eBaySearchPage(WebDriver driver){
        super(driver);
    }

    public eBaySearchPage typeSearchItem(String value){
        LOGGER.debug("Typing Search Item : " +value);
        ActOn.element(driver,SearchItemInputField).setValue(value);
        return this;
    }
    public eBaySearchPage selectCategories(String category){
        LOGGER.debug("Select the Categories : " + category);
        ActOn.element(driver,CategoryDropDown).selectValue(category);
        return this;
    }
    public eBaySearchPage clickOnSearchButton(){
        LOGGER.debug("Display the Search Item : ");
        ActOn.element(driver,SearchButton).click();
        return this;
    }
    public eBaySearchPage setPriceRange(String value){
        LOGGER.debug("Typing Minimum Price : " + value);
        ActOn.element(driver,MinimumPriceInputField).setValue(value);
        return this;
    }
    public eBaySearchPage clickOnPriceArrow(){
        LOGGER.debug("Set Minimum Price : ");
        ActOn.element(driver,PriceArrow).click();
        return this;
    }
    public eBaySearchPage clickOniPhone14(){
        LOGGER.debug("Selected iPhone 14 : ");
        ActOn.element(driver,AppleIphone14).click();
        return this;
    }
    public eBaySearchPage clickOnAddToCart(){
        Set<String> childWindowHandles = driver.getWindowHandles();
        for (String handle : childWindowHandles) {
            driver.switchTo().window(handle); // move to new tab
        }
        LOGGER.debug("iPhone 14 Added to the Cart : ");
        ActOn.element(driver,AddToCartButton).click();
        return this;
    }
    public eBaySearchPage clickOnGoToCheckOut() throws InterruptedException {
        Thread.sleep(3000);
        LOGGER.debug("Clicking on CheckOut Button ");
        ActOn.element(driver,GoToCheckOutButton).click();
        return this;
    }
    public eBaySearchPage clickOnLightBox() throws InterruptedException {
        LOGGER.debug("Clicking on Continue as Guest Button");
        Thread.sleep(3000);
        ActOn.element(driver,ContinueAsGuestButton).click();
        return this;
    }
    public eBaySearchPage enterFirstName(String value){
        LOGGER.debug("User Enter First Name: " +value);
        ActOn.element(driver,FirstNaneInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterLastName(String value){
        LOGGER.debug("User Enter Last Name: " +value);
        ActOn.element(driver,LastNameInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterStreetAddress(String value){
        LOGGER.debug("User Enter StreetAddress: " +value);
        ActOn.element(driver,StreetAddressInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterCityName(String value){
        LOGGER.debug("User Enter City Name: " +value);
        ActOn.element(driver,CityInputField).setValue(value);
        return this;
    }
    public eBaySearchPage selectStateName(String value){
        LOGGER.debug("User Select State Name: " +value);
        ActOn.element(driver,StateDropDown).selectValue(value);
        return this;
    }
    public eBaySearchPage enterZipCode(String value){
        LOGGER.debug("User Enter Zip Code: " +value);
        ActOn.element(driver,ZipCodeInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterEmailId(String value){
        LOGGER.debug("User Enter Email Id: " +value);
        ActOn.element(driver,EmailInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterConfirmEmailId(String value){
        LOGGER.debug("User Enter Confirm Email Id: " +value);
        ActOn.element(driver,ConfirmEmailInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterPhoneNumber(String value){
        LOGGER.debug("User Enter Phone Number: " +value);
        ActOn.element(driver,PhoneNumberInputField).setValue(value);
        return this;
    }
    public eBaySearchPage clickOnDoneButton(){
        LOGGER.debug("User Click on Done Button: ");
        ActOn.element(driver,DoneButton).click();
        return this;
    }
    public eBaySearchPage clickOnAddNewCardRadioButton() throws InterruptedException {
        LOGGER.debug("User Click on Add new card radio Button: ");
        Thread.sleep(3000);
        ActOn.element(driver,AddNewCardRadioButton).click();
        return this;
    }
    public eBaySearchPage enterCardNumber(String value){
        LOGGER.debug("User Enter Card Number: " +value);
        ActOn.element(driver,CardNumberInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterExpirationDate(String value){
        LOGGER.debug("User Enter Expiration Date: " +value);
        ActOn.element(driver,ExpirationDateInputField).setValue(value);
        return this;
    }
    public eBaySearchPage enterSecurityCode(String value){
        LOGGER.debug("User Enter Security Code: " +value);
        ActOn.element(driver,SecurityCodeInputField).setValue(value);
        return this;
    }
    public eBaySearchPage clickOnDoneButtonForAddNewCard() throws InterruptedException {
        Thread.sleep(5000);
        LOGGER.debug("User Click on Done Button: ");
        ActOn.element(driver,DoneButtonForCreditCard).click();
        return this;
    }
    public eBaySearchPage validateCreditCardNumber(String expectedErrorMessage) throws InterruptedException {
        Thread.sleep(3000);
        LOGGER.debug("Validate Invalid Credit Card Error Message:");
        String actualErrorMessage = ActOn.element(driver,ActualInvalidCardErrorMessage).getTextValue();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
        return this;
    }
    public eBaySearchPage validateCheckOut(String expectedCheckOutPageText){
        LOGGER.debug("Validate to reach at Check Out Page : " +expectedCheckOutPageText);
        String actualCheckOutPageText = ActOn.element(driver,ActualCheckOutPageText).getTextValue();
        Assert.assertEquals(expectedCheckOutPageText,actualCheckOutPageText);
        return this;
    }
}
