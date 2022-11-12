package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = "stepDefinitions",
        plugin = "html:target/HTML_report.html",
        tags = "@Positive"
)
public class RunLogin {
}
