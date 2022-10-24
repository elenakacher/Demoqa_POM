package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import com.telran.pages.widgets.SelectMenuPage;
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

    @Test
    public void clickOnMultiSelectDropDownTest(){
        new SelectMenuPage(wd).clickOnMultiSelectDropDown("Green").deselect()
                .clickOnMultiSelectDropDown1("Red", "Blue", "Green");
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(wd).clickOnStandardMultiSelect();
    }

    @Test
    public void selectValueTest() {
        new SelectMenuPage(wd).clickOnSelectValue("Another root option");
    }

    @Test
    public void inputValueTest() {
        new SelectMenuPage(wd).clickOnInputValue("A root");
    }

    @Test
    public void selectOneTest() {
        new SelectMenuPage(wd).clickOnSelectOne("Mr.");
    }

    @Test
    public void inputOneTest() {
        new SelectMenuPage(wd).clickOnInputOne("Mrs");
    }

}
