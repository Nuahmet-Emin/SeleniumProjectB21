package com.cybertek.tests.tasks.day2_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4FacebookHeaderVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
 //3.Verify “Create a page” link href value contains text:
        // Expected: “registration_form"

        String expectedHeader = "registration-form";
        String actualHeader = driver.findElement(By.id("u_0_2")).getAttribute("data-testid");

        if(actualHeader.contains(expectedHeader)){
            System.out.println("Verification Passed");
        }else{
            System.out.println("Verification Failed!");
            System.out.println("Actual value: " + actualHeader);
        }


    }
}
