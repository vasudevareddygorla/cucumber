package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "utils"},
        tags = "@app_master_login",
        plugin = {"pretty", "html:target/cucumber", "json:target/app-master-tests.json"}
)
public class AppMasterTestRunner {
}
