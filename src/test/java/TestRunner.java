import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"}, // Path to your feature files
        glue = {"git.gavinkeys.testautomation_demo.steps"}, // Package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@login"
)
public class TestRunner {
    static {
        // Specify the browser system property (chrome or firefox)
        String browser = System.getProperty("browser", "chrome");
        System.setProperty("browser", browser);
    }
}