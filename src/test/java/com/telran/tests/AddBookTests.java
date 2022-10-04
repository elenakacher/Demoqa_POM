package com.telran.tests;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.pages.LoginPage;
import org.testng.Assert;
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
    public void searchBookForLoginUserPositiveTest() {
        new BookStorePage(wd).typeInSearchBookInput(BookData.BOOK_NAME);
        Assert.assertTrue(new BookStorePage(wd).takeNameOfBook().contains(BookData.BOOK_NAME));
    }
}
