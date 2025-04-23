package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class PlaceOrderRegisterBeforeCheckout extends TestBase {
    @Test
    void placeOrderRegisterBeforeCheckout() {
        // 1. Launch browser
        // 2. Navigate to URL 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[@class=\"fc-button-label\"]")).click();

        // 3. Verify that the home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());

        // 4. Click the 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // 5. Fill in all details in the Signup form and create an account
        Faker faker = new Faker();
        String name = faker.name().firstName();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).isDisplayed();

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Ww123456?");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("2000");

        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        driver.findElement(By.xpath("//input[@id='optin']")).click();

        Faker faker1 = new Faker();
        String name1 = faker1.name().firstName();
        String lastName2 = faker1.name().lastName();
        String companyName = faker1.company().name();
        String address = faker1.address().streetAddress();
        String address2 = faker1.address().secondaryAddress();
        String state = faker1.address().state();
        String city = faker1.address().city();
        String zipCode = faker1.address().zipCode();
        String mobileNumber = faker1.phoneNumber().cellPhone();

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(name1);
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastName2);
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(companyName);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(address2);
        jsScrolltoElement(driver.findElement(By.xpath("//label[@for='address1']")));
        waitForSecond(1);
        WebElement option = driver.findElement(By.xpath("//select[@id='country']"));
        option.click();

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(mobileNumber);

        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        // 6. Verify 'ACCOUNT CREATED!' message and click the 'Continue' button
        driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        // 7. Verify 'Logged in as username' is displayed at the top
        driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed();

        // 8. Add products to the cart
        Actions actions = new Actions(driver);
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='features_items']//div[2]//div[1]//div[1]//div[2]"));
        actions.moveToElement(addToCart).perform();
        driver.findElement(By.xpath("//div[@class='features_items']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]")).click();

        // 9. Click the 'Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        // 10. Verify that the cart page is displayed
        String expectedData = "https://automationexercise.com/view_cart";
        String actualData = driver.getCurrentUrl();
        Assertions.assertEquals(expectedData, actualData);

        // 11. Click the 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        // 12. Verify Address Details and Review Your Order section
        driver.findElement(By.xpath("//h2[normalize-space()='Address Details']")).isDisplayed();
        driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']")).isDisplayed();

        // 13. Enter a description in the comment text area and click the 'Place Order' button
        String text = faker.esports().game();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(text);
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"))).perform();
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        // 14. Enter payment details: Name on Card, Card Number, CVC, Expiration Date
        String cardName = faker.name().fullName(); // Rastgele kart sahibinin adı
        String cardNumber = faker.number().digits(16); // 16 haneli kart numarası
        String cvcNumber = faker.number().digits(3); // 3 haneli CVC numarası
        String expirationMonth = String.valueOf(faker.number().numberBetween(1, 12)); // 1-12 arasında ay değeri
        String expirationYear = String.valueOf(faker.number().numberBetween(2025, 2030)); // Gelecek yıllardan biri

        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(cardName);
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys(cardNumber);
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys(cvcNumber);
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(expirationMonth);
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys(expirationYear);

        // 15. Click the 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        // 16. Verify success message 'Your order has been placed successfully!' is displayed
        driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']")).isDisplayed();

        // 17. Click the 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();

        // 18. Verify 'ACCOUNT DELETED!' message and click the 'Continue' button
        String actualdeleteMessage = driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).getText();
        String expectedDataDeleted = "ACCOUNT DELETED!";

        Assertions.assertEquals(expectedDataDeleted, actualdeleteMessage);

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

    }
}
