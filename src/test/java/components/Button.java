package components;

import config.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {

    private final WebDriverWait wait;
    public Button(WebDriverWait wait){
        this.wait=wait;
    }
    public void click(String buttonName){
        By locator = By.xpath(Configuration.getSelectorProperty("buttonName").replace("{0}",buttonName));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        addButton.sendKeys(Keys.ENTER);
    }
}
