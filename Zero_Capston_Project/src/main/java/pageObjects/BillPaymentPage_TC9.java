package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class BillPaymentPage_TC9 {
    WebDriver driver;
    WebDriverWait wait;

    public BillPaymentPage_TC9(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ Explicit Wait
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

    // ✅ Select Payee Dropdown
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

    public void navigateToPayBills() {
        wait.until(ExpectedConditions.elementToBeClickable(onlineBankingLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(payBillsTab)).click();
    }

    public void enterPaymentDetails(String payee, String amount) {
        wait.until(ExpectedConditions.elementToBeClickable(payeeDropdown)).sendKeys(payee);
        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys(amount);
        
        // ✅ Get Today’s Date in MM/DD/YYYY format
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dateInput.sendKeys(todayDate);
    }

    public void clickPay() {
        wait.until(ExpectedConditions.elementToBeClickable(payButton)).click();
    }

    public String getSuccessMessage() {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-success')]")));
        return successMsg.getText();
    }
}
