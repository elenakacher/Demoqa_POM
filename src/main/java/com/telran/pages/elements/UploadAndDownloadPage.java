package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadAndDownloadPage extends BasePage {

    public UploadAndDownloadPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadAndDownloadPage performEventKeyUsingRobot() throws AWTException {
        hideAd();
        hideFooter();
        pause(1000);
        // click on uploadFileButton
        clickWithRectangle(uploadFile, 12, 2);
        // create object of Robot class
        Robot robot = new Robot();
        // code to enter D1.txt
        // press Shift key
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        // press d, it gets typed as upper case D as Shift key pressed
        robot.keyPress(KeyEvent.VK_D);
        // release Shift key to release upper case effect
        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_ENTER);

        // press ENTER to close popup
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public String getPath() {
        return uploadedFilePath.getText();
    }

    public UploadAndDownloadPage performMouseEventUsingRobot() {
        hideAd();
        hideFooter();
        pause(1000);

        clickWithRectangle(uploadFile, 12, 2);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // find x and y coordinates to pass to mouseMove mthod
        //1. Get the size of the current window
        //2. Dimension class
        Dimension i = wd.manage().window().getSize();
        System.out.println("x --> " + i.getWidth() + " y --> " + i.getHeight());

        //3. get the hwigth and the width of the screen

        int x = i.getWidth() / 4 + 600;
        int y = i.getWidth() / 10 + 300;

        robot.mouseMove(x,y);
        pause(2000);
        //click on Left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(5000);
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }
}
