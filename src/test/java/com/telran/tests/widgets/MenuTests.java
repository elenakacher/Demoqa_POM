package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.SliderPage;
import com.telran.tests.TestBase;
import com.telran.pages.widgets.MenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(wd).selectWidgets();
    }

    @Test
    public void manuTest() {
        new SidePanelPage(wd).selectMenuItem();
        new MenuPage(wd).selectSubMenu();
    }

    @Test
    public void sliderTest() {
        new SidePanelPage(wd).selectSlider();
        new SliderPage(wd).moveSliderInHorizontalDirection();
    }
}
