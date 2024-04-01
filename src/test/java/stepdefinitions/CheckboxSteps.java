package stepdefinitions;

import components.Checkbox;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import utils.Hooks;

import java.util.List;
import java.util.Map;

public class CheckboxSteps {
    private final Checkbox checkbox = new Checkbox(Hooks.driver);

    @When("^I perform action on \"([^\"]*)\" checkboxes$")
    public void performActionOnCheckboxes(String fieldName, DataTable dataTable) {
        List<Map<String, String>> checkboxList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> checkboxData : checkboxList) {
            String checkboxValue = checkboxData.get("Checkbox");
            String action = checkboxData.get("Action");
            checkbox.toggleCheckbox(fieldName, action, checkboxValue);
        }
    }
}
