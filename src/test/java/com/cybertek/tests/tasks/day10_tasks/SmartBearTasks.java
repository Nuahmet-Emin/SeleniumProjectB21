package com.cybertek.tests.tasks.day10_tasks;

import com.cybertek.pages.SmartBear;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBearTasks {

    @Test
    public void smartBear_WrongPassword(){
        //TC #1: SmartBear negative test case scenario : Wrong password
        //1. Go to:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBear smartBear = new SmartBear();
        //2. Enter correct username
        smartBear.inputUserName.sendKeys("tester");

        //3. Enter incorrect password
        smartBear.inputPassword.sendKeys("abcd");
        smartBear.loginButton.click();

        //4. Verify error message is displayed
        Assert.assertTrue( smartBear.invalidLoginMessage.isDisplayed());
    }

    @Test
    public void wrongUsername(){
        //TC #2: SmartBear negative test case scenario : Wrong username
        //1. Go to:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //2. Enter incorrect username
        //3. Enter correct password
        //4. Verify error message is displayed

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBear smartBear = new SmartBear();

        smartBear.inputUserName.sendKeys("abc");

        smartBear.inputPassword.sendKeys("test");

        smartBear.loginButton.click();

       Assert.assertTrue(smartBear.invalidLoginMessage.isDisplayed());
    }


}
/*


TC #3: SmartBear login method creation in POM
1. Create Login Utility method for SmartBear application
2. Store it in appropriate location
3. Call it in a test to make sure it is working as expected.
Note: Follow POM Design Pattern
 */