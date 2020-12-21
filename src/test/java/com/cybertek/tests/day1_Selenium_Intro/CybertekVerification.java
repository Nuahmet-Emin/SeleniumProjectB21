package com.cybertek.tests.day1_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cybertekschool.com");

        System.out.println(driver.getCurrentUrl().contains("cybertekschool"));

        System.out.println(driver.getTitle());

    }
}
