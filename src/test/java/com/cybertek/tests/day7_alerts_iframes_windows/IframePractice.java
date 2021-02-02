package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to website: http://practice.cybertekschool.com/iframe
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void iframe_test(){
        //TC #4 : Iframe practice
        //1. Create a new class called: IframePractice
        //2. Create new test and make set ups
        //3. Go to: http://practice.cybertekschool.com/iframe

        // find iframe
        // locate web element
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(iframe);
        //2nd way:driver.switchTo().frame(0);
       // 3rd way: driver.switchTo().frame("mce_0_ifr");

        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        driver.switchTo().parentFrame();
        WebElement headerText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isDisplayed());
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
