package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import static org.testng.Assert.*;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User opens the Zero Bank login page")
    public void user_opens_the_zero_bank_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("http://zero.webappsecurity.com/login.html");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("Clicks on the Sign In button")
    public void clicks_on_the_sign_in_button() {
        loginPage.clickSignIn();
    }

    @Then("User should be redirected to the Account Summary page")
    public void user_should_be_redirected_to_the_account_summary_page() {
        String expectedUrl = "http://zero.webappsecurity.com/bank/account-summary.html";
        assertTrue(driver.getCurrentUrl().contains("zero"), "Login failed! Page not redirected.");
    }
}
