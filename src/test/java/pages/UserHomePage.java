package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// The page which the user sees after entering valid credentials
public class UserHomePage {
    private WebDriver driver;
    private final String welcomeMessage = "Eventures wishes you an exciting experience.";
    private By logoutLink = By.xpath("/html/body/header/nav/div/div/ul[1]/li[2]/form/button");
    private By eventsDropdownMenuLink = By.id("dropdownMenuLink");

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEventsMenu() {
        driver.findElement(eventsDropdownMenuLink).click();
    }

    public void clickAllEventsFromDropdown() {
        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[2]/li[2]/div/div/a[1]")).click();
    }

    public void clickCreateEventFromDropdown() {
        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[2]/li[2]/div/div/a[2]")).click();
    }

    public void clickAllEventsFromLink() {
        driver.findElement(By.xpath("/html/body/div/main/div/h3[1]/a")).click();
    }

    public void clickCreateFromLink() {
        driver.findElement(By.xpath("/html/body/div/main/div/h3[2]/a")).click();
    }

    public boolean isTotalEventsMessageDisplayed() {
        return driver.findElement(By.xpath("/html/body/div/main/div/h5[1]/text()[1]")).isDisplayed();
    }

    public void clickLogoutLink() {
        driver.findElement(logoutLink).click();
    }
}