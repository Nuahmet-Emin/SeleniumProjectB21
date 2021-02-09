package com.cybertek.tests.day11_Review;

import com.cybertek.pages.SignUpPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecutorPractices {


    @Test
    public void fill_form_using_jsexecutor(){


        Driver.getDriver().get("http://practice.cybertekschool.com/sign_up");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        SignUpPage signUpPage = new SignUpPage();

        js.executeScript("arguments[0].setAttribute('value','jane doe')", signUpPage.inputFullName);

        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].setAttribute('value','something@gmail.com')", signUpPage.inputEmail);

        BrowserUtils.sleep(1);
        js.executeScript("argument[0].click()", signUpPage.signUpButton);


    }

public void opening_tabs_jsExecutor(){
        Driver.getDriver().get("https://www.amazon.com");

    ((JavascriptExecutor)Driver.getDriver()).executeScript("");
}


}
