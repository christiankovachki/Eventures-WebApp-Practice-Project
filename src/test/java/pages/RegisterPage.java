package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private HomePage homePage;
    private final String pageTitle = "Register - Eventures App";
    private By usernameField = By.id("Input_Username");
    private By emailField = By.id("Input_Email");
    private By passwordField = By.id("Input_Password");
    private By confirmPasswordField = By.id("Input_ConfirmPassword");
    private By firstNameField = By.id("Input_FirstName");
    private By lastNameField = By.id("Input_LastName");
    private By registerButton = By.xpath("/html/body/div/main/div/div/form/button");

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

    public String getPageTitle() {
        return pageTitle;
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