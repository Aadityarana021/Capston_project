package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features/invalid.feature",
    glue = "stepDefinitions",
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/InvalidLoginRunner_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    tags = "@InvalidLogin"
)
@Test
public class InvalidLoginRunner extends AbstractTestNGCucumberTests {
}
