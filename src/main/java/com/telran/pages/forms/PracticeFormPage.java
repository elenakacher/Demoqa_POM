package com.telran.pages.forms;

import com.telran.data.StudentData;
import com.telran.data.StudentDataDP;
import com.telran.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.Collection;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//label[@for = 'gender-radio-1']")
    WebElement male;

    @FindBy(xpath = "//label[@for = 'gender-radio-2']")
    WebElement female;

    @FindBy(xpath = "//label[@for = 'gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else click(other);
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    public PracticeFormPage typeOfDate(String birth) {
        click(dateOfBirth);

        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);
        if (os.startsWith("Mac")) {
            dateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirth.sendKeys(birth);
        dateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectInput, subjects[i]);
                subjectInput.sendKeys(Keys.ENTER);
            }

        }
        return this;
    }

    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage chooseHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
            return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage upLoadFile(String picturePath) {
        uploadPicture.sendKeys(picturePath);
        return this;
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastnameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "userNumber")
    WebElement userNumberField;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    public PracticeFormPage enterPersonalData(String firstName, String lastName, String email,
                                  String mobile, String currentAddress) {
        type(firstNameField, firstName);
        type(lastnameField, lastName);
        type(userEmailField, email);
        type(userNumberField, mobile);
        type(currentAddressField, currentAddress);
        return this;
    }

    @FindBy(xpath = "//div[.='Select State']")
    WebElement selectState;

    public PracticeFormPage enterState(String state) {
        clickWithJSExecutor(selectState, 0, 300);
        wd.findElement(By.xpath(String.format("//div[text()='%s']", state))).click();
        pause(1000);
        return this;
    }

    @FindBy(xpath = "//div[.='Select City']")
    WebElement selectCity;

    public PracticeFormPage enterCity(String city) {
        clickWithJSExecutor(selectCity, 0, 300);
        wd.findElement(By.xpath(String.format("//div[text()='%s']", city))).click();
        pause(1000);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage clickSubmitButton() {
        clickWithRectangle(submit, 2, 3);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    public String getModalTitle() {
        return modalTitle.getText();
    }

    public PracticeFormPage hideIframes() {
        hideAd();
        hideFooter();
        return this;
    }

    @FindBy(id = "closeLargeModal")
    WebElement closeLargeModal;

    public PracticeFormPage closeModal() {
        closeBanner();
        closeLargeModal.click();
        return this;
    }

    public void closeBanner() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.getElementById('close-fixedban').style.display='none'\n");
    }

    @FindBy (css = ".react-datepicker__month-select")
    WebElement month;

    @FindBy (css = ".react-datepicker__year-select")
    WebElement year;

    public PracticeFormPage chooseDate(String m, String y, String d) {
        click(dateOfBirth);
        //HTML <select> - обязательное условие
        Select select = new Select(month);
        select.selectByVisibleText(m);

        Select select1 = new Select(year);
        select1.selectByVisibleText(y);

        wd.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + d + "']")).click();

        return this;
    }

    public PracticeFormPage enterStudentData(StudentDataDP studentDataDP) {
        type(firstNameField, studentDataDP.getFirstName());
        type(lastnameField, studentDataDP.getLastName());
        type(userEmailField, studentDataDP.getEmail());
        type(userNumberField, studentDataDP.getMobile());
        type(currentAddressField, studentDataDP.getAddress());
        return this;
    }
}
