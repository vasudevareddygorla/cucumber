package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "utils"},
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber-reports/smoke-test-report.html"}
)
public class SmokeTestRunner {
}

