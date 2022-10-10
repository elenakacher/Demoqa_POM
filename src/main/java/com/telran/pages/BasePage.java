package com.telran.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class BasePage {

    public WebDriver wd;

    public BasePage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if(text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void typeWithAction(WebElement element, String text) {
        if(text != null) {
            clickWithAction(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithAction(WebElement element) {
        Actions actions = new Actions(wd);
        actions.moveToElement(element).perform();
        element.click();
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();
    }

    public void typeWithJSExecutor(WebElement element, String text, int x, int y) {
        if(text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
