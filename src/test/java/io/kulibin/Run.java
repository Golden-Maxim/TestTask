package io.kulibin;

import io.kulibin.PageObjects.BaseTest;
import io.kulibin.PageObjects.KulibinHomePage;
import org.testng.annotations.Test;

public class Run extends BaseTest {

    @Test()
    public void checkPromoPrice() {
        new KulibinHomePage()
                .goToDrills()
                .checkPromoAndOldPriceInProductWithPromotionalTicket(3);
    }

    @Test
    public void checkPriceOfPerforators() {
        new KulibinHomePage()
                .goToPerforators()
                .checkPriceOfPerforators(2);
    }

    @Test
    public void showNameAmericanProduct() {
        new KulibinHomePage()
                .goToScrewdrivers()
                .showNameOfProductWithUsaFlag(3);
    }

    @Test
    public void calculatePromotionalPrice() {
        new KulibinHomePage()
                .goToGrinders()
                .checkThatDiscountIsCorrect();
    }

}
