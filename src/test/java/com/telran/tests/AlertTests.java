package com.telran.tests;

import com.telran.pages.AlertsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{
     @BeforeMethod
    public void ensurePrecondition() {
         new HomePage(wd).selectAllertsFrameAndWindows();
         new SidePanelPage(wd).selectAllerts();
     }

     @Test(priority = 0) //Button1
    public void clickButtonToSeeAlert() {
        new AlertsPage(wd).selectButtonToSeeAlert().acceptAlert();
     }

     @Test(priority = 1)  //Button2
    public void alertWaitTest() {
     new AlertsPage(wd).acceptTimerAlert();
     }

     @Test(priority = 2)  //Button3
    public void ConfirmButtonTest() {
         new AlertsPage(wd).chooseConfirmButton("Cancel");
         Assert.assertTrue(new AlertsPage(wd).getConfirmresult().contains("Cancel"));
     }

     @Test(priority = 3)  //Button4
    public void alertSendTextTest() {
         new AlertsPage(wd).sendTextToAlert("Hello World!");
         Assert.assertTrue(new AlertsPage(wd).getConfirmMessageResult().contains("Hello"));
     }
}
