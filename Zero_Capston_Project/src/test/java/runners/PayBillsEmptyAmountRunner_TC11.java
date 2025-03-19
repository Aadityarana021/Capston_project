package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/FundTransferEmptyAmount_TC11.feature",
        glue = {"stepDefinitions.accountSummary_TC11", "stepDefinitions.accountSummary_TC4"},
        		plugin = {
        			    "pretty",
        			    "html:target/cucumber-reports/TC11_Report.html",
        			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        			}, 
        monochrome = true,
        tags = "@PayBillsWithoutAmount"
)

public class PayBillsEmptyAmountRunner_TC11 extends AbstractTestNGCucumberTests {
}
