package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//*[.='Book Store Application']")
    WebElement bookStoreAppTitle;

    public BookStorePage selectBookStoreApp() {
        clickWithJSExecutor(bookStoreAppTitle, 0, 300);
        //clickWithAction(bookStoreAppTitle);
        return new BookStorePage(wd);
    }

    //@FindBy(xpath = "//h5[text() = 'Alerts, Frame & Windows']")
    @FindBy(xpath = "//div[@class = 'category-cards']/div[3]")
    WebElement allertsFrameWindows;

    public SidePanelPage selectAllertsFrameAndWindows() {
        click(allertsFrameWindows);
        return new SidePanelPage(wd);
    }
}
