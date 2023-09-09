package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllEventsPage;
import pages.LoginPage;
import pages.UserHomePage;

public class AllEventsPageTest {
    private WebDriver driver;
    private AllEventsPage allEventsPage;
    private LoginPage loginPage;
    private UserHomePage userHomePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        allEventsPage = new AllEventsPage(driver);
        loginPage = new LoginPage(driver);
        userHomePage = new UserHomePage(driver);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testCreateNewLink() {
        loginPage.loginSteps("guest", "guest");
        userHomePage.clickAllEventsFromLink();
        allEventsPage.clickCreateNewLink();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/main/h1")).getText(), "Create New Event");
        Assert.assertEquals(driver.getTitle(), "Create Event - Eventures App");
    }

    @Test(priority = 1)
    public void testEditEventLink() {
        loginPage.loginSteps("guest", "guest");
        userHomePage.clickAllEventsFromLink();
        allEventsPage.clickEditEventLink();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/main/h1")).getText(), "Edit Event");
        Assert.assertEquals(driver.getTitle(), "Edit Event - Eventures App");
    }

    @Test(priority = 2)
    public void testDeleteEventLink() {
        loginPage.loginSteps("guest", "guest");
        userHomePage.clickAllEventsFromLink();
        allEventsPage.clickDeleteEventLink();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/main/h1")).getText(), "Delete Existing Event");
        Assert.assertEquals(driver.getTitle(), "Delete Event - Eventures App");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}