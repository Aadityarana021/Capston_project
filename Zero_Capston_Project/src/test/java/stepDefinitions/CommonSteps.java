package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonSteps {
    WebDriver driver;
    WebDriverWait wait;

    public CommonSteps(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is NULL! Ensure login is executed first.");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User navigates to Transfer Funds page for balance validation")
    public void user_navigates_to_transfer_funds_for_balance_validation() {
        System.out.println("Navigating to Transfer Funds page...");

        
        WebElement onlineBanking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[normalize-space()='Online Banking']")));
        onlineBanking.click();
        System.out.println("Clicked Online Banking");

       
        WebElement accountSummary = wait.until(ExpectedConditions.elementToBeClickable(By.id("account_summary_link")));
        accountSummary.click();
        System.out.println("Clicked Account Summary");

        
        WebElement transferFunds = wait.until(ExpectedConditions.elementToBeClickable(By.id("transfer_funds_tab")));
        transferFunds.click();
        System.out.println("Clicked Transfer Funds");
    }
}
