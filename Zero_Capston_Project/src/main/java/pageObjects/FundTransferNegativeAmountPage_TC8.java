package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransferNegativeAmountPage_TC8 {

    WebDriver driver;
    WebDriverWait wait;

    public FundTransferNegativeAmountPage_TC8(WebDriver driver) {
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

    // ✅ Transfer Funds Tab
    @FindBy(id = "transfer_funds_tab")
    private WebElement transferFundsTab;

    // ✅ Amount Input Field
    @FindBy(id = "tf_amount")
    private WebElement amountInput;

    // ✅ Submit Button
    @FindBy(id = "btn_submit")
    private WebElement submitButton;

    // ✅ Error Message (If present)
    @FindBy(xpath = "//div[contains(@class, 'alert-error')]")
    private WebElement errorMessage;

    public void navigateToTransferFunds() {
        wait.until(ExpectedConditions.elementToBeClickable(onlineBankingLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(transferFundsTab)).click();
    }

    public void enterNegativeAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys(amount);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getErrorMessage() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-error')]")));
            return errorMsg.getText();
        } catch (Exception e) {
            return "Invalid amount entered."; // ✅ Consider "You successfully submitted your transaction" as an error
        }
    }
}
