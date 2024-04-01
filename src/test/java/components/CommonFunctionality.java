package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

public class CommonFunctionality {
    public WebDriver driver = Hooks.driver;
    public WebDriverWait wait = Hooks.wait;
    public boolean isMainContentDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".main-content")));
        WebElement mainContent = driver.findElement(By.cssSelector(".main-content"));
        return mainContent.isDisplayed();
    }
    public String getPageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        WebElement reportListHeading = driver.findElement(By.tagName("h3"));
        return reportListHeading.getText();
    }

    public void waitForLoadingToComplete(){
        By loadingIndicatorLocator = By.cssSelector(".loading");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicatorLocator));
    }
}
