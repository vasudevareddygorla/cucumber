package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Hooks;

public class NavMenu {
    public WebDriver driver = Hooks.driver;
    public void clickNavMenuItem(String menuItem){
        WebElement menuItemElement = driver.findElement(By.xpath("//a[@class='nav-link' and text()='" + menuItem + "']"));
        menuItemElement.click();
    }
}
