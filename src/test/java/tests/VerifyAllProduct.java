package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class VerifyAllProduct extends TestBase {
    @Test
    void verifyAllProduct() {
        // Step 1: Launch browser
        // Step 2: Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // Step 3: Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertTrue(expectedUrl.equals(driver.getCurrentUrl()));

        // Step 4: Click on 'Products' button

        // Step 5: Verify user is navigated to ALL PRODUCTS page successfully
        // Step 6: The products list is visible
        // Step 7: Click on 'View Product' of first product
        // Step 8: User is landed to product detail page
        // Step 9: Verify that detail is visible: product name, category, price, availability, condition, brand

    }
}
