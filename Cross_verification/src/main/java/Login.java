import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Scanner;

public class Login {
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/index.html");
        driver.manage().window().maximize();
        
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.id("user_remember_me")).click();
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        // Wait for manual action
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to continue after manual action...");
        scanner.nextLine();
        scanner.close();

        // Continue execution after manual action (if needed)
        System.out.println("Resuming execution...");
        
        System.out.println(driver.getTitle());
        
        driver.quit();
    }
}
