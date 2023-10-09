package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final String BASE_URL = "http://softuni-qa-loadbalancer-2137572849.eu-north-1.elb.amazonaws.com:81/";
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    protected void clickOnElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    protected void typeInField(WebElement webElement, String input) {
        waitForVisibilityOfElement(webElement);
        webElement.sendKeys(input);
    }

    protected void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}