package pages;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

public class LoginPage {

    public WebDriver  driver = Hooks.driver;
    public WebDriverWait wait = Hooks.wait;

    public void navigateToLoginPage(){
        String loginUrl = Configuration.getProperty("login.url");
        driver.get(loginUrl);
    }

    public void loginAsAdmin(){
        String username = Configuration.getProperty("user.username");
        String password = Configuration.getProperty("user.password");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys(username);
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys(password);
    }

    public void clickOnSubmit(){
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary")));
        loginButton.click();
    }

    public boolean isSubmitButtonEnabled() {
        WebElement submitButton = driver.findElement(By.cssSelector(".btn-primary"));
        return submitButton.isEnabled();
    }

    public String getPageTitle(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.card"))));
        WebElement headerWE = driver.findElement(By.tagName("h4"));
        return headerWE.getText();
    }

    public void clickOnForgotPasswordLink(){
        WebElement here = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/admin/forget-password']")));
        here.click();
    }
}
