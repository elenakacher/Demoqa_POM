package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.ButtonsPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectElements();
        new SidePanelPage(wd).selectButtons();
    }

    @Test
    public void doubleClickTest() {
        new ButtonsPage(wd).doubleClick();
        Assert.assertTrue(new ButtonsPage(wd).getConfirmMessageDoubleClickButton().contains("You have done a double click"));

    }

    @Test
    public void rightClickTest() {
        new ButtonsPage(wd).rightClick();
        Assert.assertTrue(new ButtonsPage(wd).getConfirmMessageRightClickButton().contains("You have done a right click"));
    }

    @Test
    public void clickMeTest() {
        new ButtonsPage(wd).clickMe();
        Assert.assertTrue(new ButtonsPage(wd).getConfirmMessageClickMeButton().contains("dynamic click"));
    }
}
