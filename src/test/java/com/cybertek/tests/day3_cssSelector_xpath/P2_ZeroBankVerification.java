package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_ZeroBankVerification {
    public static void main(String[] args) {

        //TC #2: Zero Bank link text verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Verify link text from top left:Expected: “Zero Bank”

        WebElement zeroBankLink = driver.findElement(By.className("brand"));
        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();

        if(actualLinkText.equals(expectedLinkText)){
            System.out.println("Link text verification PASSED!");
        }else{
            System.out.println("Link text verification FAILED!!!");
            System.out.println("Expected link text: " + expectedLinkText);
            System.out.println("Actual link text: " + actualLinkText);
        }

        // 4.Verify link hrefattribute value contains:Expected: “index.html”



    }
}
