package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertsPage extends BasePage{
    public AlertsPage(WebDriver wd) {super(wd);}

    //Button1
    @FindBy(id="alertButton")
    WebElement seeAlertBtn;

    public AlertsPage selectButtonToSeeAlert() {
        click(seeAlertBtn);
        pause(500);
        return this;
    }

    //Button2
    @FindBy(id="timerAlertButton")
    WebElement timerAlertBtn;


    public AlertsPage acceptTimerAlert() {
        click(timerAlertBtn);
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    //Button3
    @FindBy(id="confirmButton")
    WebElement confirmBtn;

    public AlertsPage chooseConfirmButton(String text) {
        click(confirmBtn);
        if(text != null && text.equals("OK")) {
            wd.switchTo().alert().accept();
        } else if (text != null && text.equals("Cancel")){
            wd.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public String getConfirmresult() {
        return confirmResult.getText();
    }

    //Button4
    @FindBy(id="promtButton")
    WebElement promtBtn;

    public AlertsPage sendTextToAlert(String message) {
        clickWithJSExecutor(promtBtn, 0, 200);
        pause(500);
        if(message != null)
            wd.switchTo().alert().sendKeys(message);
        pause(500);
        wd.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement confirmMessageResult;

    public String getConfirmMessageResult() {
        return confirmMessageResult.getText();
    }
}
