package io.kulibin;

import io.kulibin.PageObjects.BaseTest;
import io.kulibin.PageObjects.KulibinHomePage;
import org.testng.annotations.Test;

public class Run extends BaseTest {

    @Test()
    public void checkPromoPriceTest() throws InterruptedException {
        new KulibinHomePage()
                .goToDrills()
                .lookForProductWithTicket();

    }

    @Test
    public void checkPriceOfPerforatorsTest() {
        new KulibinHomePage()
                .goToPerforators()
                .checkPriceOfPerforators(2);
    }

    @Test
    public void showNameAmericanProductTest() {
        new KulibinHomePage()
                .goToScrewdrivers()
                .showNameOfProductWithUsaFlag(3);
    }

    @Test
    public void calculatePromotionalPriceTest() {
        new KulibinHomePage()
                .goToGrinders()
                .checkDiscountIsCorrect();
    }

}
