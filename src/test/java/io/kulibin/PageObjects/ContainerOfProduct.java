package io.kulibin.PageObjects;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContainerOfProduct{
    /*@FindBy(xpath = "//li[contains(@class,'js-product')]")
    private List<WebElement> productContainers;
    */
    private List<WebElement> productContainer;

    public List<WebElement> getProductContainer() {
        return productContainer = BrowserFactory.getDriver().findElements(By.xpath("//li[contains(@class,'js-product')]"));
    }




}
