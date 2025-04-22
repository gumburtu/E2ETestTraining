package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class ContactForm extends TestBase {
    @Test
    void contactForm() {
        // Launch browser
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();


        // Verify that home page is visible successfully
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("Automation Exercise"));

        // Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();

        // Verify 'GET IN TOUCH' is visible
        driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed();

        // Enter name, email, subject and message
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String subject = faker.lorem().sentence();
        String message = faker.lorem().sentence();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(subject);
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(message);

        // Upload file
        driver.findElement(By.xpath("//input[@name='upload_file']"))
                .sendKeys("/Users/user/Desktop/Screen Shot 2025-04-22 at 15.04.07 pm.png");

        // Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // Click OK button
        driver.switchTo().alert().accept();

        // Verify success message 'Success! Your details have been submitted successfully.' is visible
        driver.findElement(By.xpath("//div[contains(text(), 'Success! Your details have been submitted successfully.')]")).isDisplayed();

        // Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));

    }
}
