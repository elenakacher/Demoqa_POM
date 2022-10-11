package com.telran.tests.alertsWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.allertsWindows.FramesPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectAllertsFrameAndWindows();
        new SidePanelPage(wd).selectFrame();
    }

    @Test
    public void framesTest() {
        new FramesPage(wd).returnListOfFrames();
    }

    @Test
    public void switchToFrameByIndexTest() {
        new FramesPage(wd).switchToFrameByIndex(3);
    }

    @Test
    public void switchToFrameByIdTest() {
        new FramesPage(wd).switchToFrameById();
        Assert.assertTrue(new FramesPage(wd).getframeText().contains("This is"));
    }
}
