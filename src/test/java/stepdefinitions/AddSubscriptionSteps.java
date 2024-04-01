package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddSubscriptionPage;

public class AddSubscriptionSteps {

    private final AddSubscriptionPage addSubscriptionPage = new AddSubscriptionPage();

    @Then("^I should see Add Subscription page header title \"([^\"]*)\"$")
    public void getPageTitle(String expectedHeadingText) {
        Assert.assertEquals("Verify the page contains the correct heading", expectedHeadingText, addSubscriptionPage.getPageTitle());
    }

    @Then("I wait for Add Subscription page to load$")
    public void pageShouldBeLoaded() {
        addSubscriptionPage.isLoaded();
    }

    @When("^I select \"([^\"]*)\" as the Account Manager$")
    public void selectAccountManager(String managerName) {
       addSubscriptionPage.selectAccountManagerFromDropdown(managerName);
    }

    @When("^I click (ADD|CLEAR) button$")
    public void clickAddButton(String buttonName) {
        addSubscriptionPage.click(buttonName);
    }

}
