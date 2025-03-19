package stepDefinitions.accountSummary_TC9;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.BillPaymentPage_TC9;
import stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4;
import utilities.ScreenshotUtil;

public class BillPaymentSteps_TC9 {

    WebDriver driver = AccountSummaryLoginSteps_TC4.getDriver(); // ✅ Reuse TC4 login
    BillPaymentPage_TC9 billPaymentPage;

    public BillPaymentSteps_TC9() {
        billPaymentPage = new BillPaymentPage_TC9(driver);
    }

    @When("User navigates to Bills page to Pay Bills in TC9")
    public void user_navigates_to_pay_bills() {
        billPaymentPage.navigateToPayBills(); 
    }

    @When("User selects a payee and enters amount {string}")
    public void user_selects_a_payee_and_enters_amount(String amount) {
        billPaymentPage.enterPaymentDetails("John Doe", amount);
    }

    @When("User clicks Pay")
    public void user_clicks_pay() {
        billPaymentPage.clickPay(); 
    }

    @Then("User should see the payment confirmation")
    public void verify_payment_success() {
        String successMsg = billPaymentPage.getSuccessMessage();
        String expectedMessage = "The payment was successfully submitted.";

       
        System.out.println("Expected Message: " + expectedMessage);
        System.out.println("Actual Message: " + successMsg);

        
        Assert.assertTrue(successMsg.contains("The payment was successfully submitted."), "❌ Payment failed!");
        ScreenshotUtil.captureScreenshot(driver, "SuccessfulLogin");
        
        System.out.println("✔ Payment Success: " + successMsg);
    }
}
