package Helpers;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Getter
@Setter
public class Product {
    public String name;
    public String price;
    public String oldPrice;
    public String flag;
    public String stickerOfDiscount;
    public WebElement linkToProduct;

    private static final String discountTag = "stick-list__span";
    private static final String oldPriceTag = "old-price";

    public Product(WebElement element) {

        this.name = element.findElement(By.xpath(".//h4[@class='s_title']//span")).getText();
        this.price = element.findElement(By.xpath(".//span[@class='price']")).getText();
        this.flag = element.findElement(By.xpath(".//div[@class = 'item-brand-country']/img")).getAttribute("src");
        this.linkToProduct = element.findElement(By.xpath(".//h4[@class='s_title']//span"));

        if (element.getAttribute("innerHTML").contains(discountTag)) {
            this.stickerOfDiscount = element.findElement(By.xpath(".//div[@class='stick-list']/div/span[@style]")).getText();
        } else {
            this.stickerOfDiscount = null;
        }

        if (element.getAttribute("innerHTML").contains(oldPriceTag)) {
            this.oldPrice = element.findElement(By.xpath(".//span[@class = 'old-price']")).getText();
        } else {
            this.oldPrice = null;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) &&
                price.equals(product.price) &&
                oldPrice.equals(product.oldPrice) &&
                flag.equals(product.flag) &&
                stickerOfDiscount.equals(product.stickerOfDiscount) &&
                linkToProduct.equals(product.linkToProduct);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, price, oldPrice, flag, stickerOfDiscount, linkToProduct);
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




