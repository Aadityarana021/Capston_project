package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage_TC4 {
    WebDriver driver;

    public AccountSummaryPage_TC4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ✅ Updated locators based on your provided values
    @FindBy(xpath = "//strong[normalize-space()='Online Banking']")
    private WebElement onlineBankingLink;

    @FindBy(css = "#account_summary_link")
    private WebElement accountSummaryLink;

    @FindBy(xpath = "//h2[text()='Cash Accounts']")
    private WebElement cashAccounts;

    @FindBy(xpath = "//h2[text()='Investment Accounts']")
    private WebElement investmentAccounts;

    @FindBy(xpath = "//h2[text()='Credit Accounts']")
    private WebElement creditAccounts;

    @FindBy(xpath = "//h2[text()='Loan Accounts']")
    private WebElement loanAccounts;

    public void goToAccountSummary() {
        onlineBankingLink.click(); // ✅ First, click "Online Banking" if needed
        accountSummaryLink.click(); // ✅ Then, click on "Account Summary"
    }

    public boolean isAccountSummaryDisplayed() {
        return cashAccounts.isDisplayed() && investmentAccounts.isDisplayed()
                && creditAccounts.isDisplayed() && loanAccounts.isDisplayed();
    }
}
