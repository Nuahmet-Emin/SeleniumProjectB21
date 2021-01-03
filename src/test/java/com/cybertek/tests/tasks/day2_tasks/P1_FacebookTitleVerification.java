package com.cybertek.tests.tasks.day2_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_FacebookTitleVerification {
    public static void main(String[] args) {

       // TC #1: Facebook title verification1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

//        2.Go to https://www.facebook.com
        driver.get("https://facebook.com");
//        3. Verify title:
//        Expected: “Facebook -Log In or Sign Up”

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed!");
        }else{
            System.out.println("Title verification FAILED!");
        }

        driver.close();
    }
}
