package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "utils"},
        tags = "@ui",
        plugin = { "pretty", "html:target/cucumber", "json:target/ui-tests.json" },
        monochrome = true
)
public class UITestRunner {
}
