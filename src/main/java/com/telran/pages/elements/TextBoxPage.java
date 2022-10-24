package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id="userName")
    WebElement userNameField;

    @FindBy(id="userEmail")
    WebElement userEmailField;

    @FindBy(id="currentAddress")
    WebElement currentAddressField;

    @FindBy(id="permanentAddress")
    WebElement permanentAddressField;

    @FindBy(id="submit")
    WebElement submit;

    public TextBoxPage createNewGuest(String fullName, String email, String currentAddress,
                                         String permanentAddress) {
        hideAd();
        hideFooter();
        type(userNameField, fullName);
        type(userEmailField, email);
        type(currentAddressField, currentAddress);
        type(permanentAddressField, permanentAddress);
        submit.click();
        return this;
    }

    @FindBy(css = ".border.col-md-12.col-sm-12")
    WebElement guestDaten;

    public String getGuestDaten() {
        pause(1000);
        hideAd();
        hideFooter();
        System.out.println(guestDaten.getText());
        return guestDaten.getText();

    }
}
