package com.telran.pages.allertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public FramesPage switchToFrameByIndex(int index) {
        wd.switchTo().frame(index);
        return this;
    }

    @FindBy (id = "frame1")
    WebElement frame1;

    public FramesPage switchToFrameById() {
        wd.switchTo().frame(frame1);
        wd.switchTo().defaultContent();
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement frameText;

    public String getframeText() {
        wd.switchTo().frame(frame1);
        return frameText.getText();
    }

}
