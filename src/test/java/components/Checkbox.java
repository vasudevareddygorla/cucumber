package components;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtil;

import static utils.Hooks.wait;

public class Checkbox {
    private final ScreenshotUtil screenshotUtil;

    public Checkbox(WebDriver driver) {
        this.screenshotUtil = new ScreenshotUtil(driver);
    }

    public void toggleCheckbox(String fieldName,String action, String checkboxName) {
        fieldName = fieldName.replace(" ", ".");
        By locator = By.cssSelector(Configuration.getSelectorProperty(fieldName + "." + checkboxName));
        if (locator != null) {
            try {
                WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(locator));
                if (action.equals("select")) {
                    if (!checkbox.isSelected()) {
                        checkbox.click();
                    }
                } else if (action.equals("unselect")) {
                    if (checkbox.isSelected()) {
                        checkbox.click();
                    }
                }
            } catch (NoSuchElementException e) {
                screenshotUtil.captureScreenshot("CheckboxNotFound_" + checkboxName);
                throw new NoSuchElementException("Checkbox with name '" + checkboxName + "' not found.", e);
            }
        } else {
            System.out.println("Checkbox with name '" + checkboxName + "' not found.");
            screenshotUtil.captureScreenshot("CheckboxNotFound_" + checkboxName);
            throw new NoSuchElementException("Checkbox with name '" + checkboxName + "' not found.");
        }
    }
}
