package com.cybertek.tests.tasks.day4_tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC3_Checbox_Verification_S1 {
    public static void main(String[] args) {
        //Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
        WebElement successCheckbox = driver.findElement(By.xpath("//div[.='Success - Check box is checked']"));
        if(!successCheckbox.isDisplayed()){
            System.out.println("Success check box is checked message is not displayed, Verification PASSED!!!");
        }else{
            System.out.println("Success check box is checked message is displayed, Verification FAILED!!!");
        }
        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
            WebElement singleCheckBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        singleCheckBox.click();

        // 5.Verify	“Success	–Check	box	is	checked”	message	is displayed

        if(successCheckbox.isDisplayed()){
            System.out.println("Success check box is checked message is displayed, Verification PASSED!!!");
        }else{
            System.out.println("Success check box is checked message is not displayed, Verification FAILED!!!");
        }





    }
}
