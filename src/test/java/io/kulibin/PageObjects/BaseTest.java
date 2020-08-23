package io.kulibin.PageObjects;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static core.BrowserFactory.getDriver;

public class BaseTest {

    @BeforeSuite
    public void start() {
        BrowserFactory.getDriver();
    }

    @BeforeTest
    public void navigateTo() {
        getDriver().get("https://kulibin.com.ua/");
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='custom-close']")));
        getDriver().findElement(By.xpath("//span[@class='custom-close']")).click();

    }

    @AfterSuite
    public void finish() {
        BrowserFactory.closeBrowser();
    }
}
