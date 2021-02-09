package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad7Page {

    public DynamicLoad7Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // #1
    @FindBy(id="alert")
    public WebElement infoMessage;

    // #2
    @FindBy(xpath = "//img[@alt='square pants']")
    public WebElement spongeBobImage;
}
