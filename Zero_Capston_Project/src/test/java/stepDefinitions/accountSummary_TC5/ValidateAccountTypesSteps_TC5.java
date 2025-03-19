package stepDefinitions.accountSummary_TC5;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.ValidateAccountTypesPage_TC5;
import stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4;
import static org.testng.Assert.*;

public class ValidateAccountTypesSteps_TC5 {
    WebDriver driver = AccountSummaryLoginSteps_TC4.getDriver();  // ✅ Reusing existing login class
    ValidateAccountTypesPage_TC5 validateAccountTypesPage;

    @When("User navigates to the Account Summary page for TC5")
    public void user_navigates_to_account_summary() {
        validateAccountTypesPage = new ValidateAccountTypesPage_TC5(driver);
        validateAccountTypesPage.navigateToAccountSummary(); // ✅ Click Online Banking & Account Summary
    }

    @Then("User should see all expected account types for TC5")
    public void verify_account_types_displayed() {
        assertTrue(validateAccountTypesPage.validateAccountTypes(), "Account types are not displayed correctly!");
        driver.quit();
    }
}
