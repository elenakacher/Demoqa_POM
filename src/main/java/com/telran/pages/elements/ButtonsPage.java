package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id="doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonsPage doubleClick() {
        Actions actions = new Actions(wd);
        actions.doubleClick(doubleClickBtn).perform();
        return this;
    }

    @FindBy(id="doubleClickMessage")
    WebElement doubleClickMessage;

    public String getConfirmMessageDoubleClickButton() {
        return doubleClickMessage.getText();
    }

    @FindBy(id="rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClick() {
        Actions actions = new Actions(wd);
        actions.contextClick(rightClickBtn).perform();
        pause(1000);
        return this;
    }
     @FindBy(id="rightClickMessage")
    WebElement rightClickMessage;

    public String getConfirmMessageRightClickButton() {
        return rightClickMessage.getText();
    }

    @FindBy(xpath="//button[.='Click Me']")
    WebElement clickMeBtn;

    public ButtonsPage clickMe() {
        click(clickMeBtn);
        return this;

    }

    @FindBy(id="dynamicClickMessage")
    WebElement dynamicClickMessage;

    public String getConfirmMessageClickMeButton() {
        return dynamicClickMessage.getText();
    }
}
