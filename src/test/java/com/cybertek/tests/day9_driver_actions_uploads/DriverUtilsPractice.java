package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){
        // Go to google.com
       // Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().get(ConfigurationReader.getProperty("googleUrl"));

        //Search for a value
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String searchValue = "Wooden Spoon";

        searchBox.sendKeys(searchValue + Keys.ENTER);

        // Assert title contains value


        String actualTitle = Driver.getDriver().getTitle();

        // expected --> comes from documentation
        String expectedTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Driver.closeDriver();




    }

}
