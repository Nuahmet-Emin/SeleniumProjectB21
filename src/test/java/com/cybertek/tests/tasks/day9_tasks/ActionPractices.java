package com.cybertek.tests.tasks.day9_tasks;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionPractices {

    @Test
    public void doubleClick(){
        //TC	#16:	Double	ClickTest
        // 1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement doubleClickText= Driver.getDriver().findElement(By.id("demo"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(doubleClickText).perform();

        // 2.Switch	to	iframe.

        // 3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        // 4.Assert:	Text’s	“style”	attribute	value	con
    }

    @Test
    public void dragNDrop(){
        //TC	#16:	Hover	Test
        // 1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement cookiesAcceptButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));

        cookiesAcceptButton.click();

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle,bigCircle).perform();

        // 2.Drag	and	drop	the	small	circle	to	bigger	circle.
        // 3.Assert:	-Text	in	big	circle	changedto:	“You	did	great!

        String expectedText = "You did great!";
        String actualText = bigCircle.getText();
        Assert.assertTrue(actualText.equals(expectedText));
    }

    @Test
    public void contextClickTest(){
        //TC	#17:	Context	Click	–HOMEWORK
        // 1.Go	to	https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        // 2.Right	click	to	the	box.
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();

        BrowserUtils.sleep(2);

        // 3.Alert	will	open.
        Alert alert = Driver.getDriver().switchTo().alert();

        BrowserUtils.sleep(2);

        // 4.Accept	alertNo	assertion	needed	for	this	practice
        alert.accept();
    }


}
