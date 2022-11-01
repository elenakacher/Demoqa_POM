package com.telran.pages;

import com.telran.pages.allertsWindows.AlertsPage;
import com.telran.pages.allertsWindows.BrowserWindowsPage;
import com.telran.pages.allertsWindows.FramesPage;
import com.telran.pages.allertsWindows.NestedFramesPage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.pages.elements.*;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.pages.interactions.DragAndDropPage;
import com.telran.pages.widgets.MenuPage;
import com.telran.pages.widgets.SelectMenuPage;
import com.telran.pages.widgets.SliderPage;
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

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage selectMenuItem() {
        clickWithJSExecutor(menu, 0, 300);
        return new MenuPage(wd);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJSExecutor(slider, 0, 300);
        return new SliderPage(wd);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(wd);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brockenLinksImages;

    public BrockenLinksImagesPage selectBrockenLinksImages() {
        brockenLinksImages.click();
        return new BrockenLinksImagesPage(wd);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;

    public LinksPage selectLinks() {
        links.click();
        return new LinksPage(wd);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadAndDownload;


    public UploadAndDownloadPage selectUploadAndDownload() {
        clickWithJSExecutor(uploadAndDownload, 0, 400);
        return new UploadAndDownloadPage(wd);
    }
}
