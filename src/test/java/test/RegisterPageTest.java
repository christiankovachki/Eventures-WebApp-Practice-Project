package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private final String username = "yecexo8611";
    private final String email = "yecexo8611@ridteam.com";
    private final String password = "parola6";
    private final String confirmPassword = "parola6";
    private final String firstName = "Peter";
    private final String lastName = "Petrov";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        driver.manage().window().maximize();
    }

    // Test registration with valid credentials
    @Test(priority = 0)
    public void testRegistrationWithValidCredentials() {
        registerPage.registrationSteps(username, email, password, confirmPassword, firstName, lastName);

        WebElement welcomeMsg = driver.findElement(By.xpath("/html/body/div/main/div/h1"));
        Assert.assertEquals(welcomeMsg.getText(), "Welcome, " + username);
        WebElement eventuresWishesMsg = driver.findElement(By.xpath("/html/body/div/main/div/h4"));
        Assert.assertEquals(eventuresWishesMsg.getText(), "Eventures wishes you an exciting experience.");
    }

    // Test registration with valid fields for Username, Email, Password, Confirm Password and invalid fields for First Name and Last Name
    @Test(priority =  1)
    public void testRegistrationWithInvalidNames() {
        registerPage.registrationSteps(username, email, password, confirmPassword, "P", "P");

        WebElement invalidFirstNameMsg = driver.findElement(By.id("Input_FirstName-error"));
        Assert.assertEquals(invalidFirstNameMsg.getText(), "The First Name field must consist only letters and be at least 2 characters long.");
        WebElement invalidLastNameMsg = driver.findElement(By.id("Input_LastName-error"));
        Assert.assertEquals(invalidLastNameMsg.getText(), "The Last Name field must consist only letters and be at least 2 characters long.");
    }

     // Test registration with valid fields for Username, Email, First Name, Last Name and invalid fields for Password and Confirm Password (less than 6 characters)
    @Test(priority =  2)
    public void testRegistrationWithInvalidPassword() {
        registerPage.registrationSteps(username, email, "pass1", "pass1", firstName, lastName);

        WebElement invalidPasswordMsg = driver.findElement(By.id("Input_Password-error"));
        Assert.assertEquals(invalidPasswordMsg.getText(), "The Password must be at least 6 and at max 20 characters long.");
        WebElement invalidConfirmPasswordMsg = driver.findElement(By.id("Input_ConfirmPassword-error"));
        Assert.assertEquals(invalidConfirmPasswordMsg.getText(), "The Confirm Password must be at least 6 and at max 20 characters long.");
    }

     // Test registration with valid fields for Email, Password, Confirm Password and invalid fields for Username, First Name and Last Name
    @Test(priority = 3)
    public void testRegistrationWithInvalidUsernameAndNames() {
        registerPage.registrationSteps("tesz", email, password, confirmPassword, "1", "11");

        WebElement invalidUsernameMsg = driver.findElement(By.id("Input_Username-error"));
        Assert.assertEquals(invalidUsernameMsg.getText(), "The Username field must consist only letters and digits and must be at least 5 characters long.");
        WebElement invalidFirstNameMsg = driver.findElement(By.id("Input_FirstName-error"));
        Assert.assertEquals(invalidFirstNameMsg.getText(), "The First Name field must consist only letters and be at least 2 characters long.");
        WebElement invalidLastNameMsg = driver.findElement(By.id("Input_LastName-error"));
        Assert.assertEquals(invalidLastNameMsg.getText(), "The Last Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for First Name, Last Name, Password and invalid fields for Username, Email and Confirm Password that doesn't match Password
    @Test(priority = 4)
    public void testRegistrationWithInvalidUsernameAndEmail() {
        registerPage.registrationSteps("!!!!", "email", password, "parola5", firstName, lastName);

        WebElement invalidUsernameMsg = driver.findElement(By.id("Input_Username-error"));
        Assert.assertEquals(invalidUsernameMsg.getText(), "The Username field must consist only letters and digits and must be at least 5 characters long.");
        WebElement invalidEmailMsg = driver.findElement(By.id("Input_Email-error"));
        Assert.assertEquals(invalidEmailMsg.getText(), "The Email field is not a valid e-mail address.");
        WebElement invalidConfirmPasswordMsg = driver.findElement(By.id("Input_ConfirmPassword-error"));
        Assert.assertEquals(invalidConfirmPasswordMsg.getText(), "Passwords do not match.");
    }

//    // Test registration with valid fields for Email, Confirm Password, First Name and invalid fields for Username, Last Name and Password (empty fields)
    @Test(priority = 5)
    public void testRegistrationWithInvalidUsernamePasswordAndName() {
        registerPage.registrationSteps("", email, "", confirmPassword, firstName, "");

        WebElement invalidUsernameMsg = driver.findElement(By.id("Input_Username-error"));
        Assert.assertEquals(invalidUsernameMsg.getText(), "The Username field is required.");
        WebElement invalidPasswordMsg = driver.findElement(By.id("Input_Password-error"));
        Assert.assertEquals(invalidPasswordMsg.getText(), "The Password field is required.");
        WebElement invalidLastNameMsg = driver.findElement(By.id("Input_LastName-error"));
        Assert.assertEquals(invalidLastNameMsg.getText(), "The Last Name field is required.");
    }

//    // Test registration with valid fields for Username, Confirm Password, First Name, Last Name and invalid fields for Email and Password (21 chars, max is 20)
    @Test(priority = 6)
    public void testRegistrationWithInvalidEmailAndPassword() {
        registerPage.registrationSteps(username, "", "212121212121212121212", confirmPassword, firstName, lastName);

        WebElement invalidEmailMsg = driver.findElement(By.id("Input_Email-error"));
        Assert.assertEquals(invalidEmailMsg.getText(), "The Email field is required.");
        WebElement invalidPasswordMsg = driver.findElement(By.id("Input_Password-error"));
        Assert.assertEquals(invalidPasswordMsg.getText(), "The Password must be at least 6 and at max 20 characters long.");
    }

      // Test registration with valid fields for Email, First Name, Last Name and invalid fields for Username, Password and Confirm Password
    @Test(priority = 7)
    public void testRegistrationWithInvalidUsernameAndPasswords() {
        registerPage.registrationSteps("dont", email, "dontmatch", "matchdont", firstName, lastName);

        WebElement invalidUsernameMsg = driver.findElement(By.id("Input_Username-error"));
        Assert.assertEquals(invalidUsernameMsg.getText(), "The Username field must consist only letters and digits and must be at least 5 characters long.");
        WebElement invalidConfirmPasswordMsg = driver.findElement(By.id("Input_ConfirmPassword-error"));
        Assert.assertEquals(invalidConfirmPasswordMsg.getText(), "Passwords do not match.");
    }

      // Test registration with valid fields for First Name, Password and Confirm Password and invalid fields for Username (used), Email and Last Name
    @Test(priority = 8)
    public void testRegistrationWithInvalidUsernameEmailAndName() {
        registerPage.registrationSteps("yaeecexo8611", "text@text", password, confirmPassword, firstName, "1");

        WebElement invalidUsernameMsg = driver.findElement(By.xpath("/html/body/div/main/div/div/form/div[1]/ul/li"));
        Assert.assertEquals(invalidUsernameMsg.getText(), "Username 'yaeecexo8611' is already taken.");
        WebElement invalidEmailMsg = driver.findElement(By.id("Input_Email-error"));
        Assert.assertEquals(invalidEmailMsg.getText(), "The Email field is not a valid e-mail address.");
        WebElement invalidLastNameMsg = driver.findElement(By.id("Input_LastName-error"));
        Assert.assertEquals(invalidLastNameMsg.getText(), "The Last Name field must consist only letters and be at least 2 characters long.");
    }

      // Test registration with valid fields for Email, Password and Last Name and invalid fields for Username, Confirm Password and First Name
    @Test(priority = 9)
    public void testRegistrationWithInvalidUsernameAndFirstName() {
        registerPage.registrationSteps("----", email, password, "", ".", lastName);

        WebElement invalidUsernameMsg = driver.findElement(By.id("Input_Username-error"));
        Assert.assertEquals(invalidUsernameMsg.getText(), "The Username field must consist only letters and digits and must be at least 5 characters long.");
        WebElement invalidConfirmPasswordMsg = driver.findElement(By.id("Input_ConfirmPassword-error"));
        Assert.assertEquals(invalidConfirmPasswordMsg.getText(), "The Confirm Password field is required.");
        WebElement invalidFirstNameMsg = driver.findElement(By.id("Input_FirstName-error"));
        Assert.assertEquals(invalidFirstNameMsg.getText(), "The First Name field must consist only letters and be at least 2 characters long.");
    }

      // Test registration with valid fields for Email, Username, Last Name and Confirm Password and invalid fields for First Name, Password
    @Test(priority = 10)
    public void testRegistrationWithInvalidFirstNameAndPassword() {
        registerPage.registrationSteps(username, email, "?", confirmPassword, "--", lastName);

        WebElement invalidPasswordMsg = driver.findElement(By.id("Input_Password-error"));
        Assert.assertEquals(invalidPasswordMsg.getText(), "The Password must be at least 6 and at max 20 characters long.");
        WebElement invalidFirstNameMsg = driver.findElement(By.id("Input_FirstName-error"));
        Assert.assertEquals(invalidFirstNameMsg.getText(), "The First Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Email, Username, Password, First Name and invalid fields for Confirm Password, Last Name
    @Test(priority = 11)
    public void testRegistrationWithInvalidLastNameAndConfirmPassword() {
        registerPage.registrationSteps(username, email, password, "rndm", firstName, "**");

        WebElement invalidPasswordMsg = driver.findElement(By.id("Input_ConfirmPassword-error"));
        Assert.assertEquals(invalidPasswordMsg.getText(), "The Confirm Password field must be at least 6 and at max 20 characters long.");
        WebElement invalidLastNameMsg = driver.findElement(By.id("Input_LastName-error"));
        Assert.assertEquals(invalidLastNameMsg.getText(), "The Last Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Username, Password, Confirm Password, Last Name and invalid fields for Email (used) and First Name
    @Test(priority = 12)
    public void testRegistrationWithInvalidFirstNameAndEmail() {
        registerPage.registrationSteps(username, "yecexo8611@ridteam.com", password, confirmPassword, "&", lastName);

        WebElement invalidEmailMsg = driver.findElement(By.id("Input_Email-error"));
        Assert.assertEquals(invalidEmailMsg.getText(), "The Email address is already used.");
        WebElement invalidFirstNameMsg = driver.findElement(By.id("Input_FirstName-error"));
        Assert.assertEquals(invalidFirstNameMsg.getText(), "The First Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Username, Email, Confirm Password, First Name and invalid fields for Password and Last Name
    @Test(priority = 13)
    public void testRegistrationWithInvalidLastNameAndPassword() {
        registerPage.registrationSteps(username, email, "rndm", confirmPassword, firstName, ";");

        WebElement invalidPasswordMsg = driver.findElement(By.id("Input_Password-error"));
        Assert.assertEquals(invalidPasswordMsg.getText(), "The Password must be at least 6 and at max 20 characters long.");
        WebElement invalidLastNameMsg = driver.findElement(By.id("Input_LastName-error"));
        Assert.assertEquals(invalidLastNameMsg.getText(), "The Last Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Username, Password, Names and invalid fields for Email and Confirm Password
    @Test(priority = 14)
    public void testRegistrationWithInvalidEmailAndConfirmPassword() {
        registerPage.registrationSteps(username, "text@text", password, "", firstName, lastName);

        WebElement invalidEmailMsg = driver.findElement(By.id("Input_Email-error"));
        Assert.assertEquals(invalidEmailMsg.getText(), "The Email field is not a valid e-mail address.");
        WebElement invalidPasswordMsg = driver.findElement(By.id("Input_ConfirmPassword-error"));
        Assert.assertEquals(invalidPasswordMsg.getText(), "The Confirm Password field is required.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}