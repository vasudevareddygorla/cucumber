package pages;

import components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionsPage {
    public WebDriver driver = Hooks.driver;
    public WebDriverWait wait = Hooks.wait;
    private final Button button = new Button(Hooks.wait);

    public void clickOnSubscriptionButton(String subscription, String buttonName){
        List<WebElement> subs = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("table tr"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("table tr button"))));
        subs = driver.findElements(By.cssSelector("table tr"));
        for(WebElement sub: subs){
            if(sub.getText().contains(subscription)){
                List<WebElement> buttons = sub.findElements(By.cssSelector("button"));
                for(WebElement btn:buttons){
                    if(btn.getText().equals(buttonName)){
                        btn.click();
                        return;
                    }
                }
            }
        }
    }
}
