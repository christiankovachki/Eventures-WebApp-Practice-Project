package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserHomePage;

public class UserHomePageTest {
    WebDriver driver;
    LoginPage loginPage;
    UserHomePage userHomePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        userHomePage = new UserHomePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

//    @Test
//    public void testAllEventsFromDropdown() {
//        loginPage.loginSteps("guest", "guest");
//        userHomePage.clickEventsMenu();
//        userHomePage.clickAllEventsFromDropdown();
//
//        Assert.assertEquals(driver.getTitle(), "All Events - Eventures App");
//        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/main/h1")).isDisplayed());
//    }
//
//    @Test
//    public void testAllEventsFromLink() {
//        loginPage.loginSteps("guest", "guest");
//        userHomePage.clickAllEventsFromLink();
//
//        Assert.assertEquals(driver.getTitle(), "All Events - Eventures App");
//        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/main/h1")).isDisplayed());
//    }
//
//    @Test
//    public void testCreateEventFromDropdown() {
//        loginPage.loginSteps("guest", "guest");
//        userHomePage.clickEventsMenu();
//        userHomePage.clickCreateEventFromDropdown();
//
//        Assert.assertEquals(driver.getTitle(), "Create Event - Eventures App");
//        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/main/h1")).isDisplayed());
//                Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/main/form/div/div[4]/div/input")).isDisplayed());
//    }
//
//    @Test
//    public void testCreateEventFromLink() {
//        loginPage.loginSteps("guest", "guest");
//        userHomePage.clickCreateFromLink();
//
//        Assert.assertEquals(driver.getTitle(), "Create Event - Eventures App");
//        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/main/h1")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/main/form/div/div[4]/div/input")).isDisplayed());
//    }

//    @Test
//    public void testLogoutButton() {
//        loginPage.loginSteps("guest", "guest");
//        userHomePage.clickLogoutLink();
//
//        Assert.assertTrue(driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[1]/li[2]/a")).isDisplayed());
//    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}