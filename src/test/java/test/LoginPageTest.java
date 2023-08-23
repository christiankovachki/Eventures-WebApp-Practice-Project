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
    WebDriver driver;
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

        WebElement welcomeMsg = driver.findElement(By.xpath("/html/body/div/main/div/h1"));
        Assert.assertTrue(loginPage.verifySuccessfulLogin());
        Assert.assertEquals(welcomeMsg.getText(), "Welcome, " + validUsername);
    }

    // Test with valid username and invalid password
    @Test(priority = 1)
    public void testLoginWithInvalidPassword() {
        loginPage.loginSteps(validUsername, invalidPassword);

        String invalidAttemptMsg = driver.findElement(By.xpath("//*[@id=\"account\"]/div[1]")).getText();
        Assert.assertEquals(invalidAttemptMsg, "Invalid login attempt.");
    }

    // Test with invalid username and valid password
    @Test(priority = 2)
    public void testLoginWithInvalidUsername() {
        loginPage.loginSteps(invalidUsername, validPassword);

        String invalidAttemptMsg = driver.findElement(By.xpath("//*[@id=\"account\"]/div[1]")).getText();
        Assert.assertEquals(invalidAttemptMsg, "Invalid login attempt.");
    }

    // Test with invalid credentials, e.g empty username and password fields
    @Test(priority = 3)
    public void testLoginWithInvalidCredentials() {
        loginPage.loginSteps("", "");

        String requiredUsernameMsg = driver.findElement(By.id("Input_Username-error")).getText();
        String requiredPasswordMsg = driver.findElement(By.id("Input_Password-error")).getText();
        Assert.assertEquals(requiredUsernameMsg, "The Username field is required.");
        Assert.assertEquals(requiredPasswordMsg, "The Password field is required.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}