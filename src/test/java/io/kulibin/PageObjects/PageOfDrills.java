package io.kulibin.PageObjects;

import Helpers.Product;
import core.BrowserFactory;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;
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
        return RandomUtils.nextInt(0,x);
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

    @Override
    public List<WebElement> getProductContainer() {
        return super.getProductContainer();

    }
    public List<Product> getProduct(){
        List<Product> productWithDiscount = new ArrayList<>();

        for (int i = 0; i < getProductContainer().size(); i++) {
            WebElement productContainer = getProductContainer().get(i);
            Product product = new Product(productContainer);
            if (product.getStickerOfDiscount() != null) {
                productWithDiscount.add(product);

            }

        }
        return productWithDiscount;

    }

    public void checkRandomProduct(){
        List<Product> productWithDiscount = new ArrayList<>();

        for (int i = 0; i < getProductContainer().size(); i++) {
            WebElement productContainer = getProductContainer().get(i);
            Product product = new Product(productContainer);
            if (product.getStickerOfDiscount() != null) {
                productWithDiscount.add(product);
            }

        }
        for (int i = 0; i < productWithDiscount.size(); i++) {
            for (int j = 0; j < getProductContainer().size(); j++) {
                WebElement productContainer = getProductContainer().get(j);
                Product product = new Product(productContainer);
               if (product.getName().equals(productWithDiscount.get(selectRandomProduct(productWithDiscount.size())).getName())){
                   product.getLinkToProduct().click();
                   System.out.println(product.getName());
                   getDriver().navigate().back();
               }
            }

        }






      /*  Product product = productWithDiscount.get(selectRandomProduct(productWithDiscount.size()));
        product.getLinkToProduct().click();
        getDriver().navigate().back();*/






          /*  for (int i = 0; i < getProductContainer().size(); i++) {
                for (int  j = 0;j < productWithDiscount.size();j++) {
                WebElement productContainer = getProductContainer().get(i);
                Product product = new Product(productContainer);

                if (productWithDiscount.get(j).getLinkToProduct().getText().equals(product.getLinkToProduct().getText())) {
                    product.getLinkToProduct().click();
                    getDriver().navigate().back();
                }
            }
        }*/
        System.out.println("Conflict");
        List<String> s;
    }

}
