package VoilaTest;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        //for plugin check https://cucumber.io/docs/cucumber/reporting/
        plugin = {"json:build/cucumber.json", "pretty", "html:build/result"},
        features = "src/test/resources/features", tags = {"@UL003-005"})
public class CucumberTestRunner {
}
