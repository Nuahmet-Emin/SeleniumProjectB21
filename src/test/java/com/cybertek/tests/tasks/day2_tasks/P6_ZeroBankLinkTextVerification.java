package com.cybertek.tests.tasks.day2_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_ZeroBankLinkTextVerification {
    public static void main(String[] args) {

        // TC #2: Zero Bank link text verification1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html

        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Verify link text from top left:Expected: “Zero Bank”

        String expectedLinkText = "Zero Bank";
        String actualLinkText = driver.findElement(By.linkText("Zero Bank")).getText();

        if(expectedLinkText.equals(actualLinkText)){
            System.out.println("Link text verification passed!");
        }else{
            System.out.println("Link text verification Failed!");
            System.out.println("Actual: " + actualLinkText);
        }
        // 4.Verify link hrefattribute value contains:
        // Expected: “index.html”

        String expectedAttributeValue = "index.html";
        String actualAttributeValue = driver.findElement(By.className("brand")).getAttribute("href");

        if(actualAttributeValue.contains(expectedAttributeValue)){
            System.out.println("Attribute value verification passed!");
        }else{
            System.out.println("Attribute value verification FAILED!");
            System.out.println("Actual attribute value: " + actualAttributeValue);
        }


    }
}
