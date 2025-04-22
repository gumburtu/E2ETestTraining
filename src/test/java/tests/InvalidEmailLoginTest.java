package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;

public class InvalidEmailLoginTest extends TestBase {
    @Test
    void InvalidEmailLoginTest() throws AWTException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        waitForSecond(3);

        // 3. Verify that home page is visible successfully
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("Automation Exercise"));

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // 5. Verify 'Login to your account' is visible
        driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();

        // 6. Enter incorrect email address and password
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Raptiye4231893");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        String invalidEmail = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).getText();
        Assertions.assertTrue(invalidEmail.contains("Your email or password is incorrect!"));
    }
}
