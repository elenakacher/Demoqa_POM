package com.telran.tests;

import com.telran.JSExecutor;
import com.telran.data.UserData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import org.testng.annotations.Test;

public class JSTests extends TestBase {

    @Test
    public void typeAndClickWithJSTest() {
        new HomePage(wd).selectElements();
        new SidePanelPage(wd).selectTextBox();
        new JSExecutor(wd).enterDataWithJS(UserData.USER_NAME, UserData.USER_EMAIL).clickOnSubmitWithJS();
    }

    @Test
    public void checkBoxWithJSTest() {
        new HomePage(wd).selectForms();
        new SidePanelPage(wd).selectPracticeForm();
        new JSExecutor(wd).checkBoxWithJS().getTitlePageAndURLWithJS();
    }
}
