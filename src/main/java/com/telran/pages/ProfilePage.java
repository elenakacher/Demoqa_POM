package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id="userName-value")
    WebElement userNameValue;

    @FindBy(id="submit")
    WebElement logOutBtn;

    public ProfilePage verifyUserName(String userName) {
        if(userNameValue.getText().equalsIgnoreCase(userName)) {
            System.out.println("Correct userName: " + userNameValue.getText());
        } else {
            System.out.println("Incorrect userName: " + userNameValue.getText());
        }
        return this;
    }

    public LoginPage logOut() {
        click(logOutBtn);
        return new LoginPage(wd);
    }

    @FindBy(id="delete-record-undefined")
    List<WebElement> trashList;

    @FindBy(id="closeSmallModal-ok")
    WebElement okBtn;

    public ProfilePage deleteBook() {
        trashList.get(0).click();
        pause(1000);
        click(okBtn);
        pause(1000);
        acceptAlert();
        return this;
    }
}
