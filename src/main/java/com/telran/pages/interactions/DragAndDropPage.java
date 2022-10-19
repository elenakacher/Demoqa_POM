package com.telran.pages.interactions;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        hideAd();
        hideFooter();

        Actions actions = new Actions(wd);
        pause(1000);
        actions.dragAndDrop(dragMe, dropHere).build().perform();

        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!"))
            System.out.println("Pass: Source is dropped to target as expected");
        else System.out.println("FAIL: Source couldn't be dropped to target as expected");
        return this;
    }

    public DragAndDropPage dragAndDropBy() {
        hideAd();
        hideFooter();

        Actions actions = new Actions(wd);
        //from
        int xOffset = dragMe.getLocation().getX();
        int yOffset = dragMe.getLocation().getY();
        System.out.println("xOffsetFrom --> " + xOffset + "; yOffsetFrom --> " + yOffset);
        //to
        int xOffsetTo = dropHere.getLocation().getX();
        int yOffsetTo = dropHere.getLocation().getY();
        System.out.println("xOffsetTo --> " + xOffsetTo + "; yOffsetTo --> " + yOffsetTo);

        xOffsetTo = (xOffsetTo - xOffset) + 30;
        yOffsetTo = (yOffsetTo - yOffset) + 60;
        actions.dragAndDropBy(dragMe, xOffsetTo, yOffsetTo).perform();
        return this;
    }
}
