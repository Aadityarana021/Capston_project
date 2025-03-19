package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/Login.feature",
    glue = "stepDefinitions", 
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports/LoginRunner_Report.html",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			}, 
    monochrome = true,
    tags = "@Login"
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}
