package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransferFuturePaymentPage_TC10 {

    WebDriver driver;
    WebDriverWait wait;

    public FundTransferFuturePaymentPage_TC10(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ✅ Online Banking Link
    @FindBy(xpath = "//strong[normalize-space()='Online Banking']")
    private WebElement onlineBankingLink;

    // ✅ Account Summary Link
    @FindBy(id = "account_summary_link")
    private WebElement accountSummaryLink;

    // ✅ Pay Bills Tab
    @FindBy(id = "pay_bills_tab")
    private WebElement payBillsTab;

    // ✅ Payee Dropdown
    @FindBy(id = "sp_payee")
    private WebElement payeeDropdown;

    // ✅ Amount Input Field
    @FindBy(id = "sp_amount")
    private WebElement amountInput;

    // ✅ Date Input Field
    @FindBy(id = "sp_date")
    private WebElement dateInput;

    // ✅ Pay Button
    @FindBy(id = "pay_saved_payees")
    private WebElement payButton;

    // ✅ Success Message
    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    private WebElement successMessage;

    // ✅ Navigate to Pay Bills Section
    public void navigateToPayBills() {
        wait.until(ExpectedConditions.elementToBeClickable(onlineBankingLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(payBillsTab)).click();
    }

    // ✅ Select Payee and Enter Amount
    public void selectPayee(String payee) {
        wait.until(ExpectedConditions.elementToBeClickable(payeeDropdown)).sendKeys(payee);
    }

    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountInput)).clear();  // Clear previous input
        amountInput.sendKeys(amount);
    }

    public void enterDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(dateInput)).clear();  // Clear previous input
        dateInput.sendKeys(date);
    }


    // ✅ Click Pay Button
    public void clickPay() {
        wait.until(ExpectedConditions.elementToBeClickable(payButton)).click();
    }

    // ✅ Get Success Message
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
    }
}
