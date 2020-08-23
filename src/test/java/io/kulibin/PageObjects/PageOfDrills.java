package io.kulibin.PageObjects;

import Helpers.Product;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PageOfDrills extends ContainerOfProduct {
   /* @FindBy(xpath = "//div[@class = 'item-print-block']//div[@class = 'item-print-block'] //span[@class = 'item_old_price old-price']")
    private WebElement promoPrice;*/
    private By promoPrice = By.xpath("//div[@class = 'item-print-block']//div[@class = 'item-print-block'] //span[@class = 'item_old_price old-price']");

    public int selectRandomProduct(int x) {
        Random rand = new Random();
        int randomProduct = rand.nextInt(x);
        return randomProduct;
    }

    public void lookForProductWithTicket() throws InterruptedException {
        List<Product> products = new ArrayList<Product>();
        List<Product> productsWithTicket = new ArrayList<Product>();
        ContainerOfProduct containerOfProduct = new ContainerOfProduct();

        for (WebElement singleContainer : containerOfProduct.getProductContainer()) {
            products.add(new Product(singleContainer));
        }

        for (Product product : products) {

            if (product.getStickerOfDiscount() != null) {
               product.getLinkToProduct().click();
               Thread.sleep(5000);
                System.out.println(BrowserFactory.getDriver().findElement(promoPrice).getText());
               BrowserFactory.getDriver().navigate().back();
                Thread.sleep(5000);

            }else {continue;}
        }

        }


            /*products.get(selectRandomProduct(products.size()-1)).getLinkToProduct().click();
            Thread.sleep(5000);
        System.out.println(BrowserFactory.getDriver().findElement(By.xpath("//div[contains(@class,'price-row price-holder')]//span[@class = 'old-price']")).getText());
*/


    }



// soft assertion   stick-list__span
//assertion scope