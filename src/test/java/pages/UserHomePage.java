package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// The page which the user sees after entering valid credentials
public class UserHomePage {
    private WebDriver driver;
    private By logoutLink = By.xpath("//button[contains(.,'Logout')]");
    private By eventsDropdownMenuLink = By.id("dropdownMenuLink");
    private By allEventsFromDropdown = By.xpath("//a[contains(text(),'All Events')]");
    private By createEventFromDropdown = By.xpath("//a[contains(text(),'Create Event')]");
    private By allEventsFromLink = By.cssSelector(".mt-4:nth-child(4) > a");
    private By createEventFromLink = By.cssSelector(".mt-4:nth-child(5) > a");

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEventsMenu() {
        driver.findElement(eventsDropdownMenuLink).click();
    }

    public void clickAllEventsFromDropdown() {
        driver.findElement(allEventsFromDropdown).click();
    }

    public void clickCreateEventFromDropdown() {
        driver.findElement(createEventFromDropdown).click();
    }

    public void clickAllEventsFromLink() {
        driver.findElement(allEventsFromLink).click();
    }

    public void clickCreateFromLink() {
        driver.findElement(createEventFromLink).click();
    }

    public void clickLogoutLink() {
        driver.findElement(logoutLink).click();
    }
}