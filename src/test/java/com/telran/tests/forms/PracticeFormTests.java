package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectForms();
        new SidePanelPage(wd).selectPracticeForm();
    }

    @Test
    public void createNewStudentTest() {
       new PracticeFormPage(wd).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
               StudentData.EMAIL, StudentData.MOBILE, StudentData.CURRENT_ADDRESS);
       new PracticeFormPage(wd).selectGender(StudentData.GENDER)
                .typeOfDate(StudentData.DATE_OF_BIRTH)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .upLoadFile(StudentData.PICTURE_PATH)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY);

       new PracticeFormPage(wd).clickSubmitButton();

       Assert.assertTrue(new PracticeFormPage(wd).getStudentNameText().contains("Tom Tailor"));
    }

}
