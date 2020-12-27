package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_GmailTitleVerification {
    public static void main(String[] args) {
        //TC #3: Back and forth navigation

        WebDriverManager.chromedriver().setup();

        WebDriver driver =  new ChromeDriver();

        driver.get("https://www.google.com");


    }
}
