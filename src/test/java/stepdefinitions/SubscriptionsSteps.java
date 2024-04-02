package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.SubscriptionsPage;

public class SubscriptionsSteps {

    private final SubscriptionsPage subscriptionsPage = new SubscriptionsPage();

    @Then("^I click on \"([^\"]*)\" of \"([^\"]*)\" subscription$")
    public void pageShouldBeLoaded(String buttonName, String sub) {
        subscriptionsPage.clickOnSubscriptionButton(sub,buttonName);
    }
}
