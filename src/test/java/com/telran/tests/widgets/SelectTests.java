package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import com.telran.widgets.SelectMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectWidgets();
        new SidePanelPage(wd).getSelectMenu();
    }

    @Test
    public void oldStyleSelectMenuTest() {
        new SelectMenuPage(wd).chooseOldSelectMenu("Yellow");
    }
}
