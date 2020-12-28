package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_GmailTitleVerification {
    public static void main(String[] args) {
        //TC #3: Back and forth navigation

        WebDriverManager.chromedriver().setup();

        WebDriver driver =  new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Gmail")).click();

        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();

         // Verify title contains"Gmail"
        if(actualTitle.contains(expectedInTitle)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }

        //5-go back to Google by using .back();
        driver.navigate().back();

        // 6.Verify title equals:
        // Expected : Google

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if(actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Google title verification Passed!");
        }else{
            System.out.println("Google title verification FAILED!");
        }

        driver.close();




    }
}
