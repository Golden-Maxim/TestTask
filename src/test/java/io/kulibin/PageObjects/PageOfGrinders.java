package io.kulibin.PageObjects;

import Helpers.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PageOfGrinders extends GridPage {
    @FindBy(xpath = "//span[@class = 'item_old_price old-price']")
    private WebElement oldPrice;
    @FindBy(xpath = ".//span[@class='price']")
    private WebElement promoPrice;

    public void checkThatDiscountIsCorrect() {
        List<Product> products = new ArrayList<Product>();

        for (WebElement singleContainer : getProductContainer()) {
            products.add(new Product(singleContainer));
        }
        for (Product product : products) {
            if (product.getStickerOfDiscount() != null) {
                int x = parseInt(product.getOldPrice().replaceAll("[^0-9]", "").trim());
                int y = parseInt(product.getStickerOfDiscount().replaceAll("[^0-9]", "").trim());
                int c = x * y / 100;
                int expectedPrice = x - c;
                int actualPrice = parseInt(product.getPrice().replaceAll("[^0-9]", "").trim());

                Assert.assertTrue(expectedPrice == actualPrice, "Name:\t" + product.getName() + "\tPrice should be: " + expectedPrice + " грн\t");
            }
        }

    }
}

