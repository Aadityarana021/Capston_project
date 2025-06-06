package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features/EmptyLogin.feature",
    glue = "stepDefinitions",
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/EmptyLoginRunner.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    tags = "@EmptyLogin"
)
@Test
public class EmptyLoginRunner extends AbstractTestNGCucumberTests {
}
