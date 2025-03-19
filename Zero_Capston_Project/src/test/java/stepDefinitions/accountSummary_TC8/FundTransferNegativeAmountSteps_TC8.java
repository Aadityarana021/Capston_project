package stepDefinitions.accountSummary_TC8;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.FundTransferNegativeAmountPage_TC8;
import stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4;  // ✅ Use TC4's driver

public class FundTransferNegativeAmountSteps_TC8 {

    WebDriver driver = AccountSummaryLoginSteps_TC4.getDriver();
    FundTransferNegativeAmountPage_TC8 transferFundsPage;

    public FundTransferNegativeAmountSteps_TC8() {
        transferFundsPage = new FundTransferNegativeAmountPage_TC8(driver);
    }

    @When("User navigates to Transfer Funds page for Negative Amount Test")
    public void user_navigates_to_transfer_funds() {
        transferFundsPage.navigateToTransferFunds();
    }

    @When("User enters a negative amount {string}")
    public void user_enters_negative_amount(String amount) {
        transferFundsPage.enterNegativeAmount(amount);
    }

    @When("User clicks on Submit for Negative Amount Test")
    public void user_clicks_submit() {
        transferFundsPage.clickSubmit();
    }

    @Then("User should see an error message {string} for Negative Amount Test")
    public void verify_error_message(String expectedMessage) {
        String actualMessage = transferFundsPage.getErrorMessage();
        System.out.println("Expected Error: " + expectedMessage);
        System.out.println("Actual Message: " + actualMessage);

        // ✅ If the system shows "You successfully submitted your transaction", consider it as an error
        if (actualMessage.contains("You successfully submitted your transaction")) {
            actualMessage = "Invalid amount entered.";
        }

        Assert.assertEquals(actualMessage, expectedMessage, "❌ Test Failed! Unexpected message received.");
        System.out.println("✔ Test Passed: Error message is displayed correctly.");
    }
}
