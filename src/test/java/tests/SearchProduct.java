package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class SearchProduct extends TestBase {
    @Test
    void searchProduct() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertTrue(expectedUrl.equals(driver.getCurrentUrl()));

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']"));

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        String productPage = "https://automationexercise.com/products";
        Assertions.assertTrue(driver.getCurrentUrl().equals(productPage));

        // 6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Men Tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        // 7. Verify 'SEARCHED PRODUCTS' is visible
        driver.findElement(By.xpath("//div[@class='product-image-wrapper']")).isDisplayed();

        // 8. Verify all the products related to search are visible
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));
        Assertions.assertFalse(products.isEmpty(), "No products found for the search query!");

        for (WebElement product : products) {
            Assertions.assertTrue(product.isDisplayed(), "A product is not visible on the search results page!");
        }
    }
}
