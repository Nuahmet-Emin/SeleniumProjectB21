package com.cybertek.tests.tasks.day3_tasks.P1_Cybertek;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class com_ForgotPasswordWebELementVerification {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2. Go to http://practice.cybertekschool.com/forgot_password

        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3. Locate all the WebElements on the page using XPATH and/or CSSlocator only (total of 6)
        // a. “Home” link.
        WebElement home = driver.findElement(By.xpath("//a[@class = 'nav-link']"));
        home.click();
        driver.navigate().back();
        // b.“Forgot password” header
        WebElement forgotPassword = driver.findElement(By.cssSelector("//h2[.= 'Forgot Password']"));
        System.out.println("forgotPassword text: " + forgotPassword.getText());

        // c. “E-mail” text
        WebElement email = driver.findElement(By.xpath("//label[@for ='email']"));
        System.out.println("Email text: " + email.getText());

        // d. E-mail input box
        WebElement inputBox = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
        inputBox.sendKeys("abc@gmail.com");
        driver.navigate().back();

        // e. “Retrieve password” button.
        WebElement retrievePassword = driver.findElement(By.xpath("//button[@id ='form_submit']"));
        retrievePassword.click();
        driver.navigate().back();

        // f.“Powered byCybertek School” text
        WebElement byCybertekSchool1 = driver.findElement(By.xpath("//div[@style = 'text-align: center;']"));
        WebElement byCybertekSchool2 = driver.findElement(By.xpath("//a[.= 'Cybertek School']"));
        String expectedText = "Powered byCybertek School";
        String actualText = byCybertekSchool1.getText() + byCybertekSchool2.getText();

        System.out.println(expectedText.equals(actualText));


        // 4. Verify all WebElements are displayed.


    }
}
