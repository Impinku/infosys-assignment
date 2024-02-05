import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src//test//java"},plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"}, tags = {"@TC=12"})
public class Runner {
}