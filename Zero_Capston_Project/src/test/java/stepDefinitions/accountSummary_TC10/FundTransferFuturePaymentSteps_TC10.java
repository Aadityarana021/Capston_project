package stepDefinitions.accountSummary_TC10;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.FundTransferFuturePaymentPage_TC10;
import stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4;
import utilities.ScreenshotUtil;

public class FundTransferFuturePaymentSteps_TC10 {

    WebDriver driver = AccountSummaryLoginSteps_TC4.getDriver(); // ✅ Reuse TC4 login session
    FundTransferFuturePaymentPage_TC10 futurePaymentPage;

    public FundTransferFuturePaymentSteps_TC10() {
        futurePaymentPage = new FundTransferFuturePaymentPage_TC10(driver);
    }

    @When("User navigates to Pay Bills page for Future Payment Test")
    public void user_navigates_to_pay_bills() {
        futurePaymentPage.navigateToPayBills();
    }

    @When("User selects a payee")
    public void user_selects_payee() {
        futurePaymentPage.selectPayee("Electric Bill"); // Only selects payee
    }

    @When("User enters a valid amount {string}")
    public void user_enters_amount(String amount) {
        futurePaymentPage.enterAmount(amount); // Only enters amount
    }

    @When("User enters a future date {string}")
    public void user_enters_future_date(String date) {
        futurePaymentPage.enterDate(date); // Only enters date
    }


    @When("User clicks Pay for Future Payment Test")
    public void user_clicks_pay() {
        futurePaymentPage.clickPay();
    }

    @Then("User should see a success message for fund transfer {string}")
    public void verify_fund_transfer_success_message(String expectedMessage) {
        String actualMessage = futurePaymentPage.getSuccessMessage();
        System.out.println("Expected Message: " + expectedMessage);
        System.out.println("Actual Message: " + actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage), "❌ Test Failed!");
        ScreenshotUtil.captureScreenshot(driver, "SuccessfulLogin");
        System.out.println("✔ Test Passed!");
    }
}
