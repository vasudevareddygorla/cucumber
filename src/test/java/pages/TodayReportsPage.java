package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Hooks;

public class TodayReportsPage {
    public WebDriver  driver = Hooks.driver;

    public boolean verifyToDoLinkDisplayed(){
        return driver.findElement(By.cssSelector(".main-content a.nav-link.active")).isDisplayed();
    }
}
