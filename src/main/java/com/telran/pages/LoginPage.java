package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//input[@id='userName']")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;

    public ProfilePage login(String name, String pwd) {
        typeWithAction(userName, name);
        typeWithAction(password, pwd);
        click(loginBtn);
        return new ProfilePage(wd);
    }

    public LoginPage loginNegativePage(String name, String pwd) {
        typeWithAction(userName, name);
        typeWithAction(password, pwd);
        click(loginBtn);
        return new LoginPage(wd);
    }
}


