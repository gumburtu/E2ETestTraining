package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class VerifySubscriptionHomePage extends TestBase {
    @Test
    void verifySubscriptionHomePage() {
        // 1. Launch browser
        // 2. Navigate to URL 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // 3. Verify that the home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertTrue(expectedUrl.equals(driver.getCurrentUrl()));

        // 4. Scroll down to the footer
        jsScrolltoElement(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")));

        // 5. Verify text 'SUBSCRIPTION'
        String expectedData = "SUBSCRIPTION";
        String subs = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).getText();
        Assertions.assertEquals(expectedData, subs);

        // 6. Enter email address in the input field and click the arrow button
        Faker faker = new Faker();
        String emailAdress = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys(emailAdress);
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();

        // 7. Verify success message 'You have been successfully subscribed!' is visible
        String expectedData1 = "You have been successfully subscribed!";
        String actualData1 = driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]/div")).getText();
        Assertions.assertEquals(expectedData1, actualData1);

    }
}
