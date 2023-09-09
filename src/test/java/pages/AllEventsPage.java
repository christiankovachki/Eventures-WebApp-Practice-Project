package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class AllEventsPage {
    private WebDriver driver;
    private By createNewLink = By.xpath("/html/body/div/main/p/a");
    private ArrayList<WebElement> usernamesList;

    public AllEventsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateNewLink() {
        driver.findElement(createNewLink).click();
    }

    public void clickDeleteEventLink() {
        int userIndex = getMyUserIndex();
        driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[" + userIndex + "]/td[8]/a[1]")).click();
    }

    public void clickEditEventLink() {
        int userIndex = getMyUserIndex();
        driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[" + userIndex + "]/td[8]/a[2]")).click();
    }

    private int getMyUserIndex() {
        usernamesList = new ArrayList<>(driver.findElements(By.xpath("/html/body/div/main/table/tbody/tr/td[7]")));

        if (usernamesList.isEmpty()) {
            throw new IllegalStateException("There aren't any created events!");
        }

        int userIndex = -1;
        for (int i = 0; i < usernamesList.size(); i++) {
            WebElement username = driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[" + (i + 1) +"]/td[7]"));

            if (username.getText().equals("guest")) {
                userIndex = i + 1;
                break;
            }
        }

        return userIndex;
    }

}