package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

        //TC #1: Information alert practice
    @Test
    public void p1_information_alert_test() throws InterruptedException {

        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //3. Click to “Click for JS Alert” button
        informationAlertButton.click();

        Thread.sleep(2000);

        //4. Click to OK button from the alert
        // switching the driver's focus to alert
        Alert alert = driver.switchTo().alert();

        alert.accept();

        //5. Verify “You successfuly clicked an alert” text is displayed.

        WebElement resultText = driver.findElement(By.id("result"));

        String actualText = resultText.getText();
        String expectedText = "You successfuly clicked an alert";

        Assert.assertTrue(resultText.isDisplayed());
        Assert.assertEquals(actualText,expectedText);
    }


    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
