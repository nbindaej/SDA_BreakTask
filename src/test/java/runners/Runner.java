package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "stepdefinitions",
        features = "src/test/resources/features/swagLab.feature",
        plugin = {
                "html:cucumber-reports/report.html"
        },
        tags = "@problemUser"
)
public class Runner {
}
