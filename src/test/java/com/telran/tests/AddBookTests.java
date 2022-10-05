package com.telran.tests;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectBookStoreApp();
        new BookStorePage(wd).clickOnLoginButton();
        new LoginPage(wd).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }

    @Test
    public void addBookForLoginUserPositiveTest() {
        new BookStorePage(wd).typeInSearchBookInput(BookData.BOOK_NAME).clickOnBookTitleLink()
                .clickOnAddBookButton().acceptAlert();
       // Assert.assertTrue(new BookStorePage(wd).takeNameOfBook().contains(BookData.BOOK_NAME));
        new SidePanelPage(wd).selectProfile();
        Assert.assertTrue(new BookStorePage(wd).takeNameOfBook().contains("Git"));
    }

    @AfterMethod
    public void deleteBookFromCollection() {
        new ProfilePage(wd).deleteBook();
    }

}
