package com.cybertek.tests.tasks.day4_tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC4_Checkbox_Verification_Section2 {
    public static void main(String[] args) {
        //1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // 3.Verify	“Check	All”	button	text	is	“Check	All”
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@value='Check All']"));
        String checkAllButtonText = checkAllButton.getAttribute("value");

        if(checkAllButtonText.equals("Check All")){
            System.out.println("Check All button text is \"Check All\", verification Passed!!!");
        }else{
            System.out.println("Check All button text is not \"Check All\", verification FAILED!!!");
        }
        // 4.Click	to	“Check	All”	button
        checkAllButton.click();
        // 5.Verify	all	check	boxes	are	checked
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for(WebElement eachBox: checkBoxList){
            if(eachBox.isSelected()){
                System.out.println("Checkbox is selected PASS!");
            }else{
                System.out.println("Checkbox is not selected, FAILED!");
            }
        }
        // 6.Verify	button	text	changed	to	“Uncheck All"
        WebElement uncheckAllButton = driver.findElement(By.xpath("//input[ @id='check1']"));
        String actualUncheckAllButtonText = uncheckAllButton.getAttribute("value");
        if(actualUncheckAllButtonText.equals("Uncheck All")){
            System.out.println("Passed!");
        }else{
            System.out.println("FAILED!");
        }
    }
}
