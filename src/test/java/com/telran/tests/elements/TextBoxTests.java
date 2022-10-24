package com.telran.tests.elements;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.ButtonsPage;
import com.telran.pages.elements.TextBoxPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectElements();
        new SidePanelPage(wd).selectTextBox();
    }

    @Test(dataProvider = "usingGuestFile", dataProviderClass = DataProviders.class)
    public void createNewGuestTest(String FullName, String email, String currentAddress,
        String permanentAddress) {
        new TextBoxPage(wd).createNewGuest(FullName, email, currentAddress, permanentAddress);
        Assert.assertTrue(new TextBoxPage(wd).getGuestDaten().contains("Permananet Address"));

        }
}

