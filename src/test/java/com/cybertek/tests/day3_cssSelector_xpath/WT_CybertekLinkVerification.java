package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_CybertekLinkVerification {
    public static void main(String[] args) {

       //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("abc@gmail.com");

        // 4.Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();

        // 5.Verify URL contains: Expected: “email_sent”
        String expectedInUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification passed!");
        }else{
            System.out.println("URL verification Failed!");
            System.out.println("Actual url: " + actualUrl);
            System.out.println("Expected In Url: " + expectedInUrl);
        }
        // 6.Verify textbox displayed the content as expected.
        // Expected: “Your e-mail’s been sent!

       WebElement confirmationMessage =  driver.findElement(By.name("confirmation_message"));
        // first verification to check if t is displayed on the page or not
        if(confirmationMessage.isDisplayed()){
            System.out.println("Confirmation message is displayed. PASS!!");
        }else{
            System.out.println("Confirmation message is NOT DISPLAYED!!!");
        }

        // second verification : is to check content of the confirmationMessage web element
        //  Expected: “Your e-mail’s been sent!
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Message verification PASSED!!");
        }else{
            System.out.println("Message verification FAILED!!!");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.close();





    }
}
