package stepdefinitions;

import components.InputField;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

import java.util.List;
import java.util.Map;

public class InputFieldSteps {
    private final InputField inputField;

    public InputFieldSteps() {
        WebDriver driver = Hooks.driver;
        WebDriverWait wait = Hooks.wait;
        inputField = new InputField(driver, wait);
    }

    @Given("^I enter following input fields with values$")
    public void enterInputFields(DataTable dataTable) {
        List<Map<String, String>> inputList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> input : inputList) {
            String fieldName = input.get("Field Name");
            String value = input.get("Field Value");
            inputField.enterValue(fieldName, value);
        }
    }
}


