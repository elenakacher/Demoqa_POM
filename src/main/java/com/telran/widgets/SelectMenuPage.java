package com.telran.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage chooseOldSelectMenu(String text) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(text);
        System.out.println(select.getFirstSelectedOption().getText() + " <-- It is first");

        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++){
            System.out.println(options.get(i).getText());
        }
        return this;
    }

    //(//div[@class=' css-1hwfws3'])[3]
    @FindBy(xpath = "//div[.='Select...']")
    WebElement multiSelectDropDown;

    @FindBy(xpath = "//html")
    WebElement spase;

    public SelectMenuPage clickOnMultiSelectDropDown(String text) {
        click(multiSelectDropDown);
        wd.findElement(By.xpath(String.format("//div[text()='%s']", text))).click();
        pause(500);
        //%s - String, %d - integer
        click(spase);
        return this;
    }

    @FindBy (css = ".css-xb97g8")
    WebElement deselect;

    public SelectMenuPage deselect() {
        click(deselect);
        return this;
    }

    @FindBy (id = "react-select-4-input")
    WebElement selectInputDropDown;

    public SelectMenuPage clickOnMultiSelectDropDown1(String text1, String text2, String text3) {
        selectInputDropDown.sendKeys(text1);
        selectInputDropDown.sendKeys(Keys.ENTER);
        selectInputDropDown.sendKeys(text2);
        selectInputDropDown.sendKeys(Keys.ENTER);
        selectInputDropDown.sendKeys(text3);
        selectInputDropDown.sendKeys(Keys.ENTER);
        click(spase);
        return this;
    }

    @FindBy (id = "cars")
    WebElement standardMultiSelect;

    public SelectMenuPage clickOnStandardMultiSelect() {
        Select multi = new Select(standardMultiSelect);
        if (multi.isMultiple()){
            multi.selectByIndex(0);
            multi.selectByIndex(1);
            multi.selectByIndex(2);
            multi.selectByIndex(3);
        }
        List<WebElement> options = multi.getAllSelectedOptions();
        for (WebElement el: options) {
            System.out.println(el.getText() + "<-- multi");

        }

        return this;
    }
}
