package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private final String validUsername = "guest";
    private final String invalidUsername = "tseug";
    private final String validPassword = "guest";
    private final String invalidPassword = "tseug";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testLoginWithValidCredentials() {
        loginPage.loginSteps(validUsername, validPassword);

        Assert.assertTrue(loginPage.verifySuccessfulLogin());
        Assert.assertEquals(loginPage.getWelcomeMessage(), "Welcome, " + validUsername);
    }

    // Test with valid username and invalid password
    @Test(priority = 1)
    public void testLoginWithInvalidPassword() {
        loginPage.loginSteps(validUsername, invalidPassword);

        Assert.assertEquals(loginPage.getInvalidAttemptMessage(), "Invalid login attempt.");
    }

    // Test with invalid username and valid password
    @Test(priority = 2)
    public void testLoginWithInvalidUsername() {
        loginPage.loginSteps(invalidUsername, validPassword);

        Assert.assertEquals(loginPage.getInvalidAttemptMessage(), "Invalid login attempt.");
    }

    // Test with invalid credentials, e.g empty username and password fields
    @Test(priority = 3)
    public void testLoginWithInvalidCredentials() {
        loginPage.loginSteps("", "");

        Assert.assertEquals(loginPage.getRequiredUsernameMessage(), "The Username field is required.");
        Assert.assertEquals(loginPage.getRequiredPasswordMessage(), "The Password field is required.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}