package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// The page which the user sees after entering valid credentials
public class UserHomePage extends BasePage {
    @FindBy(css = "button.btn")
    private WebElement logoutLink;
    @FindBy(id = "dropdownMenuLink")
    private WebElement eventsDropdownMenuLink;
    @FindBy(css = ".dropdown-item[href='/Events/All']")
    private WebElement allEventsFromDropdown;
    @FindBy(xpath = "//a[contains(text(),'Create Event')]")
    private WebElement createEventFromDropdown;
    @FindBy(css = ".mt-4 [href='/Events/All']")
    private WebElement allEventsFromLink;
    @FindBy(css = ".mt-4 [href='/Events/Create']")
    private WebElement createEventFromLink;
    @FindBy(css = "h1.text-center")
    private WebElement welcomeMessage;

    public UserHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickEventsMenu() {
        clickOnElement(eventsDropdownMenuLink);
    }

    public void clickAllEventsFromDropdown() {
        clickOnElement(allEventsFromDropdown);
    }

    public void clickCreateEventFromDropdown() {
        clickOnElement(createEventFromDropdown);
    }

    public void clickAllEventsFromLink() {
        clickOnElement(allEventsFromLink);
    }

    public void clickCreateFromLink() {
        clickOnElement(createEventFromLink);
    }

    public void clickLogoutLink() {
        clickOnElement(logoutLink);
    }

    public String getWelcomeMessage() {
        waitForVisibilityOfElement(welcomeMessage);
        return welcomeMessage.getText();
    }

    public boolean verifySuccessfulLogin() {
        waitForVisibilityOfElement(logoutLink);
        return logoutLink.isDisplayed();
    }
}