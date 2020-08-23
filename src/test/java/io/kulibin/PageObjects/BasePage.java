package io.kulibin.PageObjects;

import core.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    @FindBy(xpath = "//li[contains(@class,'js-product')]")
    List<WebElement> productContainers;

    public BasePage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
