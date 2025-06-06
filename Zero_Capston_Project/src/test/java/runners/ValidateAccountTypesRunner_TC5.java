package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features/ValidateAccountTypes_TC5/ValidateAccountTypes_TC5.feature",
    		glue = {"stepDefinitions.accountSummary_TC5", "stepDefinitions.accountSummary_TC4"},
    				plugin = {
    					    "pretty",
    					    "html:target/cucumber-reports/TC5_Report.html",
    					    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    					}, 
    monochrome = true,
    tags = "@ValidateAccountTypes"
)
@Test
public class ValidateAccountTypesRunner_TC5 extends AbstractTestNGCucumberTests {
}
