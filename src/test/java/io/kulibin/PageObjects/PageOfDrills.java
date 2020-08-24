package io.kulibin.PageObjects;

import Helpers.Product;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Random;

import static core.BrowserFactory.getDriver;


public class PageOfDrills extends GridPage {

    @FindBy(xpath = "//div[@class = 'price-row']")
    private WebElement cardOfProdut;

    String promoPrice;
    String price;

    private static final String promoPriceTag = "item_old_price old-price";
    private static final String priceTag = "price";

    public PageOfDrills() {
        super();
    }

    public int selectRandomProduct(int x) {
        Random rand = new Random();
        int randomProduct = rand.nextInt(x);
        return randomProduct;
    }

    public void checkPromoAndOldPriceInProductWithPromotionalTicket(int numberOfProductsForCheck) {
        int temp = 0;
        for (int i = 0; i < getProductContainer().size(); i++) {
            WebElement productContainer = getProductContainer().get(i);
            Product product = new Product(productContainer);
            if (product.getStickerOfDiscount() != null) {
                product.getLinkToProduct().click();

                if (cardOfProdut.getAttribute("innerHTML").contains(promoPriceTag)) {
                    promoPrice = BrowserFactory.getDriver().findElement(By.xpath("//div[@class='item-text']//span[contains(@class,'item_old_price old-price')]")).getText();
                } else promoPrice = null;

                if (cardOfProdut.getAttribute("innerHTML").contains(priceTag)) {
                    price = BrowserFactory.getDriver().findElement(By.xpath("//div[@class='item-text']//span[@class='price']")).getText();
                } else price = null;

                Assert.assertNotNull(price);
                Assert.assertNotNull(promoPrice);

                temp++;
                if (numberOfProductsForCheck == temp){break;}

                getDriver().navigate().back();
            }
        }
    }

}
