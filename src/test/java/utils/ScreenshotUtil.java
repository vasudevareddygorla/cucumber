package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {
    private final WebDriver driver;

    public ScreenshotUtil(WebDriver driver){
        this.driver = driver;
    }
    public void captureScreenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Path screenshotPath = Paths.get("screenshots", fileName + ".png");
            Files.createDirectories(screenshotPath.getParent());
            Files.copy(screenshotFile.toPath(), screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
