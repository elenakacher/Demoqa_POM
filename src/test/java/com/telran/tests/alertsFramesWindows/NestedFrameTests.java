package com.telran.tests.alertsFramesWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.allertsWindows.NestedFramesPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrameTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectAllertsFrameAndWindows();
        new SidePanelPage(wd).selectNestedFrames();
    }

    @Test
    public void handleNestedFrameTests() {
        //new NestedFramesPage(wd).handleNestedFrame();
        Assert.assertTrue(new NestedFramesPage(wd).getChildFrameText().contains("Child"));
    }

    @Test
    public void switchToParentFrameTest() {
        new NestedFramesPage(wd).switchToPatentFrame();
    }

}
