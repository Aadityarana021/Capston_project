package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features/AddNewPayeeMissingDetails_TC13.feature",
    glue = {"stepDefinitions.accountSummary_TC13","stepDefinitions.accountSummary_TC4"},
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/TC13_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    dryRun = false 
)

public class TestRunner_TC13 extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
