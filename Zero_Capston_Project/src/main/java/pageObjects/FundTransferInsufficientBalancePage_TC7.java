package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransferInsufficientBalancePage_TC7 {
    WebDriver driver;
    WebDriverWait wait;

    public FundTransferInsufficientBalancePage_TC7(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ Explicit wait
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(id = "tf_fromAccountId")
    private WebElement fromAccountDropdown;

    
    @FindBy(id = "tf_toAccountId")
    private WebElement toAccountDropdown;

   
    @FindBy(id = "tf_amount")
    private WebElement amountInput;

    
    @FindBy(id = "btn_submit")
    private WebElement submitButton;

   
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement confirmSubmitButton;

    
    @FindBy(xpath = "//div[contains(@class, 'alert-error')]")
    private WebElement errorMessage;

    public void selectInsufficientFundsAccount() {
        System.out.println("? Selecting accounts...");
        Select fromAccount = new Select(wait.until(ExpectedConditions.visibilityOf(fromAccountDropdown)));
        fromAccount.selectByIndex(1); // ✅ Select insufficient funds account
        System.out.println(" Selected From Account");

        Select toAccount = new Select(wait.until(ExpectedConditions.visibilityOf(toAccountDropdown)));
        toAccount.selectByIndex(2); // ✅ Select another account
        System.out.println(" Selected To Account");

        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys("999999"); // ✅ Large amount
        System.out.println(" Entered large amount");
    }

    public void clickSubmit() {
        System.out.println(" Clicking Submit Button...");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click(); // ✅ Click main submit button
        
        try {
            wait.until(ExpectedConditions.elementToBeClickable(confirmSubmitButton)).click();
        } catch (TimeoutException e) {
            System.out.println(" No confirmation button found. Proceeding...");
        }
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        } catch (TimeoutException e) {
            return "No error message found.";
        }
    }
}
