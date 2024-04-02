package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
        By loadingIndicatorLocator = By.cssSelector(".loading, app-pressclips img");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicatorLocator));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isDuplicateListingPresent() {
        List<WebElement> listingElements = driver.findElements(By.cssSelector("app-header-results app-listing ul li"));
        List<String> paragraphText = new ArrayList<>();
        Set<String> duplicateText = new HashSet<>();
            for (WebElement paragraph : listingElements) {
                if((paragraph.getText().contains("Article may contain the following mentions")) || (paragraph.getText().contains("Syndicated By"))) {

                }else{
                    if(!paragraphText.contains(paragraph.getText())){
                        paragraphText.add(paragraph.getText());
                    }else{
                        duplicateText.add(paragraph.getText());
                    }
                }

            }
        if (duplicateText.size()>0) {
            for (String text : duplicateText) {
                System.out.println("Duplicate listing: "+text);
            }
            return true;
        }else {
            return false;
        }
    }
}
