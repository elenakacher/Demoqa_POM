package com.telran.tests;

import com.telran.data.UserData;
import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.pages.LoginPage;
import com.telran.pages.ProfilePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectBookStoreApp();
        new BookStorePage(wd).clickOnLoginButton();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(wd).login(UserData.USER_NAME, UserData.USER_PASSWORD);
        new ProfilePage(wd).verifyUserName(UserData.USER_NAME);
    }

    @AfterMethod
    public void logOut() {
        new ProfilePage(wd).logOut();
    }
}
