package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P4_XpathPractice {
    public static void main(String[] args) {

      WebDriver driver = WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();

      driver.get("http://practice.cybertekschool.com/multiple_buttons");

      //locate button2 using Xpath Locator

        //WebElement button2 = driver.findElement(By.xpath("//button[@name = 'button2']"));

        WebElement button2 = driver.findElement(By.xpath("//button[.='Button 2']"));
        button2.click();

    }
}
