package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/Logout_TC15.feature",
    glue = {"stepDefinitions.accountSummary_TC15","stepDefinitions.accountSummary_TC4"},
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/TC15_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    tags = "@Logout"
)

public class TestRunner_15 extends AbstractTestNGCucumberTests {
}
