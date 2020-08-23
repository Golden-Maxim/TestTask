package io.kulibin.PageObjects;

import Helpers.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class PageOfPerforators extends GridPage {
    @FindBy(className = "next")
    private WebElement nextPage;

    public void checkPriceOfPerforators(int countOfPage) {
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < countOfPage; i++) {
            for (WebElement singleContainer : getProductContainer()) {
                products.add(new Product(singleContainer));
            }

            nextPage.click();
        }
        for (Product product : products) {
            Assert.assertNotNull(product.getPrice());
        }

    }
}
