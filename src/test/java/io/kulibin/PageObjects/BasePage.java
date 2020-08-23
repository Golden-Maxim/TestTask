package io.kulibin.PageObjects;

import core.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
