package com.cybertek.tests.day1_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

    // 1-setup web driver
        WebDriverManager.chromedriver().setup();

    //2-create the instance of chrome driver
     // this is the line where the SW opens the browser
        WebDriver driver = new ChromeDriver();

    // 3- test if web driver is working

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        System.out.println("Current title of the page: " + driver.getTitle());

        String currentUrl = driver.getCurrentUrl();

        System.out.println("CurrentUrl = " + currentUrl);

        Thread.sleep(3000); // watis for 3 seconds

        // goes to back
        driver.navigate().back();


        Thread.sleep(3000);

        // goes to forward
        driver.navigate().forward();

        Thread.sleep(3000);

        // goes to
        driver.navigate().to("https://www.tesla.com");

        System.out.println("Current title of the page: " + driver.getTitle());

        currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        driver.close();

    }
}
