package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/FundTransferInsufficientBalance_TC7.feature",
    glue = {"stepDefinitions.accountSummary_TC7", "stepDefinitions.accountSummary_TC4"}, 
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/TC7_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    tags = "@FundTransferInsufficientBalance"
)

public class FundTransferInsufficientBalanceRunner_TC7 extends AbstractTestNGCucumberTests {
}
