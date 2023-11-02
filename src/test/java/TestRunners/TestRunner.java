package TestRunners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/CucumberFeatureFIles",
                 glue="StepDefinitionFiles")
public class TestRunner extends AbstractTestNGCucumberTests {

}
