package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    @FindBy(id = "Input_Username")
    private WebElement usernameField;
    @FindBy(id = "Input_Email")
    private WebElement emailField;
    @FindBy(id = "Input_Password")
    private WebElement passwordField;
    @FindBy(id = "Input_ConfirmPassword")
    private WebElement confirmPasswordField;
    @FindBy(id = "Input_FirstName")
    private WebElement firstNameField;
    @FindBy(id = "Input_LastName")
    private WebElement lastNameField;
    @FindBy(css = "button.btn")
    private WebElement registerButton;
    @FindBy(id = "Input_FirstName-error")
    private WebElement invalidFirstNameMessage;
    @FindBy(id = "Input_LastName-error")
    private WebElement invalidLastNameMessage;
    @FindBy(id = "Input_Password-error")
    private WebElement invalidPasswordMessage;
    @FindBy(id = "Input_ConfirmPassword-error")
    private WebElement invalidConfirmPasswordMessage;
    @FindBy(id = "Input_Username-error")
    private WebElement invalidUsernameMessage;
    @FindBy(id = "Input_Email-error")
    private WebElement invalidEmailMessage;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getInvalidFirstNameMessage() {
        return invalidFirstNameMessage.getText();
    }

    public String getInvalidLastNameMessage() {
        return invalidLastNameMessage.getText();
    }

    public String getInvalidPasswordMessage() {
        return invalidPasswordMessage.getText();
    }

    public String getInvalidConfirmPasswordMessage() {
        return invalidConfirmPasswordMessage.getText();
    }

    public String getInvalidUsernameMessage() {
        return invalidUsernameMessage.getText();
    }

    public String getInvalidEmailMessage() {
        return invalidEmailMessage.getText();
    }

    public UserHomePage registrationSteps(String username, String email, String password, String confirmPassword,
                                  String firstName, String lastName) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePageUrl();
        homePage.clickRegisterLink();
        typeInField(usernameField, username);
        typeInField(emailField, email);
        typeInField(passwordField, password);
        typeInField(confirmPasswordField, confirmPassword);
        typeInField(firstNameField, firstName);
        typeInField(lastNameField, lastName);
        clickOnElement(registerButton);
        return new UserHomePage(driver);
    }
}