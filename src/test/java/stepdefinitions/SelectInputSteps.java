package stepdefinitions;

import components.SelectInput;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

import java.util.List;
import java.util.Map;

public class SelectInputSteps {
    private final SelectInput selectInput;

    public SelectInputSteps() {
        WebDriver driver = Hooks.driver;
        WebDriverWait wait = Hooks.wait;
        selectInput = new SelectInput(driver, wait);
    }

    @Given("I chose the following values from the select fields$")
    public void enterInputFields(DataTable dataTable) {
        List<Map<String, String>> inputList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> input : inputList) {
            String fieldName = input.get("Selector Name");
            String value = input.get("Dropdown Value");
            selectInput.selectOptionByValue(fieldName, value);
        }
    }
}
