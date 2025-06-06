package stepDefinitions.accountSummary_TC14;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import utilities.ScreenshotUtil;
import java.time.Duration;



import static org.testng.Assert.assertTrue;

public class ViewOnlineStatementsSteps_TC14 {
    WebDriver driver;
    WebDriverWait wait;

    public ViewOnlineStatementsSteps_TC14() {
        driver = stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User navigates to Online Statements page")
    public void navigate_to_online_statements() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='Online Banking']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("account_summary_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='online_statements_tab']"))).click();
    }

    @And("User selects an account from the dropdown")
    public void select_account_from_dropdown() {
        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='os_accountId']")));
        Select select = new Select(accountDropdown);

     
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].selectedIndex = 2; arguments[0].dispatchEvent(new Event('change'));", accountDropdown);
    }

    @And("User clicks on the statement link for 2012")
    public void click_statement_link() {
        WebElement statementLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='os_2012']/table/tbody/tr/td[1]/a")
        ));
        statementLink.click();
    }

    @Then("User should be able to view the selected statement")
    public void verify_statement_view() {
    
        ScreenshotUtil.captureScreenshot(driver, "ViewOnlineStatement");


        assertTrue(driver.getCurrentUrl().contains("statements"), "Statement not opened!");
    }
}
