package components;

import config.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenshotUtil;

public class SelectInput {
    private final WebDriverWait wait;

    private final ScreenshotUtil screenshotUtil;

    public SelectInput(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.screenshotUtil = new ScreenshotUtil(driver);
    }

    public void selectOptionByValue(String fieldName, String value) {
        fieldName = fieldName.replace(" ", ".");
        By locator = By.cssSelector(Configuration.getSelectorProperty(fieldName));
        if (locator != null) {
            try {
                WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
                Select select = new Select(selectElement);
                select.selectByVisibleText(value);
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