package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class ExistEmail extends TestBase {
    @Test
    void existEmail() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        String title = driver.getTitle();
        Assertions.assertNotNull(title);
        Assertions.assertTrue(title.contains("Automation Exercise"));

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // 5. Verify 'New User Signup!' is visible
        driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed();

        // 6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("seval");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aslanseval1986@gmail.com");


        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();

        // 8. Verify error 'Email Address already exist!' is visible
        driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']")).isDisplayed();
    }
}
