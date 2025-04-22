package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class RegisterUser extends TestBase {
    @Test
    void registerUser() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        waitForSecond(2);

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        Assertions.assertTrue(expectedUrl.equals(driver.getCurrentUrl()));

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed();

        //6. Enter name and email address
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).isDisplayed();

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Ww123456?");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("2000");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Faker faker1 = new Faker();
        String name1 = faker1.name().firstName();
        String lastName2 = faker1.name().lastName();
        String campanyName = faker1.company().name();
        String address = faker1.address().streetAddress();
        String address2 = faker1.address().secondaryAddress();
        String state = faker1.address().state();
        String city = faker1.address().city();
        String zipCode = faker1.address().zipCode();
        String mobileNumber = faker1.phoneNumber().cellPhone();

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(name1);
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastName2);
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(campanyName);
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

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed();

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //16. Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed();

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

    }
}
