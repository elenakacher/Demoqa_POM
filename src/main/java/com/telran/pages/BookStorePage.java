package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends BasePage{
    public BookStorePage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage clickOnLoginButton() {
        clickWithAction(loginBtn);
        return new LoginPage(wd);
    }

    @FindBy(xpath = "//input[@placeholder = 'Type to search']")
    WebElement searchField;

    public BookStorePage typeInSearchBookInput(String bookName) {
        type(searchField, bookName);
        return this;
    }

    @FindBy(xpath = "//*[.= 'Git Pocket Guide']")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        return nameOfBook.getText();
    }

    public BookStorePage clickOnBookTitleLink() {
        click(nameOfBook);
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addToYourCollectionButton;

    public BookStorePage clickOnAddBookButton() {
        clickWithJSExecutor(addToYourCollectionButton, 0, 300);
        pause(2000);
        return this;
    }
}



