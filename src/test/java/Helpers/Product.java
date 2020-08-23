package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Product {
    public String name;
    public String price;
    public String oldPrice;
    public String flag;
    public String stickerOfDiscount;
    public WebElement linkToProduct;


    public Product(WebElement element) {

        this.name = element.findElement(By.xpath(".//h4[@class='s_title']//span")).getText();
        this.price = element.findElement(By.xpath(".//span[@class='price']")).getText();
        this.flag = element.findElement(By.xpath(".//div[@class = 'item-brand-country']/img")).getAttribute("src");
        this.linkToProduct = element.findElement(By.xpath(".//h4[@class='s_title']//span"));

        if (element.findElement(By.xpath(".//div[@class='stick-list']")).getAttribute("innerHTML").contains("stick-list__span")) {
            this.stickerOfDiscount = element.findElement(By.xpath(".//div[@class='stick-list']/div/span[@style]")).getText();
        } else this.stickerOfDiscount = null;

        if (element.findElement(By.xpath(".//div[@class = 'wrap']")).getAttribute("innerHTML").contains("old-price")) {
            this.oldPrice = element.findElement(By.xpath(".//span[@class = 'old-price']")).getText();
        } else this.oldPrice = null;

    }


    public String getStickerOfDiscount() {
        return stickerOfDiscount;
    }


    public String getOldPrice() {
        return oldPrice;
    }


    public WebElement getLinkToProduct() {
        return linkToProduct;
    }


    public String getFlag() {
        return flag;
    }


    public String getName() {
        return name;
    }


    public String getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", promoPrice='" + oldPrice + '\'' +
                ", flag='" + flag + '\'' +
                ", stikerOfDiscount='" + stickerOfDiscount + '\'' +
                ", linkToProduct=" + linkToProduct +
                '}';
    }
}




