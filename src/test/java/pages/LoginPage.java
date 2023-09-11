package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("Input_Username");
    private By passwordField = By.id("Input_Password");
    private By loginButton = By.cssSelector(".btn");

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
        return driver.findElement(By.xpath("//button[contains(.,'Logout')]")).isDisplayed();
    }

    public String getInvalidAttemptMessage() {
        return driver.findElement(By.cssSelector(".text-danger li")).getText();
    }

    public String getRequiredUsernameMessage() {
        return driver.findElement(By.id("Input_Username-error")).getText();
    }

    public String getRequiredPasswordMessage() {
        return driver.findElement(By.id("Input_Password-error")).getText();
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.cssSelector(".text-center:nth-child(1)")).getText();
    }

    public void loginSteps(String username, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePageUrl();
        homePage.clickLogInLink();
        typeInUsernameField(username);
        typeInPasswordField(password);
        clickLoginButton();
    }
}