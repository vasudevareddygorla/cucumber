package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.TodayReportsPage;

public class TodayReportsSteps {

    private final TodayReportsPage todayReportsPage =  new TodayReportsPage();

    @Then("I should see TODO link displayed$")
    public void verifyTodoLinkDisplayed() {
        Assert.assertTrue("TODO link is not displayed", todayReportsPage.verifyToDoLinkDisplayed());
    }
}
