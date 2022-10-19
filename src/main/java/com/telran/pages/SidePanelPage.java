package com.telran.pages;

import com.telran.pages.allertsWindows.AlertsPage;
import com.telran.pages.allertsWindows.BrowserWindowsPage;
import com.telran.pages.allertsWindows.FramesPage;
import com.telran.pages.allertsWindows.NestedFramesPage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.pages.elements.ButtonsPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.pages.interactions.DragAndDropPage;
import com.telran.widgets.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends BasePage {
    public SidePanelPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = ".show #item-3")
    WebElement profileButton;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profileButton, 0, 300);
        return new ProfilePage(wd);
    }

    @FindBy(xpath = "//span[. = 'Alerts']")
    WebElement allertsBtn;

    public AlertsPage selectAllerts() {
        click(allertsBtn);
        return new AlertsPage(wd);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsBtn;

    public BrowserWindowsPage selectBrowserWindows() {
        click(browserWindowsBtn);
        return new BrowserWindowsPage(wd);
    }

    @FindBy(xpath = "//span[. = 'Buttons']")
    WebElement buttonsBtn;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttonsBtn, 0, 400);
        return new ButtonsPage(wd);
    }

    @FindBy(xpath = "//span[. = 'Select Menu']")
    WebElement selectMenuBtn;

    public SelectMenuPage getSelectMenu() {
        clickWithJSExecutor(selectMenuBtn, 0, 500);
        return new SelectMenuPage(wd);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement framesBtn;

    public FramesPage selectFrame() {
        click(framesBtn);
        return new FramesPage(wd);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFramesBtn;

    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFramesBtn, 0, 300);
        return new NestedFramesPage(wd);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceFormBtn;

    public PracticeFormPage selectPracticeForm() {
        click(practiceFormBtn);
        return new PracticeFormPage(wd);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public DragAndDropPage selectDroppable() {
        clickWithJSExecutor(droppable, 0, 400);
        return new DragAndDropPage(wd);
    }
}
