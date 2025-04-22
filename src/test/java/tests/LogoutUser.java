package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class LogoutUser extends TestBase {
    @Test
    void logoutUser() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertTrue(expectedUrl.equals(driver.getCurrentUrl()));

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // 5. Verify 'Login to your account' is visible
        driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed();

        // 6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("aslanseval1986@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']']")).sendKeys("Raptiye4231893");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // 8. Verify that 'Logged in as username' is visible
        String logIn = driver.findElement(By.xpath("//li[10]//a[1]")).getText();
        Assertions.assertTrue(logIn.contains("seval"));

        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

        // 10. Verify that user is navigated to login page
        Assertions.assertTrue(driver.getCurrentUrl().equals("http://automationexercise.com/login"));

    }
}
