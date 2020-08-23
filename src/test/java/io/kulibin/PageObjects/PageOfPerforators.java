package io.kulibin.PageObjects;

import Helpers.Product;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;



public class PageOfPerforators extends BasePage {
   /* @FindBy(className = "next")
    private WebElement nextPage;*/
    private By nextPage  = By.className("next");

    public void checkPriceOfPerforators(int countOfPage) {
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < countOfPage; i++) {
            for (WebElement singleContainer : productContainers) {
                products.add(new Product(singleContainer));
            }
            BrowserFactory.getDriver().findElement(nextPage).click();
            //nextPage.click();
        }
        for (Product product : products) {
            Assert.assertNotNull(product.getPrice());
        }

    }
}
