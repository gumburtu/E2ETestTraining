package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Login extends TestBase {
    @Test
    void login() {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("Automation Exercise"));

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // 5. Verify 'Login to your account' is visible
        driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();

        // 6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("aslanseval1986@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Raptiye4231893");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // 8. Verify that 'Logged in as username' is visible
        String logIn = driver.findElement(By.xpath("//li[10]//a[1]")).getText();
        Assertions.assertTrue(logIn.contains("seval"));

        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed();
    }
}
