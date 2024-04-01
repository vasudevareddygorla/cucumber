package components;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

public class Modal {
    private final WebDriverWait wait;
    private final Button closeButton;
    private final WebDriver driver;
    public Modal(){
        this.wait= Hooks.wait;
        this.closeButton = new Button(wait);
        this.driver= Hooks.driver;
    }

    public void waitForLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Configuration.getSelectorProperty("Modal"))));
    }

    public void waitForClose(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Configuration.getSelectorProperty("Modal"))));
    }

    public boolean isModalDisplayed(){
        waitForLoad();
        return driver.findElement(By.cssSelector(Configuration.getSelectorProperty("Modal"))).isDisplayed();
    }

    public String getModalTitle(){
        waitForLoad();
        WebElement titleWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Configuration.getSelectorProperty("Modal.Header.Title"))));
        return titleWE.getText();
    }

    public String getSuccessMessage(){
        waitForLoad();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Configuration.getSelectorProperty("Modal.Body.Success.Message"))));
        return message.getText();
    }

    public String getFailedMessage(){
        waitForLoad();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Configuration.getSelectorProperty("Modal.Body.Fail.Message"))));
        return message.getText();
    }

    public void closeModalPopup(){
        waitForLoad();
        closeButton.click("Close");
        waitForClose();
    }

}
