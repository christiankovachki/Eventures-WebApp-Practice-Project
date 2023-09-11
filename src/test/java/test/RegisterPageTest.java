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
        registerPage = new RegisterPage(driver);
        driver.manage().window().maximize();
    }

    // Test registration with valid credentials
    @Test(priority = 0)
    public void testRegistrationWithValidCredentials() {
        registerPage.registrationSteps(username, email, password, confirmPassword, firstName, lastName);

        WebElement welcomeMsg = driver.findElement(By.cssSelector(".text-center:nth-child(1)"));
        Assert.assertEquals(welcomeMsg.getText(), "Welcome, " + username);
        WebElement eventuresWishesMsg = driver.findElement(By.cssSelector(".text-secondary"));
        Assert.assertEquals(eventuresWishesMsg.getText(), "Eventures wishes you an exciting experience.");
    }

    // Test registration with valid fields for Username, Email, Password, Confirm Password and invalid fields for First Name and Last Name
    @Test(priority =  1)
    public void testRegistrationWithInvalidNames() {
        registerPage.registrationSteps(username, email, password, confirmPassword, "P", "P");

        Assert.assertEquals(registerPage.getInvalidFirstNameMessage(),
                "The First Name field must consist only letters and be at least 2 characters long.");
        Assert.assertEquals(registerPage.getInvalidLastNameMessage(),
                "The Last Name field must consist only letters and be at least 2 characters long.");
    }

     // Test registration with valid fields for Username, Email, First Name, Last Name and invalid fields for Password and Confirm Password (less than 6 characters)
    @Test(priority =  2)
    public void testRegistrationWithInvalidPassword() {
        registerPage.registrationSteps(username, email, "pass1", "pass1", firstName, lastName);

        Assert.assertEquals(registerPage.getInvalidPasswordMessage(),
                "The Password must be at least 6 and at max 20 characters long.");
        Assert.assertEquals(registerPage.getInvalidConfirmPasswordMessage(),
                "The Confirm Password must be at least 6 and at max 20 characters long.");
    }

     // Test registration with valid fields for Email, Password, Confirm Password and invalid fields for Username, First Name and Last Name
    @Test(priority = 3)
    public void testRegistrationWithInvalidUsernameAndNames() {
        registerPage.registrationSteps("tesz", email, password, confirmPassword, "1", "11");

        Assert.assertEquals(registerPage.getInvalidUsernameMessage(),
                "The Username field must consist only letters and digits and must be at least 5 characters long.");
        Assert.assertEquals(registerPage.getInvalidFirstNameMessage(),
                "The First Name field must consist only letters and be at least 2 characters long.");
        Assert.assertEquals(registerPage.getInvalidLastNameMessage(),
                "The Last Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for First Name, Last Name, Password and invalid fields for Username, Email and Confirm Password that doesn't match Password
    @Test(priority = 4)
    public void testRegistrationWithInvalidUsernameAndEmail() {
        registerPage.registrationSteps("!!!!", "email", password, "parola5", firstName, lastName);

        Assert.assertEquals(registerPage.getInvalidUsernameMessage(),
                "The Username field must consist only letters and digits and must be at least 5 characters long.");
        Assert.assertEquals(registerPage.getInvalidEmailMessage(),
                "The Email field is not a valid e-mail address.");
        Assert.assertEquals(registerPage.getInvalidConfirmPasswordMessage(),
                "Passwords do not match.");
    }

//    // Test registration with valid fields for Email, Confirm Password, First Name and invalid fields for Username, Last Name and Password (empty fields)
    @Test(priority = 5)
    public void testRegistrationWithInvalidUsernamePasswordAndName() {
        registerPage.registrationSteps("", email, "", confirmPassword, firstName, "");

        Assert.assertEquals(registerPage.getInvalidUsernameMessage(), "The Username field is required.");
        Assert.assertEquals(registerPage.getInvalidPasswordMessage(), "The Password field is required.");
        Assert.assertEquals(registerPage.getInvalidLastNameMessage(), "The Last Name field is required.");
    }

//    // Test registration with valid fields for Username, Confirm Password, First Name, Last Name and invalid fields for Email and Password (21 chars, max is 20)
    @Test(priority = 6)
    public void testRegistrationWithInvalidEmailAndPassword() {
        registerPage.registrationSteps(username, "", "212121212121212121212", confirmPassword, firstName, lastName);

        Assert.assertEquals(registerPage.getInvalidEmailMessage(), "The Email field is required.");
        Assert.assertEquals(registerPage.getInvalidPasswordMessage(), "The Password must be at least 6 and at max 20 characters long.");
    }

      // Test registration with valid fields for Email, First Name, Last Name and invalid fields for Username, Password and Confirm Password
    @Test(priority = 7)
    public void testRegistrationWithInvalidUsernameAndPasswords() {
        registerPage.registrationSteps("dont", email, "dontmatch", "matchdont", firstName, lastName);

        Assert.assertEquals(registerPage.getInvalidUsernameMessage(),
                "The Username field must consist only letters and digits and must be at least 5 characters long.");
        Assert.assertEquals(registerPage.getInvalidConfirmPasswordMessage(), "Passwords do not match.");
    }

      // Test registration with valid fields for First Name, Password and Confirm Password and invalid fields for Username (used), Email and Last Name
    @Test(priority = 8)
    public void testRegistrationWithInvalidUsernameEmailAndName() {
        registerPage.registrationSteps("yaeecexo8611", "text@text", password, confirmPassword, firstName, "1");

        Assert.assertEquals(registerPage.getInvalidUsernameMessage(), "Username 'yaeecexo8611' is already taken.");
        Assert.assertEquals(registerPage.getInvalidEmailMessage(), "The Email field is not a valid e-mail address.");
        Assert.assertEquals(registerPage.getInvalidLastNameMessage(),
                "The Last Name field must consist only letters and be at least 2 characters long.");
    }

      // Test registration with valid fields for Email, Password and Last Name and invalid fields for Username, Confirm Password and First Name
    @Test(priority = 9)
    public void testRegistrationWithInvalidUsernameAndFirstName() {
        registerPage.registrationSteps("----", email, password, "", ".", lastName);

        Assert.assertEquals(registerPage.getInvalidUsernameMessage(),
                "The Username field must consist only letters and digits and must be at least 5 characters long.");
        Assert.assertEquals(registerPage.getInvalidConfirmPasswordMessage(), "The Confirm Password field is required.");
        Assert.assertEquals(registerPage.getInvalidFirstNameMessage(),
                "The First Name field must consist only letters and be at least 2 characters long.");
    }

      // Test registration with valid fields for Email, Username, Last Name and Confirm Password and invalid fields for First Name, Password
    @Test(priority = 10)
    public void testRegistrationWithInvalidFirstNameAndPassword() {
        registerPage.registrationSteps(username, email, "?", confirmPassword, "--", lastName);

        Assert.assertEquals(registerPage.getInvalidPasswordMessage(),
                "The Password must be at least 6 and at max 20 characters long.");
        Assert.assertEquals(registerPage.getInvalidFirstNameMessage(),
                "The First Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Email, Username, Password, First Name and invalid fields for Confirm Password, Last Name
    @Test(priority = 11)
    public void testRegistrationWithInvalidLastNameAndConfirmPassword() {
        registerPage.registrationSteps(username, email, password, "rndm", firstName, "**");

        Assert.assertEquals(registerPage.getInvalidConfirmPasswordMessage(),
                "The Confirm Password field must be at least 6 and at max 20 characters long.");
        Assert.assertEquals(registerPage.getInvalidLastNameMessage(),
                "The Last Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Username, Password, Confirm Password, Last Name and invalid fields for Email (used) and First Name
    @Test(priority = 12)
    public void testRegistrationWithInvalidFirstNameAndEmail() {
        registerPage.registrationSteps(username, "yecexo8611@ridteam.com", password, confirmPassword, "&", lastName);

        Assert.assertEquals(registerPage.getInvalidEmailMessage(), "The Email address is already used.");
        Assert.assertEquals(registerPage.getInvalidFirstNameMessage(),
                "The First Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Username, Email, Confirm Password, First Name and invalid fields for Password and Last Name
    @Test(priority = 13)
    public void testRegistrationWithInvalidLastNameAndPassword() {
        registerPage.registrationSteps(username, email, "rndm", confirmPassword, firstName, ";");

        Assert.assertEquals(registerPage.getInvalidPasswordMessage(),
                "The Password must be at least 6 and at max 20 characters long.");
        Assert.assertEquals(registerPage.getInvalidLastNameMessage(),
                "The Last Name field must consist only letters and be at least 2 characters long.");
    }

    // Test registration with valid fields for Username, Password, Names and invalid fields for Email and Confirm Password
    @Test(priority = 14)
    public void testRegistrationWithInvalidEmailAndConfirmPassword() {
        registerPage.registrationSteps(username, "text@text", password, "", firstName, lastName);

        Assert.assertEquals(registerPage.getInvalidEmailMessage(), "The Email field is not a valid e-mail address.");
        Assert.assertEquals(registerPage.getInvalidConfirmPasswordMessage(), "The Confirm Password field is required.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}