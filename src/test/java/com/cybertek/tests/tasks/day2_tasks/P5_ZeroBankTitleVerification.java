package com.cybertek.tests.tasks.day2_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_ZeroBankTitleVerification {

    public static void main(String[] args) {

         // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Verify title

        String expectedTitle = "Zero - Log in";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED");
            System.out.println("Actual title: " + actualTitle);
            System.out.println("Expected title: " + expectedTitle);
        }
        // Expected: “Zero -Log in”


    }
}
