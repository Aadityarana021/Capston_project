package stepDefinitions.accountSummary_TC15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import static org.testng.Assert.*;

import java.time.Duration;

public class LogoutSteps_TC15 {
    WebDriver driver;
    WebDriverWait wait;

    public LogoutSteps_TC15() {
        driver = stepDefinitions.accountSummary_TC4.AccountSummaryLoginSteps_TC4.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User clicks on the Logout button")
    public void user_clicks_on_logout_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        WebElement settingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='settingsBox']/ul/li[3]/a/b")));
        settingsMenu.click();

       
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='logout_link']")));
        logoutButton.click();

       
    }

    @Then("User should be redirected to the login page")
    public void verify_user_redirected_to_login_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        boolean isRedirected = wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("login.html"),
            ExpectedConditions.urlContains("index.html"),
            ExpectedConditions.presenceOfElementLocated(By.id("user_login")) // Check if login form is visible
        ));

        assertTrue(isRedirected, "Logout failed! User is not redirected properly.");
        System.out.println("Logout successful. User is redirected to login page.");
    }

}
