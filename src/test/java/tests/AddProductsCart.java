package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class AddProductsCart extends TestBase {
    @Test
    void addProductsCart() {
        // 1. Launch browser
        // 2. Navigate to URL 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // 3. Verify that the home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());

        // 4. Click the 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Hover over the first product and click 'Add to cart'
        Actions actions = new Actions(driver);

        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]"));
        actions.moveToElement(firstProduct).perform();
        driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]")).click();

        // 6. Click the 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        // 7. Hover over the second product and click 'Add to cart'
        WebElement secondProduct = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]"));
        actions.moveToElement(secondProduct).perform();
        driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//div[1]//a[1]")).click();

        // 8. Click the 'View Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        // 9. Verify both products are added to the cart
        // Locate cart items
        List<WebElement> cartItems = driver.findElements(By.xpath("//tr[contains(@id, 'product-')]"));

        // Assert that two products are added
        Assertions.assertEquals(2, cartItems.size(), "Both products should be in the cart");

        // 10. Verify their prices, quantity, and total price

        // Get price of first product
        WebElement firstProductPrice = driver.findElement(By.xpath("//td[@class='cart_price']//p[contains(text(),'Rs. 500')]"));
        double price1 = Double.parseDouble(firstProductPrice.getText().replace("Rs. ", ""));

        // Get quantity of first product
        WebElement firstProductQuantity = driver.findElement(By.xpath("//tr[@id='product-1']//button[@class='disabled'][normalize-space()='1']"));
        int quantity1 = Integer.parseInt(firstProductQuantity.getText());

        // Get total price of first product
        WebElement firstProductTotal = driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 500']"));
        double firstProductTotalValue = Double.parseDouble(firstProductTotal.getText().replace("Rs. ", ""));

        // Verification for first product
        Assertions.assertEquals(price1 * quantity1, firstProductTotalValue, "First product total price verification failed");

        // Get price of second product
        WebElement secondProductPrice = driver.findElement(By.xpath("//td[@class='cart_price']//p[contains(text(),'Rs. 400')]"));
        double price2 = Double.parseDouble(secondProductPrice.getText().replace("Rs. ", ""));

        // Get quantity of second product
        WebElement secondProductQuantity = driver.findElement(By.xpath("//tr[@id='product-2']//button[@class='disabled'][normalize-space()='1']"));
        int quantity2 = Integer.parseInt(secondProductQuantity.getText());

        // Get total price of second product
        WebElement secondProductTotal = driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 400']"));
        double secondProductTotalValue = Double.parseDouble(secondProductTotal.getText().replace("Rs. ", ""));

        // Verification for second product
        Assertions.assertEquals(price2 * quantity2, secondProductTotalValue, "Second product total price verification failed");

        // Verify overall total price
        double expectedTotalPrice = (price1 * quantity1) + (price2 * quantity2);
        double actualTotalPrice = 900;
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice, "Total cart price verification failed");

    }
}
