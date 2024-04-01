package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "utils"},
        tags = "@clip_master_login",
        plugin = {"pretty", "html:target/cucumber-reports/clip-master-test-report.html"}
)
public class ClipMasterTestRunner {
}