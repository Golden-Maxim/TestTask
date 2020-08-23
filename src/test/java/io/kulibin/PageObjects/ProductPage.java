package io.kulibin.PageObjects;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//div[@class = 'item-print-block']//div[@class = 'item-print-block'] //span[@class = 'item_old_price old-price']")
    private WebElement promoPrice;
    String string;

    public void checkPromoPrice(){

        if (promoPrice.getAttribute("innerHTML").contains("item_old_price old-price")){
            string = null;
        }else string = BrowserFactory.getDriver().findElement(By.xpath("//div[@class = 'item-print-block'] //span[@class = 'item_old_price old-price']")).getText();
        System.out.println(string);
      //  Assert.assertNotNull(string);
    }
}
//span[@class = 'item_old_price old-price']