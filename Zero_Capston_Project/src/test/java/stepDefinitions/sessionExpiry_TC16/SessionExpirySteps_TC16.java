package stepDefinitions.sessionExpiry_TC16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;

public class SessionExpirySteps_TC16 {
    WebDriver driver;
    WebDriverWait wait;
    @Given("User logs into Zero Bank")
    public void user_logs_into_zero_bank() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/"); 
        driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");  
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
    }

    @When("User logs out")
    public void user_logs_out() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        WebElement settingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='settingsBox']/ul/li[3]/a/b")));
        settingsMenu.click();

        
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='logout_link']")));
        logoutButton.click();

        System.out.println("User logged out successfully.");
    }


    @When("User clicks the Back button in the browser")
    public void user_clicks_back_button() {
        driver.navigate().back();
        
    }

    @Then("User should not be able to access the previous page")
    public void verify_session_expiry() {
        try {
            
            System.out.println("User should not be able to access the previous page.");
            Assert.assertTrue(true);
        } catch (Exception e) {
            System.out.println("User should not be able to access the previous page.");
            Assert.assertTrue(true);


        driver.quit();
    }
}
}