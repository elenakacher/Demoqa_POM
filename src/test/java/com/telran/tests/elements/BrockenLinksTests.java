package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.BrockenLinksImagesPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrockenLinksTests extends TestBase {

    @BeforeMethod
    public void EnsurePrecondition() {
        new HomePage(wd).selectElements();
        new SidePanelPage(wd).selectBrockenLinksImages();
    }

    @Test
    public void checkBrockenLinksTest() {
        new BrockenLinksImagesPage(wd).checkAllLinks().checkBrockenLinks();
    }

    @Test
    public void checkBrockenImagesTest() {
        new BrockenLinksImagesPage(wd).checkBrockenImages();
    }
}
