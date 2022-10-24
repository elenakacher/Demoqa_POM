package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = ".range-slider.range-slider--primary")
    WebElement slider;

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage moveSliderInHorizontalDirection() {
        Actions actions = new Actions(wd);
        //move mouse to x offset 50
        int x = slider.getSize().width;
        actions.dragAndDropBy(slider, x, 0).perform();
        System.out.println(x);
        //click(slider);
        return this;
    }
}
