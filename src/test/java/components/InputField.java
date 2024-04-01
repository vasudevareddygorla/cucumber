package components;

import config.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenshotUtil;

public class InputField {
    private final WebDriverWait wait;
    private final ScreenshotUtil screenshotUtil;

    public InputField(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.screenshotUtil = new ScreenshotUtil(driver);
    }

    public void enterValue(String fieldName, String value) {
        fieldName = fieldName.replace(" ", ".");
        By locator = By.cssSelector(Configuration.getSelectorProperty(fieldName));
        if (locator != null) {
            try {
                WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(locator));
                inputField.clear();
                inputField.sendKeys(value);
//                inputField.sendKeys(Keys.ENTER);
            } catch (NoSuchElementException e) {
                screenshotUtil.captureScreenshot("FieldNotFound_" + fieldName);
                throw new NoSuchElementException("Field with name '" + fieldName + "' not found.", e);
            }
        } else {
            System.out.println("Field with name '" + fieldName + "' not found.");
            screenshotUtil.captureScreenshot("FieldNotFound_" + fieldName);
            throw new NoSuchElementException("Field with name '" + fieldName + "' not found.");
        }
    }
}

