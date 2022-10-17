package com.telran.pages.forms;

import com.telran.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
            clickWithJSExecutor(male, 0, 600);
        } else if (gender.equals("Female")) {
            clickWithJSExecutor(female, 0, 600);
        } else clickWithJSExecutor(other, 0, 600);
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
                typeWithJSExecutor(subjectInput, subjects[i], 0, 600);
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
                clickWithJSExecutor(sports, 0, 700);
            }
            if (hobbies[i].equals("Reading")) {
                clickWithJSExecutor(reading, 0, 700);
            }
            if (hobbies[i].equals("Music")) {
                clickWithJSExecutor(music, 0, 700);
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
        typeWithJSExecutor(firstNameField, firstName, 0, 700);
        typeWithJSExecutor(lastnameField, lastName, 0, 700);
        typeWithJSExecutor(userEmailField, email, 0, 700);
        typeWithJSExecutor(userNumberField, mobile, 0, 700);
        typeWithJSExecutor(currentAddressField, currentAddress, 0, 700);
        return this;
    }

    @FindBy(xpath = "//div[.='Select State']")
    WebElement selectState;

    public PracticeFormPage enterState(String state) {
        clickWithJSExecutor(selectState, 0, 1000);
        WebElement element = wd.findElement(By.xpath(String.format("//div[text()='%s']", state)));
        clickWithJSExecutor(element, 0, 1000);
        pause(1000);
        return this;
    }

    @FindBy(xpath = "//div[.='Select City']")
    WebElement selectCity;

    public PracticeFormPage enterCity(String city) {
        clickWithJSExecutor(selectCity, 0, 1000);
        WebElement element = wd.findElement(By.xpath(String.format("//div[text()='%s']", city)));
        clickWithJSExecutor(element, 0, 1000);
        pause(1000);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage clickSubmitButton() {
        clickWithJSExecutor(submit, 0, 1000);
        return this;
    }

    @FindBy(xpath = "//td[.='Tom Tailor']")
    WebElement getfirstNameText;

    public String getStudentNameText() {
        return getfirstNameText.getText();
    }
}
