package pages;

import components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AddSubscriptionPage extends LoadableComponent<AddSubscriptionPage> {
    public WebDriver driver = Hooks.driver;
    public WebDriverWait wait = Hooks.wait;
    private final Button button = new Button(Hooks.wait);

    @Override
    protected void load() {
    }

    @Override
    public void isLoaded() throws Error {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("form")));
    }
    public String getPageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        WebElement reportListHeading = driver.findElement(By.tagName("h1"));
        return reportListHeading.getText();
    }

    public void selectAccountManagerFromDropdown(String manager){
        WebElement dropdown = driver.findElement(By.className("form-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(manager);
    }

    public void click(String buttonName){
        button.click(buttonName);
    }
}
