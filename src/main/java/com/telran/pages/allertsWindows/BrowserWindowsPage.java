package com.telran.pages.allertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id="tabButton")
    WebElement tabBtn;
    public BrowserWindowsPage clickOnNewTabButton() {
        click(tabBtn);
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement textOnPage;

    public String getTextFromNewPage() {
        return textOnPage.getText();
    }

    @FindBy(id="windowButton")
    WebElement windowBtn;

    public BrowserWindowsPage clickOnNewWindowButton() {
        click(windowBtn);
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement textOnWindow;

    public String getTextFromNewWindow() {
        return textOnWindow.getText();
    }

    @FindBy(id="messageWindowButton")
    WebElement windowMsgBtn;

    public BrowserWindowsPage clickOnNewWindowWithTextButton() {
        click(windowMsgBtn);
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        return this;
    }

    @FindBy(className="textfield998251889")
    WebElement textOnWindowThisMsg;

    public String  getTextFromNewWindowWithText() {
        return textOnWindowThisMsg.getText();
    }
}
