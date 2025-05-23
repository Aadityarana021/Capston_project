package stepDefinitions.accountSummary_TC4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Scanner;
import java.time.Duration;
import static org.testng.Assert.*;

public class AccountSummaryLoginSteps_TC4 {
    private static WebDriver driver;  
    

    @Given("User logs into Zero Bank for Account Summary TC4")
    public void user_logs_into_zero_bank() {
        WebDriverManager.chromedriver().setup();

        // ✅ Set Chrome options to ignore SSL errors
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        // ✅ Replace manual input with automatic wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
            ExpectedConditions.titleContains("Zero"),
            ExpectedConditions.urlContains("account-summary")
        ));

        System.out.println("✅ Login successful!");
    }

    
    
    public static WebDriver getDriver() {  // ✅ Make getDriver() static
        return driver;
    }
}

    
    // ✅ Make WebDriver static so it can be shared

//    @Given("User logs into Zero Bank for Account Summary TC4")
//    public void user_logs_into_zero_bank() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://zero.webappsecurity.com/login.html");
//
//        driver.findElement(By.id("user_login")).sendKeys("username");
//        driver.findElement(By.id("user_password")).sendKeys("password");
//        driver.findElement(By.name("submit")).click();
//
//        System.out.println("Perform manual action (Captcha, 2FA, etc.). Press Enter to continue...");
//        Scanner scanner = new Scanner(System.in);
//        if (scanner.hasNextLine()) {
//            scanner.nextLine();
//        }
//        scanner.close();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        boolean loggedIn = wait.until(ExpectedConditions.titleContains("Zero"));
//
//        assertTrue(loggedIn, "Login failed!");
//    }

