package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private final String url = "http://softuni-qa-loadbalancer-2137572849.eu-north-1.elb.amazonaws.com:81/";
    private final String pageTitle = "Home Page - Eventures App";
    private By logInLink = By.xpath("/html/body/div/main/div/h3[1]/a");
    private By registerLink = By.xpath("/html/body/div/main/div/h3[2]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePageUrl() {
        driver.navigate().to(url);
    }

    public void clickLogInLink() {
        driver.findElement(logInLink).click();
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }
}