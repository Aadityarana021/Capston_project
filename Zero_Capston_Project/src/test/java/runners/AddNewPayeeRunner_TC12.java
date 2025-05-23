package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/AddNewPayee_TC12.feature", 
        glue = {"stepDefinitions.accountSummary_TC12","stepDefinitions.accountSummary_TC4"}, 
        		plugin = {
        			    "pretty",
        			    "html:target/cucumber-reports/TC12_Report.html",
        			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        			}, 
        monochrome = true,
        tags = "@AddNewPayee" 
)

public class AddNewPayeeRunner_TC12 extends AbstractTestNGCucumberTests {
}
