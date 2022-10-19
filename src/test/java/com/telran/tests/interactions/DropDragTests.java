package com.telran.tests.interactions;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.interactions.DragAndDropPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectInteractions();
        new SidePanelPage(wd).selectDroppable();
    }

    @Test
    public void dragMeTest() {
        new DragAndDropPage(wd).actionDragMe();
    }

    @Test
    public void droppableByTest() {
        new DragAndDropPage(wd).dragAndDropBy();
    }
}
