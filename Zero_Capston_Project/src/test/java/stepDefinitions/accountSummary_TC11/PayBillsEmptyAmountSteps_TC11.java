package stepDefinitions.accountSummary_TC11;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import static org.testng.Assert.*;
import java.time.Duration;
import stepDefinitions.CommonSteps11_12;
import utilities.ScreenshotUtil;

public class PayBillsEmptyAmountSteps_TC11 {
    WebDriver driver;
    WebDriverWait wait;
    CommonSteps11_12 commonSteps; 

    public PayBillsEmptyAmountSteps_TC11() {
        driver = stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonSteps = new CommonSteps11_12(); // Use the new common class
    }

    @When("User navigates to Pay Bills page with empty amount case")
    public void user_navigates_to_pay_bills_empty_case() {
        commonSteps.user_navigates_to_pay_bills(); // Reuse common method
    }

    @When("User enters a payment date {string}")
    public void user_enters_payment_date(String date) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sp_date"))).sendKeys(date);
    }

    @When("User clicks on Pay without entering amount")
    public void user_clicks_pay_without_amount() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("pay_saved_payees"))).click();
    }

    @Then("User should see a pop-up message since the amount field is empty")
    public void verify_error_message() {
        try {
            String validationMessage = driver.findElement(By.id("sp_amount")).getAttribute("validationMessage");
            System.out.println("Unable to see expected error message. Instead, browser validation popup appeared: " + validationMessage);
            assertTrue(validationMessage.contains("Please fill out this field"), "Test Passed: Validation message appeared.");
            ScreenshotUtil.captureScreenshot(driver, "SuccessfulLogin");
            driver.quit();
        } catch (Exception e) {
            fail("No validation message found!");
        }
    }
}
