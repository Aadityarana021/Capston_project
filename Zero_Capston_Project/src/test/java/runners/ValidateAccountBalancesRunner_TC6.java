package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/ValidateAccountBalances_TC6/ValidateAccountBalances_TC6.feature",
    glue = {"stepDefinitions.accountSummary_TC6", "stepDefinitions.accountSummary_TC4"},
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/TC6_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    tags = "@ValidateAccountBalances"
)

public class ValidateAccountBalancesRunner_TC6 extends AbstractTestNGCucumberTests {
}
