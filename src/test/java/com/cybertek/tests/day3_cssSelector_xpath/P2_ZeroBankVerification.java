package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P2_ZeroBankVerification {
    public static void main(String[] args) {

        //TC #2: Zero Bank link text verification
        // 1.Open Chrome browser
        WebDriver driver =  WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Verify link text from top left:Expected: “Zero Bank”

        WebElement zeroBankLink = driver.findElement(By.className("brand"));
        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();

        if (actualLinkText.equals(expectedLinkText)) {
            System.out.println("Link text verification PASSED!");
        } else {
            System.out.println("Link text verification FAILED!!!");
            System.out.println("Expected link text: " + expectedLinkText);
            System.out.println("Actual link text: " + actualLinkText);
        }

        // 4.Verify link hrefattribute value contains:Expected: “index.html”

        String expextedInHref = "index.html";
        String actualHref = zeroBankLink.getAttribute("href");


        if (actualHref.contains(expextedInHref)) {
            System.out.println("Href value verification PASSED!");
        } else {
            System.out.println("Href value verification FAILED!!!");
            System.out.println("ExpectedInHref = " + expextedInHref);
            System.out.println("actualHref = " + actualHref);
        }

        driver.close();
    }
}
