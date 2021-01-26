package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_Checkbox_Verification {
    public static void main(String[] args) {

        //https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // go to website
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //verify"Success - Check box is checked" msg is not displayed
        WebElement successMessage = driver.findElement(By.xpath("//div[@id ='txtAge'  ]"));

        //locating check box
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        if(!checkbox1.isSelected() && !successMessage.isDisplayed()){
            System.out.println("Checkbox is not selected. Message is not displayed. Verification PASS!");
        }else{
            System.out.println("FAILED!!!!");
        }
  //click
        checkbox1.click();
        if(checkbox1.isSelected() && successMessage.isDisplayed()) {
            System.out.println("Checkbox is  selected. Message is displayed. Verification PASS!");
        }else{
            System.out.println("FAILED!!!");
        }

        driver.close();




    }
}
