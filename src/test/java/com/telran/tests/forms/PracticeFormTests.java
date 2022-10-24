package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.data.StudentDataDP;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
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
       new PracticeFormPage(wd).hideIframes()
               .enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
               StudentData.EMAIL, StudentData.MOBILE);
       new PracticeFormPage(wd).selectGender(StudentData.GENDER)
               .chooseDate("April", "1989", "12")
                //.typeOfDate(StudentData.DATE_OF_BIRTH)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .upLoadFile(StudentData.PICTURE_PATH)
                .enterAddress(StudentData.CURRENT_ADDRESS)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY)
               .clickSubmitButton();

       Assert.assertTrue(new PracticeFormPage(wd).getModalTitle().contains("Thanks for submitting the form"));

       new PracticeFormPage(wd).closeModal();
    }

    @Test(dataProvider = "createNewStudentFromCSV", dataProviderClass = DataProviders.class)
    public void createNewStudentTestFromCSV(StudentDataDP studentDataDP) {
        new PracticeFormPage(wd).hideIframes().enterStudentData(studentDataDP).clickSubmitButton();
        new PracticeFormPage(wd).selectGender(StudentData.GENDER)
                .chooseHobby(StudentData.HOBBIES)
                .upLoadFile(StudentData.PICTURE_PATH)
                .clickSubmitButton();

        Assert.assertTrue(new PracticeFormPage(wd).getModalTitle().contains("Thanks for submitting the form"));
        new PracticeFormPage(wd).closeModal();
    }

    @Test(dataProvider = "usingFile", dataProviderClass = DataProviders.class)
    public void createNewStudentTestUsingFile(String firstName, String lastName, String email,
                                              String phone, String birthDay, String file,
                                              String address) {
        new PracticeFormPage(wd).hideIframes()
                .enterPersonalData(firstName,lastName, email, phone);
        new PracticeFormPage(wd).selectGender(StudentData.GENDER)
                .typeOfDate(birthDay)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .upLoadFile(file)
                .enterAddress(address)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY)
                .clickSubmitButton();

        Assert.assertTrue(new PracticeFormPage(wd).getModalTitle().contains("Thanks for submitting the form"));
        new PracticeFormPage(wd).closeModal();
    }
}
