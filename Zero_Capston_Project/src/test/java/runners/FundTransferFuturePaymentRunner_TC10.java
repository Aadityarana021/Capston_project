package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/FundTransferFuturePayment_TC10.feature",
        glue = {"stepDefinitions.accountSummary_TC10", "stepDefinitions.accountSummary_TC4"},
        		plugin = {
        			    "pretty",
        			    "html:target/cucumber-reports/TC10_Report.html",
        			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        			}, 
        monochrome = true,
        tags = "@FundTransferFuturePayment"
)

public class FundTransferFuturePaymentRunner_TC10 extends AbstractTestNGCucumberTests {
}
