package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement menu2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subMenu2;

    @FindBy(xpath = "//*[.='Sub Sub Item 2']")
    WebElement subSubMenu2;

    public MenuPage selectSubMenu() {
        hideAd();
        hideFooter();
        Actions actions = new Actions(wd);
        //mouse hover menu options 'Main Item 2'
        actions.moveToElement(menu2).perform();
        actions.moveToElement(subMenu2).perform();
        pause(1000);
        actions.moveToElement(subSubMenu2).perform();
        click(subSubMenu2);
        return this;
    }
}
