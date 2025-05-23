package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4;

public class CommonSteps11_12 {
    WebDriver driver = AccountSummaryLoginSteps_TC4.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

    @When("User navigates to Pay Bills page")
    public void user_navigates_to_pay_bills() {
        System.out.println("Navigating to Pay Bills page...");

        
        WebElement onlineBanking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[normalize-space()='Online Banking']")));
        onlineBanking.click();
        System.out.println("Clicked Online Banking");

        
        WebElement accountSummary = wait.until(ExpectedConditions.elementToBeClickable(By.id("account_summary_link")));
        accountSummary.click();
        System.out.println("Clicked Account Summary");

        
        WebElement payBillsTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("pay_bills_tab")));
        payBillsTab.click();
        System.out.println("Clicked Pay Bills");
    }
}
