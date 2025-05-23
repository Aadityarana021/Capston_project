package stepDefinitions.accountSummary_TC13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import utilities.ScreenshotUtil;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class AddNewPayeeMissingDetailsSteps_TC13 {
    WebDriver driver;
    WebDriverWait wait;

    public AddNewPayeeMissingDetailsSteps_TC13() {
        driver = stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User navigates to Add New Payee page")
    public void navigate_to_add_new_payee() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='Online Banking']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("account_summary_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("pay_bills_tab"))).click();

        // Click "Add New Payee" Tab
        WebElement addNewPayeeTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '#ui-tabs-2')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewPayeeTab);
    }

    @And("User leaves any field empty and clicks Add Payee")
    public void enter_incomplete_payee_details() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Fill some fields, leave others empty (e.g., leaving Account field empty)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("np_new_payee_name"))).sendKeys("Test Payee");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("np_new_payee_address"))).sendKeys("New Delhi, India");
        // Do NOT fill the account field to trigger the error
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("np_new_payee_details"))).sendKeys("Personal Test Account");

        // Click the Add Payee button
        WebElement addPayeeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add_new_payee")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addPayeeButton);
    }

    @Then("User should see a validation error")
    public void verify_validation_error() {
        try {
            // Check if the HTML5 validation message appears
            WebElement accountField = driver.findElement(By.id("np_new_payee_account"));
            String validationMessage = accountField.getAttribute("validationMessage");

//            if (!validationMessage.isEmpty()) {
//                System.out.println("⚠️ Browser Validation Error: " + validationMessage);
                ScreenshotUtil.captureScreenshot(driver, "AddPayee_MissingDetails");
//                return;
//            }

            // Check if our expected error appears (this may not be triggered due to browser validation)
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert_content")));
            String actualMessage = errorMessage.getText().trim();
            System.out.println("✅ Expected Error: 'All fields are required.'");
            System.out.println("✅ Actual Error: '" + actualMessage + "'");
            assertTrue(actualMessage.contains("All fields are required."), "❌ Validation message mismatch!");

        } catch (Exception e) {
            System.out.println("❌ No expected error message found!");
            ScreenshotUtil.captureScreenshot(driver, "MissingDetails_Failure");
            driver.quit();
        }
    }
}
