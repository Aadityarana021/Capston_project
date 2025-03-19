package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidateAccountTypesPage_TC5 {
    WebDriver driver;
    WebDriverWait wait;

    public ValidateAccountTypesPage_TC5(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Wait added
        PageFactory.initElements(driver, this);
    }

    // ✅ Locators
    @FindBy(xpath = "//strong[normalize-space()='Online Banking']")
    private WebElement onlineBankingLink;

    @FindBy(id = "account_summary_link")
    private WebElement accountSummaryLink;

    @FindBy(xpath = "//h2[normalize-space()='Cash Accounts']")
    private WebElement cashAccounts;

    @FindBy(xpath = "//h2[normalize-space()='Investment Accounts']")
    private WebElement investmentAccounts;

    @FindBy(xpath = "//h2[normalize-space()='Credit Accounts']")
    private WebElement creditAccounts;

    @FindBy(xpath = "//h2[normalize-space()='Loan Accounts']")
    private WebElement loanAccounts;

    // ✅ Navigate to Account Summary Before Validating Account Types
    public void navigateToAccountSummary() {
        wait.until(ExpectedConditions.elementToBeClickable(onlineBankingLink)).click(); // ✅ Click "Online Banking"
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryLink)).click(); // ✅ Click "Account Summary"
    }

    // ✅ Validate that all account types are displayed
    public boolean validateAccountTypes() {
        wait.until(ExpectedConditions.visibilityOf(cashAccounts)); // ✅ Wait for elements
        return cashAccounts.isDisplayed() && investmentAccounts.isDisplayed()
                && creditAccounts.isDisplayed() && loanAccounts.isDisplayed();
    }
}
