package com.telran.pages;

import com.telran.pages.bookstore.BookStorePage;
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

    @FindBy(xpath = "//div[@class = 'category-cards']/div[1]")
    WebElement elements;

    public SidePanelPage selectElements() {
        click(elements);
        return new SidePanelPage(wd);
    }

    @FindBy(xpath = "//div[@class = 'category-cards']/div[4]")
    WebElement widgets;

    public SidePanelPage selectWidgets() {
        clickWithJSExecutor(widgets, 0, 300);
        return new SidePanelPage(wd);
    }

    @FindBy(xpath = "//div[@class = 'category-cards']/div[2]")
    WebElement forms;

    public SidePanelPage selectForms() {
        click(forms);
        return new SidePanelPage(wd);
    }
}
