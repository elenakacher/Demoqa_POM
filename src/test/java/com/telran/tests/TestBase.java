package com.telran.tests;

import com.telran.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver wd;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.get("https://demoqa.com");
        wd.manage().window().maximize();
        //JavascriptExecutor js = (JavascriptExecutor) wd;
        //js.executeScript("window.resizeTo(500, 1024)");
        //Dimension dimension = new Dimension(700, 1024);
        //wd.manage().window().setSize(dimension);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod (enabled = false)
    public void tierDown () {
        wd.quit();
    }

    @BeforeMethod
    public void startTest(Method m) {
        logger.info("Test start. Method " + m.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: test method " + result.getMethod().getMethodName());
            new BasePage(wd).takeScreenshot();
        }
    }

}
