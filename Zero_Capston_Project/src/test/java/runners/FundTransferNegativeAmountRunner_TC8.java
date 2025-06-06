package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/FundTransferNegativeAmount_TC8.feature",
        glue = {"stepDefinitions.accountSummary_TC8", "stepDefinitions.accountSummary_TC4"},
        		plugin = {
        			    "pretty",
        			    "html:target/cucumber-reports/TC8_Report.html",
        			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        			}, 
        monochrome = true,
        tags = "@FundTransferNegativeAmount"
)


public class FundTransferNegativeAmountRunner_TC8 extends AbstractTestNGCucumberTests {
}
