package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateAccountBalancesPage_TC6 {

    WebDriver driver;
    WebDriverWait wait;

    public ValidateAccountBalancesPage_TC6(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[normalize-space()='Online Banking']")
    private WebElement onlineBankingLink;

    @FindBy(id = "account_summary_link")
    private WebElement accountSummaryLink;

    @FindBy(id = "transfer_funds_tab")
    private WebElement transferFundsTab;

    @FindBy(id = "tf_fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(id = "tf_toAccountId")
    private WebElement toAccountDropdown;

    @FindBy(id = "tf_amount")
    private WebElement amountInput;

    @FindBy(id = "btn_submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    private WebElement successMessage;

    public void navigateToTransferFunds() {
        wait.until(ExpectedConditions.elementToBeClickable(onlineBankingLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(transferFundsTab)).click();
    }

    public void selectAccountsAndAmount() {
        wait.until(ExpectedConditions.elementToBeClickable(fromAccountDropdown)).sendKeys("1");
        wait.until(ExpectedConditions.elementToBeClickable(toAccountDropdown)).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys("1000");
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
    }
}
