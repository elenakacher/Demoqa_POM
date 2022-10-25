package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = ".range-slider.range-slider--primary")
    WebElement slider;

    @FindBy(css = ".range-slider__wrap")
    WebElement sliderValue;

    public SliderPage moveSliderInHorizontalDirection() {
        Actions actions = new Actions(wd);
        //move mouse to x offset 50
        int width = slider.getSize().width;
        actions.moveToElement(slider, width/10, 0).click().perform();
        return this;
    }

    public boolean isSliderValueDisplayed(int value) {
        should(sliderValue, 10);
        return wd.findElement(By.cssSelector("#sliderValue[value='" + value + "']")).isDisplayed();
    }

    public void should(WebElement element, int time) {
        new WebDriverWait(wd, time).until(ExpectedConditions.visibilityOf(element));
    }
}
