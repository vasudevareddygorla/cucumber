package components;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtil;

import static utils.Hooks.wait;

public class Switch {
    private final ScreenshotUtil screenshotUtil;
    public Switch(WebDriver driver){
        this.screenshotUtil = new ScreenshotUtil(driver);
    }
    public void toggleSwitch(String action, String flagId) {
        flagId = flagId.replace(" ", ".");
        By locator = By.cssSelector(Configuration.getSelectorProperty(flagId));
        if (locator != null) {
            try {
                WebElement flag = wait.until(ExpectedConditions.elementToBeClickable(locator));
                if (action.equals("enable")) {
                    if (!flag.isSelected()) {
                        flag.click();
                    }
                } else if (action.equals("disable")) {
                    if (flag.isSelected()) {
                        flag.click();
                    }
                }
            } catch (NoSuchElementException e) {
                screenshotUtil.captureScreenshot("SwitchNotFound_" + flagId);
                throw new NoSuchElementException("Switch with name '" + flagId + "' not found.", e);
            }
        } else {
            System.out.println("Switch with name '" + flagId + "' not found.");
            screenshotUtil.captureScreenshot("SwitchNotFound_" + flagId);
            throw new NoSuchElementException("Switch with name '" + flagId + "' not found.");
        }
    }
}
