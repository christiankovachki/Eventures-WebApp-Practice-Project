package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "Input_Username")
    private WebElement usernameField;
    @FindBy(id = "Input_Password")
    private WebElement passwordField;
    @FindBy(css = "button.btn")
    private WebElement logInButton;
    @FindBy(id = "Input_Username-error")
    private WebElement requiredUsernameMessage;
    @FindBy(id = "Input_Password-error")
    private WebElement requiredPasswordMessage;
    @FindBy(css = ".text-danger li")
    private WebElement invalidAttemptMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getInvalidAttemptMessage() {
        return invalidAttemptMessage.getText();
    }

    public String getRequiredUsernameMessage() {
        return requiredUsernameMessage.getText();
    }

    public String getRequiredPasswordMessage() {
        return requiredPasswordMessage.getText();
    }

    public UserHomePage loginSteps(String username, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePageUrl();
        homePage.clickLogInLink();
        typeInField(usernameField, username);
        typeInField(passwordField, password);
        clickOnElement(logInButton);
        return new UserHomePage(driver);
    }
}