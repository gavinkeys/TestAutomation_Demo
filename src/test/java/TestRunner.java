import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"}, // Path to feature files
        glue = {"git.gavinkeys.testautomation_demo.steps", "git.gavinkeys.testautomation_demo.cucumber"},
        plugin = {"pretty", "html:target/cucumber-reports"}, // Specify the plugin for generating HTML reports
        tags = "@login" // Specify the tags to include/exclude scenarios
)
public class TestRunner {
    static {
        // Specify the browser system property (chrome or firefox). Default to Chrome if not specified.
        String browser = System.getProperty("browser", "chrome");
        System.setProperty("browser", browser);
    }
}
