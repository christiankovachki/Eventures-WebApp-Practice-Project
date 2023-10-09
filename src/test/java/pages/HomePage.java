package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css = ".mt-4 [href='/Identity/Account/Login']")
    private WebElement logInLink;
    @FindBy(css = ".mt-4 [href='/Identity/Account/Register']")
    private WebElement registerLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePageUrl() {
        driver.navigate().to(BASE_URL);
    }

    public LoginPage clickLogInLink() {
        clickOnElement(logInLink);
        return new LoginPage(driver);
    }

    public RegisterPage clickRegisterLink() {
        clickOnElement(registerLink);
        return new RegisterPage(driver);
    }
}