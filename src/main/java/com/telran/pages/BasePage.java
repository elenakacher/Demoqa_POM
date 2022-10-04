package com.telran.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver wd;

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

}
