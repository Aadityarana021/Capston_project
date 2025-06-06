package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/FundTransferBillPayment_TC9.feature",
        glue = {"stepDefinitions.accountSummary_TC9", "stepDefinitions.accountSummary_TC4"}, 
        		plugin = {
        			    "pretty",
        			    "html:target/cucumber-reports/TC12_Report.html",
        			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        			}, 
        monochrome = true,
        tags = "@FundTransferBillPayment"
)

public class BillPaymentRunner_TC9 extends AbstractTestNGCucumberTests {
}
