package stepDefinitions.accountSummary_TC6;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.ValidateAccountBalancesPage_TC6;
import stepDefinitions.CommonSteps;
import stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4;

public class ValidateAccountBalancesSteps_TC6 {

    WebDriver driver = AccountSummaryLoginSteps_TC4.getDriver();
    ValidateAccountBalancesPage_TC6 transferFundsPage;
    CommonSteps commonSteps;

    public ValidateAccountBalancesSteps_TC6() {
        this.commonSteps = new CommonSteps(driver); 
        this.transferFundsPage = new ValidateAccountBalancesPage_TC6(driver);
    }

    @When("User navigates to transfer funds for TC6 validation")
    public void user_navigates_to_transfer_funds_for_TC6() {
        commonSteps.user_navigates_to_transfer_funds_for_balance_validation();
    }

    @When("User selects From Account and To Account")
    public void user_selects_accounts() {
        transferFundsPage.selectAccountsAndAmount();
    }

    @When("User clicks on Continue")
    public void user_clicks_continue() {
        transferFundsPage.clickSubmit();
    }

    @Then("User should see the transfer confirmation")
    public void verify_transfer_success() {
        String successMsg = transferFundsPage.getSuccessMessage();
        String expectedMessage = "You successfully submitted your transaction.";

        Assert.assertTrue(successMsg.contains(expectedMessage), "Test Passed: Transfer successful.");
    }
}
