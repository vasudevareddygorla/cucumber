package stepdefinitions;

import components.Switch;
import io.cucumber.datatable.DataTable;
import utils.Hooks;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class SwitchSteps {
    private final Switch flag = new Switch(Hooks.driver);

    @When("^I perform action on below switches$")
    public void enterInputFields(DataTable dataTable) {
        List<Map<String, String>> inputList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> input : inputList) {
            String flagName = input.get("Switch Name");
            String action = input.get("Action");
            flag.toggleSwitch(action,flagName);
        }
    }
}
