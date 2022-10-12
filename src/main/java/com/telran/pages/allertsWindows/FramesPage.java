package com.telran.pages.allertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver wd) {
        super(wd);
    }

    @FindBy (tagName = "iframe")
    List<WebElement> frames;

    public FramesPage returnListOfFrames() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of Frames: " + numberOfFrames);
        System.out.println("Number of Frames " + frames.size());
        return this;
    }

    @FindBy (id = "sampleHeading")
    WebElement textInFrame;

    public FramesPage switchToFrameByIndex(int index) {
        wd.switchTo().frame(index);
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String textFrame = textInFrame.getText();
        System.out.println(textFrame);
        Assert.assertEquals(textFrame, "This is a sample page");
        return this;
    }

    @FindBy (id = "frame1")
    WebElement frame1;

    @FindBy(id="frame2")
    WebElement frame2;

    public FramesPage switchToFrameById() {
        wd.switchTo().frame(frame2);
        return this;
    }

    public String getframeText() {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        return textInFrame.getText();
    }

}
