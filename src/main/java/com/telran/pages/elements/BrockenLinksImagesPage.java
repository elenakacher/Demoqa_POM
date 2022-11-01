package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrockenLinksImagesPage extends BasePage {
    public BrockenLinksImagesPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public BrockenLinksImagesPage checkAllLinks() {
        System.out.println("Total links on the Webpage: " + links.size());
        String url = null;
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public BrockenLinksImagesPage checkBrockenLinks() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        URL url = null;
        // create url-connection and get status code
        try {
            url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() +
                        " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " is a broken link");
        }
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrockenLinksImagesPage checkBrockenImages() {
        System.out.println("We have " + images.size() + " images");
        for (int i = 0; i < images.size(); i++) {
            WebElement element = images.get(i);
            String imageUrl = element.getAttribute("src");
            System.out.println("URL of Images " + (i + 1) + " is: " + imageUrl);
            verifyLinks(imageUrl);

        // check to display image with JS executor
        try {
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) wd).executeScript(
                    "return (typeof arguments[0].naturalWidth != undefined " +
                            "&& arguments[0].naturalWidth > 0);", element);
            if (imageDisplayed) {
                System.out.println("DISPLAY - OK");
                System.out.println("*******************************************");
            } else {
                System.out.println("DISPLAY - BROKEN");
            }
        } catch (Exception e) {
            System.out.println("Error occured");
        }
        }
        return this;
    }
}
