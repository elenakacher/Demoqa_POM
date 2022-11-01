package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.UploadAndDownloadPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class UploadAndDownloadTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectElements();
        new SidePanelPage(wd).selectUploadAndDownload();
    }

    @Test
    public void robotKeyEventTest() throws AWTException {
        new UploadAndDownloadPage(wd).performEventKeyUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(wd).getPath().contains("D1.txt"));
    }

    @Test
    public void robotMouseEventTest() {
        new UploadAndDownloadPage(wd).performMouseEventUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(wd).getPath().contains("D1.txt"));

    }
}

