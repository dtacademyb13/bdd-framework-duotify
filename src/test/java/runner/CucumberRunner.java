package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@CucumberOptions (

//        tags = "@smoke or @flaky",
        //"@smoke and @flaky" - scenarios tagged with both smoke and flaky
        //"@smoke or @flaky" - scenarios tagged with either smoke or flaky
        //"not @REGRESSION" - scenarios not tagged with regression
       // "@smoke and @flaky or @homepage"
       // "@smoke and (@flaky or @homepage)"
        features = "src/test/resources", // path to the location of the feature files
        glue = "stepDefinitions", // path to the location of step definition classes
        plugin = {
             "pretty",   // adds more detailed info and logs on the console for debugging
             "html:target/cucumber-report/report.html" // generates a local html report
        },
        publish = true // generates a web based html report with link on the console
//        stepNotifications = true
//        ,dryRun = true  // dry runs the scenario for snippet generation
)
@RunWith(Cucumber.class)
public class CucumberRunner {
}
