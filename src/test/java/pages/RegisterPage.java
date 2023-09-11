package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private HomePage homePage;
    private By usernameField = By.id("Input_Username");
    private By emailField = By.id("Input_Email");
    private By passwordField = By.id("Input_Password");
    private By confirmPasswordField = By.id("Input_ConfirmPassword");
    private By firstNameField = By.id("Input_FirstName");
    private By lastNameField = By.id("Input_LastName");
    private By registerButton = By.xpath("//button[contains(.,'Register')]");
    private By invalidFirstNameMessage = By.id("Input_FirstName-error");
    private By invalidLastNameMessage = By.id("Input_LastName-error");
    private By invalidPasswordMessage = By.id("Input_Password-error");
    private By invalidConfirmPasswordMessage = By.id("Input_ConfirmPassword-error");
    private By invalidUsernameMessage = By.id("Input_Username-error");
    private By invalidEmailMessage = By.id("Input_Email-error");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private void typeInUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    private void typeInEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    private void typeInPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void typeInConfirmPasswordField(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    private void typeInFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    private void typeInLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    private void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getInvalidFirstNameMessage() {
        return driver.findElement(invalidFirstNameMessage).getText();
    }

    public String getInvalidLastNameMessage() {
        return driver.findElement(invalidLastNameMessage).getText();
    }

    public String getInvalidPasswordMessage() {
        return driver.findElement(invalidPasswordMessage).getText();
    }

    public String getInvalidConfirmPasswordMessage() {
        return driver.findElement(invalidConfirmPasswordMessage).getText();
    }

    public String getInvalidUsernameMessage() {
        return driver.findElement(invalidUsernameMessage).getText();
    }

    public String getInvalidEmailMessage() {
        return driver.findElement(invalidEmailMessage).getText();
    }

    public void registrationSteps(String username, String email, String password, String confirmPassword,
                                  String firstName, String lastName) {
        homePage = new HomePage(driver);
        homePage.navigateToHomePageUrl();
        homePage.clickRegisterLink();
        typeInUsernameField(username);
        typeInEmailField(email);
        typeInPasswordField(password);
        typeInConfirmPasswordField(confirmPassword);
        typeInFirstNameField(firstName);
        typeInLastNameField(lastName);
        clickRegisterButton();
    }
}