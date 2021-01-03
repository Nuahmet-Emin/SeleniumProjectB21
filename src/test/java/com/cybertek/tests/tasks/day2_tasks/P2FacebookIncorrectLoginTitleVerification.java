package com.cybertek.tests.tasks.day2_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2FacebookIncorrectLoginTitleVerification {
    public static void main(String[] args) {

        //TC #2: Facebook incorrect login title verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        // 3.Enter incorrect username
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");


        // 4.Enter incorrect password
        driver.findElement(By.id("pass")).sendKeys("123abcde");
        // 5.Verify title changed to:
        driver.findElement(By.name("login")).click();
        // Expected: “Log into Facebook | Facebook”
        String expectedLoginTitle = "Log into Facebook | Facebook";
        String actualLoginTitle = driver.getTitle();

        if(actualLoginTitle.equals(expectedLoginTitle)){
            System.out.println("Title verification PASSED!");
        }
        System.out.println("Title verification FAILED!");
        System.out.println("Expeced: " + expectedLoginTitle);
        System.out.println("Actual title: " + actualLoginTitle);

    }
}
