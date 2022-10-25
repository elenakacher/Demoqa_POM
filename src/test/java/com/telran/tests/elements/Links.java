package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.BrockenLinksImagesPage;
import com.telran.pages.elements.LinksPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Links extends TestBase {

    @BeforeMethod
    public void EnsurePrecondition() {
        new HomePage(wd).selectElements();
        new SidePanelPage(wd).selectLinks();
    }

    @Test
    public void checkLinksTest() {
        new LinksPage(wd).checkAllLinks().checkBrockenLinks();
        Assert.assertTrue(new LinksPage(wd).getAPIResponsetext("No Content").contains("staus 204"));
    }

}
