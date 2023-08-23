package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private HomePage homePage;
    private final String pageTitle = "Log in - Eventures App";
    private By usernameField = By.id("Input_Username");
    private By passwordField = By.id("Input_Password");
    private By loginButton = By.xpath("//*[@id=\"account\"]/div[4]/button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void typeInUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    private void typeInPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean verifySuccessfulLogin() {
        return driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[1]/li[2]/form/button")).isDisplayed();
    }

    public void loginSteps(String username, String password) {
        homePage = new HomePage(driver);
        homePage.navigateToHomePageUrl();
        homePage.clickLogInLink();
        typeInUsernameField(username);
        typeInPasswordField(password);
        clickLoginButton();
    }
}