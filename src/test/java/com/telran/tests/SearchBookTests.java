package com.telran.tests;

import com.telran.data.BookData;
import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectBookStoreApp();
    }

    @Test
    public void searchBookForGastPositiveTest() {
        new BookStorePage(wd).typeInSearchBookInput(BookData.BOOK_NAME);
        Assert.assertTrue(new BookStorePage(wd).takeNameOfBook().contains(BookData.BOOK_NAME));
    }
}
