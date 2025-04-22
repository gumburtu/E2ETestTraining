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
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // Step 5: Verify user is navigated to ALL PRODUCTS page successfully
        String expectedUrl2 = "https://automationexercise.com/products";
        Assertions.assertTrue(expectedUrl2.equals(driver.getCurrentUrl()));

        // Step 6: The products list is visible
        driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        jsScrolltoElement(driver.findElement(By.xpath("//h2[@class='title text-center']")));
        // Step 7: Click on 'View Product' of first product
        driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]//i[1]")).click();

        // Step 8: User is landed to product detail page
        String expectedUrl3 = "https://automationexercise.com/product_details/1";
        Assertions.assertTrue(expectedUrl3.equals(driver.getCurrentUrl()));
        System.out.println(driver.getCurrentUrl());

        // Step 9: Verify that detail is visible: product name, category, price, availability, condition, brand
        driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']")).isDisplayed();
        driver.findElement(By.xpath("//h2[normalize-space()='Category']")).isDisplayed();
        driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']")).isDisplayed();
        driver.findElement(By.xpath("//b[normalize-space()='Availability:']")).isDisplayed();
        driver.findElement(By.xpath("//b[normalize-space()='Condition:']")).isDisplayed();
        driver.findElement(By.xpath("//b[normalize-space()='Brand:']")).isDisplayed();

    }
}
