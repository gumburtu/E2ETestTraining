package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class PlaceOrderLoginBeforeCheckout extends TestBase {
    @Test
    void placeOrderLoginBeforeCheckout() {
        // 1. Launch browser
        // 2. Navigate to URL 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // 3. Verify that the home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());

        // 4. Click the 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // 5. Fill in email and password fields and click the 'Login' button
        // 6. Verify 'Logged in as username' is displayed at the top
        // 7. Add products to the cart
        // 8. Click the 'Cart' button
        // 9. Verify that the cart page is displayed
        // 10. Click the 'Proceed To Checkout' button
        // 11. Verify Address Details and Review Your Order section
        // 12. Enter a description in the comment text area and click the 'Place Order' button
        // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration Date
        // 14. Click the 'Pay and Confirm Order' button
        // 15. Verify success message 'Your order has been placed successfully!' is displayed
        // 16. Click the 'Delete Account' button
        // 17. Verify 'ACCOUNT DELETED!' message and click the 'Continue' button

    }
}
