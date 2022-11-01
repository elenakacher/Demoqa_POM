package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public LinksPage checkAllLinks() {
        System.out.println("Total links on the Webpage: " + links.size());
        String url = null;
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksPage checkBrockenLinks() {
        for (int i = 1; i < links.size(); i++) {
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

    @FindBy(id = "created")
    WebElement created;

    @FindBy(id = "no-content")
    WebElement noContent;

    @FindBy(id = "moved")
    WebElement moved;

    @FindBy(id = "bad-request")
    WebElement badRequest;

    @FindBy(id = "unauthorized")
    WebElement unauthorized;

    @FindBy(id = "forbidden")
    WebElement forbidden;

    @FindBy(id = "invalid-url")
    WebElement invalidUrl;

    @FindBy(id = "linkResponse")
    WebElement linkResponse;

    public String getAPIResponsetext(String request) {
        switch (request){
            case "Created": created.click();
                break;
            case "No Content": noContent.click();
                break;
            case "Moved": moved.click();
                break;
            case "Bad Request": badRequest.click();
                break;
            case "Unauthorized": unauthorized.click();
                break;
            case "Forbidden": forbidden.click();
                break;
            case "Not Found": invalidUrl.click();
                break;
        }
        return linkResponse.getText();
    }
}
