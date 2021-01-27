package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {
    //TC #2: Selecting state from State dropdown and verifying result


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to http://practice.cybertekschool.com/dropdown

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
     @Test
    public void test2_verifyStateDropDown() throws InterruptedException {
         Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

         //3. Select Illinois
         stateDropdown.selectByVisibleText("Illinois");

         //4. Select Virginia
         Thread.sleep(1000);
         stateDropdown.selectByValue("VA");

         //5. Select California
         Thread.sleep(1000);
         stateDropdown.selectByIndex(5);

         //6. Verify final selected option is California.
         String expectedOption = "California";

         String actualOption = stateDropdown.getFirstSelectedOption().getText();

         Assert.assertEquals(actualOption, expectedOption, "Final selected options is not as expected");

         //Use all Select options. (visible text, value, index)
     }

    @Test
     public void test3_date_dropdown_verification() throws InterruptedException {

        //we need to locate all the dropdown
        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number
         Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
         Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
         Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

         //3. Select “December 1st, 1922” and verify it is selected.
         Thread.sleep(1000);
         yearDropdown.selectByVisibleText("1922");

         Thread.sleep(1000);
         monthDropdown.selectByValue("11");

         Thread.sleep(1000);
         dayDropdown.selectByIndex(0);

         // creating expected values
         String expectedYear = "1922";
         String expectedMonth = "December";
         String expectedDay = "1";

         // getting our actual values from browser
         String actualYear = yearDropdown.getFirstSelectedOption().getText();
         String actualMonth = monthDropdown.getFirstSelectedOption().getText();
         String actualDay = dayDropdown.getFirstSelectedOption().getText();

         // creating assertions to compare actual & expected values

         Assert.assertTrue(actualYear.equals(expectedYear),"Actual year is not equals to expected year");

         Assert.assertTrue(actualMonth.equals(expectedMonth));

         Assert.assertEquals(actualDay,expectedDay);

     }

    @Test
    public void test4_multiple_select_dropdown(){
        //TC #4: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        //3. Select all the options from multiple select dropdown.

        //locating dropdown
        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

        //loop through the list and click each option
        for(WebElement eachOption : allOptions){
            eachOption.click();

            //4. Print out all selected values.
            System.out.println("Selected: " + eachOption.getText());

            //verifying each option is selected
            Assert.assertTrue(eachOption.isSelected(), "The option " + eachOption.getText() + " is not selected");
        }

        //5. Deselect all values.
       multipleSelectDropdown.deselectAll();
        for (WebElement each : allOptions) {
            //Assert.assertTrue(!each.isSelected());

            //Assert.assertFalse method is expecting "false" boolean value to pass the test
            // if expected result is negative better to use this method
            Assert.assertFalse(each.isSelected());
        }


    }
     @AfterMethod
    public void tearDowMethod() throws InterruptedException {
        //additional 5 second before closing the browser
        Thread.sleep(5000);

        driver.close();
     }

}
