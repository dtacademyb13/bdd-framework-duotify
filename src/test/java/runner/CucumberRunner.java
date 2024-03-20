package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@CucumberOptions (

        features = "src/test/resources", // path to the location of the feature files
        glue = "stepDefinitions" // path to the location of step definition classes

)
@RunWith(Cucumber.class)
public class CucumberRunner {
}
