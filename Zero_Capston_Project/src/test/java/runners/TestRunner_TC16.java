package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/SessionExpiry_TC16.feature", 
    glue = {"stepDefinitions.sessionExpiry_TC16","stepDefinitions.accountSummary_TC4"}, 
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/TC16_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true, 
    dryRun = false,
    tags = "@SessionExpiry" 
)
public class TestRunner_TC16 extends AbstractTestNGCucumberTests {
}
