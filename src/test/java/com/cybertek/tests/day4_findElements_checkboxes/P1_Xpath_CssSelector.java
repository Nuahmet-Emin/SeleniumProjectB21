package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_Xpath_CssSelector {

    public static void main(String[] args) {
        // 1: PracticeCybertek.com_ForgotPassword WebElement verification1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
// 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
// 3. Locate all the WebElements on the page using XPATH and/or CSSlocator only (total of 6)

// a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));
        // WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        //WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']"));

// b. “Forgot password” header
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

// c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[.='E-mail']"));
        // WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

//  d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));

// e. “Retrieve password” button
        //WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button[id='form_submit']"));
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button#form_submit"));

// f. “Powered byCybertek School” text
        WebElement footerText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
// 4. Verify all WebElements are displayed.

        if(homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed()
        && emailLabel.isDisplayed() && emailInputBox.isDisplayed()
        && retrievePasswordButton.isDisplayed() && footerText.isDisplayed()){
            System.out.println("ALL web elements are displayed, verification passed");
        }else{
            System.out.println("Not displayed, verification Failed");
        }
    }

}
   // XPATHand CSSSelectorPRACTICESDO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.TC
// 1: PracticeCybertek.com_ForgotPassword WebElement verification1. Open Chrome browser
// 2. Go to http://practice.cybertekschool.com/forgot_password
// 3. Locate all the WebElements on the page using XPATH and/or CSSlocator only (total of 6)
// a. “Home” link
// b. “Forgot password” header
// c. “E-mail” textd. E-mail input box
// e. “Retrieve password” button
// f. “Powered byCybertek School” text
// 4. Verify all WebElements are displayed.