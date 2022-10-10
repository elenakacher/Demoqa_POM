package com.telran.widgets;

import com.telran.pages.BasePage;
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
}
