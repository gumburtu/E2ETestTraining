package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class VerifyProductQuantityCart extends TestBase {
    @Test
    void verifyProductQuantityCart() {
        // 1. Tarayıcıyı başlat ve belirtilen URL'ye git
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click(); // Çerez onay butonuna tıkla

        // 2. Ana sayfanın başarıyla açıldığını doğrula
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());

        // 3. Ana sayfadan herhangi bir ürünün detay sayfasına gitmek için 'View Product' butonuna tıkla
        driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")).click();

        // 4. Ürün detay sayfasının açıldığını doğrula
        String expectedTitle = "Automation Exercise - Product Details";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // 5. Ürün miktarını 4 yap
        Actions actions = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity']"));
        actions.moveToElement(quantity).perform(); // Elementin üzerine gel

        quantity.clear();  // Mevcut değeri temizle
        quantity.sendKeys("4");  // Yeni değeri gir

        // 6. 'Add to cart' butonuna tıklayarak ürünü sepete ekle
        driver.findElement(By.xpath("//button[@type='button']")).click();

        // 7. 'View Cart' butonuna tıklayarak sepete git
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        // 8. Sepette ürün miktarını doğrula
        Integer expectedData = 4;
        String actualDataString = driver.findElement(By.xpath("//tr[@id='product-1']//td[4]//button")).getText();
        Integer actualDataInteger = Integer.parseInt(actualDataString);
        Assertions.assertEquals(expectedData, actualDataInteger, "Ürün miktarı doğrulama başarısız!");
    }
}
