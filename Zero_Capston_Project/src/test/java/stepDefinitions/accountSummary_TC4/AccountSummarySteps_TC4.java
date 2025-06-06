package stepDefinitions.accountSummary_TC4;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.AccountSummaryPage_TC4;
import static org.testng.Assert.*;

public class AccountSummarySteps_TC4 {
    WebDriver driver = AccountSummaryLoginSteps_TC4.getDriver();  
    AccountSummaryPage_TC4 accountSummaryPage;
    @When("User clicks on the specific statement link for 2012")
    public void click_specific_statement_link() {
        System.out.println("User clicks on the statement link for 2012 ");
    }
        @When("User navigates to the Account Summary page TC4")
    public void user_navigates_to_account_summary() {
        accountSummaryPage = new AccountSummaryPage_TC4(driver);
        accountSummaryPage.goToAccountSummary();
    }

    @Then("Account Summary page should display account types and balances TC4")
    public void verify_account_summary_details() {
        assertTrue(accountSummaryPage.isAccountSummaryDisplayed(), "Account Summary Page not displayed correctly!");
        driver.quit();  
    }
}
