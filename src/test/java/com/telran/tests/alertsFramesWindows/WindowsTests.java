package com.telran.tests.alertsFramesWindows;

import com.telran.pages.allertsWindows.BrowserWindowsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectAllertsFrameAndWindows();
        new SidePanelPage(wd).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(wd).clickOnNewTabButton();
        Assert.assertTrue(new BrowserWindowsPage(wd).getTextFromNewPage().contains("sample"));
    }

    @Test
    public void newWindowTest() {
        new BrowserWindowsPage(wd).clickOnNewWindowButton();
        Assert.assertTrue(new BrowserWindowsPage(wd).getTextFromNewWindow().contains("sample"));
    }

    @Test
    public void newWindowWithTextTest() {
        new BrowserWindowsPage(wd).clickOnNewWindowWithTextButton();
       // Assert.assertTrue(new BrowserWindowsPage(wd).getTextFromNewWindowWithText().contains("increases"));
    }
}
