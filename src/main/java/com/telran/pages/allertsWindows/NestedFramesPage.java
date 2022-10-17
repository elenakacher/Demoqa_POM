package com.telran.pages.allertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver wd) {
        super(wd);
    }

    @FindBy (tagName = "iframe")
    List<WebElement> nestedFrame;

    @FindBy (id = "frame1")
    WebElement frame1;

    @FindBy (tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrame() {
        int countIframes = nestedFrame.size();
        System.out.println("Number of iframes on the page: " + countIframes);
        // switch to frame1
        //number of frames on a Frame1
        //switch to child iframe
        wd.switchTo().frame(frame1);
        int countIFramesInFrame1 = nestedFrame.size();
        System.out.println("Number of iframes inside Frame1: " + countIFramesInFrame1);
        wd.switchTo().frame(0);
        String frame2Text = body.getText();
        System.out.println("Frame2 is " + frame2Text);
        return this;
    }

    public String getChildFrameText() {
        wd.switchTo().frame(frame1);
        wd.switchTo().frame(0);
        return body.getText();

    }

    public NestedFramesPage switchToPatentFrame() {
        wd.switchTo().frame(frame1);
        wd.switchTo().frame(0);
        wd.switchTo().parentFrame();
        String frameParentText = body.getText();
        System.out.println("Frame1 is " + frameParentText);
        return this;
    }
}
