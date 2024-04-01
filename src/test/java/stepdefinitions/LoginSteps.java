package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();

    @Given("^I am on the login page$")
    public void iAmOnLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("^I should login with admin$")
    public void iEnterEmailAndPassword() {
        loginPage.loginAsAdmin();
    }

    @When("^I click on the submit button$")
    public void iClickOnSubmitButton() {
        loginPage.clickOnSubmit();
    }

    @When("^I can see submit button is enabled: (true|false)$")
    public void iClickOnSubmitButton(boolean isEnabled) {
        Assert.assertEquals("Submit button state does not match the expected value", isEnabled, loginPage.isSubmitButtonEnabled());
    }

    @When("^I can see the login page title \"([^\"]*)\" : (true|false)$")
    public void verifyPageTitle(String title, boolean status) {
        Assert.assertEquals("User can see the login page title ", status, loginPage.getPageTitle().equals(title));
    }

    @When("^I click on the forgot password click here button$")
    public void clickOnForgotPasswordLink() {
        loginPage.clickOnForgotPasswordLink();
    }
}