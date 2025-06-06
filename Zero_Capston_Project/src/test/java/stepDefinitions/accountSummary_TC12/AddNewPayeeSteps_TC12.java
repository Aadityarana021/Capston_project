package stepDefinitions.accountSummary_TC12;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ScreenshotUtil;
import java.time.Duration;
import static org.testng.Assert.assertTrue;
import stepDefinitions.CommonSteps11_12;

public class AddNewPayeeSteps_TC12 {
    WebDriver driver;
    WebDriverWait wait;
    CommonSteps11_12 commonSteps;

    public AddNewPayeeSteps_TC12() {
        driver = stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
        commonSteps = new CommonSteps11_12(); // Use new common class
    }

    @When("User navigates to Pay Bills page for Adding New Payee")
    public void user_navigates_to_pay_bills_for_new_payee() {
        commonSteps.user_navigates_to_pay_bills(); // Reuse common method
    }

    @And("User clicks on {string} tab")
    public void user_clicks_on_tab(String tabName) {
        if (tabName.equalsIgnoreCase("Add New Payee")) {
            WebElement addNewPayeeTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Add New Payee')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewPayeeTab);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("np_new_payee_name")));
        }
    }

    @And("User enters new payee details")
    public void enter_payee_details() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Aditya Rana';", driver.findElement(By.id("np_new_payee_name")));
        js.executeScript("arguments[0].value='New Delhi, India';", driver.findElement(By.id("np_new_payee_address")));
        js.executeScript("arguments[0].value='SBI Savings Account';", driver.findElement(By.id("np_new_payee_account")));
        js.executeScript("arguments[0].value='Personal account of Aditya Rana';", driver.findElement(By.id("np_new_payee_details")));
    }

    @When("User clicks on {string} button")
    public void click_add_payee_button(String buttonName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_new_payee"))).click();
    }

    @Then("User should see a success message {string}")
    public void verify_success_message(String expectedMessage) {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert_content")));
        assertTrue(successMsg.getText().trim().contains(expectedMessage), "Payee creation failed!");
    }

    @Then("User captures a screenshot for confirmation")
    public void capture_screenshot() {
        ScreenshotUtil.captureScreenshot(driver, "AddNewPayee");
    }
}
