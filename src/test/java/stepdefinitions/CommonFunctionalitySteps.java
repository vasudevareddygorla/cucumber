package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import components.CommonFunctionality;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonFunctionalitySteps {
    public final CommonFunctionality commonFunctionality = new CommonFunctionality();

    @Then("the main content should be displayed$")
    public void verifyMainContentDisplayed() {
        Assert.assertTrue("Main content is not displayed", commonFunctionality.isMainContentDisplayed());
    }
    @Then("^I should see the header title \"([^\"]*)\"$")
    public void iShouldBeLoggedInSuccessfully(String expectedHeadingText) {
        Assert.assertEquals("Verify the page contains the correct heading", expectedHeadingText, commonFunctionality.getPageTitle());
    }

    @When("I wait until the loading indicator disappears$")
    public void waitForLoadingIndicatorToDisappear() {
        commonFunctionality.waitForLoadingToComplete();
    }

}
