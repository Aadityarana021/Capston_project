package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features/AccountSummary_TC4/AccountSummary_TC4.feature",
    glue = {"stepDefinitions.accountSummary_TC4"},
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/TC4_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    tags = "@AccountSummary_TC4"
)
@Test
public class AccountSummaryRunner_TC4 extends AbstractTestNGCucumberTests {
}
