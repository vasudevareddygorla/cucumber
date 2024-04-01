package stepdefinitions;

import components.Modal;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ModalSteps {

    private final Modal modal = new Modal();

    @Then("^I see popup displayed: (true|false)$")
    public void isModalDisplayed(boolean status) {
        Assert.assertEquals("Modal Popup is displayed ", status, modal.isModalDisplayed());
    }

    @When("^I close the popup$")
    public void closeModal() {
        modal.closeModalPopup();
    }
}
