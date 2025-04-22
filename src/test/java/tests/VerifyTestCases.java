package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class VerifyTestCases extends TestBase {
    @Test
    void verifyTestCases() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertTrue(expectedUrl.equals(driver.getCurrentUrl()));

        // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();

        // 5. Verify user is navigated to test cases page successfully
        String expectedUrl2 = "https://automationexercise.com/test_cases";
        Assertions.assertTrue(expectedUrl2.equals(driver.getCurrentUrl()));
    }
}
