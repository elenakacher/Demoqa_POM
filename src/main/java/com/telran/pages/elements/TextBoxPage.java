package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.Text;

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

    public TextBoxPage keyBoardEvent() {
        // enter username
        type (userNameField, "Sara Brown");
        // enter email
        type(userEmailField, "sara@gm.ua");
        // enter current address
        type(currentAddressField, "Karl-Marx-Allee 12, 07747 Jena");
        // create object of the Action class
        Actions actions = new Actions(wd);
        // select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        // press the tab Key to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        // past the current address in the permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        // System.out.println(currentAddressField.getAttribute("value"));
        // System.out.println(permanentAddressField.getAttribute("value"));
        return this;
    }

    public String getAttribute() {
        return permanentAddressField.getAttribute("value");
    }
}
