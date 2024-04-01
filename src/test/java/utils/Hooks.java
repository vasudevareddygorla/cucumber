package utils;

import config.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private boolean isFirstScenarioExecuted = false;

    @Before
    public void initializingBrowser(){
            System.setProperty("webdriver.chrome.driver", "/home/spurge/Downloads/chromedriver_linux64/chromedriver");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            //options.setBinary("/usr/bin/chromium-browser");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver,2);
    }

    @Before("@app_master_login")
    public void appMasterLogin() {
        String loginUrl = Configuration.getProperty("login.url");
        driver.get(loginUrl);
        String username = Configuration.getProperty("user.username");
        String password = Configuration.getProperty("user.password");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys(username);
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys(password);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary")));
        loginButton.click();
    }

    @Before("@clip_master_login")
    public void clipMasterLogin() {
        String loginUrl = Configuration.getProperty("login.url");
        driver.get(loginUrl);
        String username = Configuration.getProperty("cm_user.username");
        String password = Configuration.getProperty("cm_user.password");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys(username);
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys(password);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary")));
        loginButton.click();
    }

    @Before(order = 2, value = "@dependent")
    public void beforeDependentScenario(Scenario scenario) {
        // This will run before dependent scenario
        if (!isFirstScenarioExecuted) {
            throw new IllegalStateException("First scenario has not been executed yet!");
        }
    }

    @After(order = 2, value = "@dependent")
    public void afterDependentScenario() {
        // This will run after dependent scenario
    }

    @Before(order = 0, value = "@firstScenario")
    public void beforeFirstScenario() {
        // This will run before the first scenario
    }

    @After(order = 0, value = "@firstScenario")
    public void afterFirstScenario() {
        // This will run after the first scenario
        isFirstScenarioExecuted = true;
    }

    @After
    public void flush(){
        if(driver!=null){
            driver.quit();
        }
    }
}
