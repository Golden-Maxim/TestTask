package io.kulibin.PageObjects;

import core.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class KulibinHomePage extends BasePage {
    @FindBy(linkText = "Дрели")
    private WebElement drills;
    @FindBy(linkText = "Электроинструмент")
    private WebElement powerTool;
    @FindBy(linkText = "Перфораторы")
    private WebElement perforators;
    @FindBy(linkText = "Болгарки")
    private WebElement grinders;
    @FindBy(linkText = "Шуруповерты")
    private WebElement screwdrivers;
    @FindBy(css = "a[href='/catalog/']")
    private WebElement catalog;

    Actions builder = new Actions(BrowserFactory.getDriver());


    public PageOfDrills goToDrills() {
        catalog.click();
        builder.moveToElement(powerTool);
        builder.perform();
        drills.click();
        return new PageOfDrills();
    }

    public PageOfPerforators goToPerforators() {
        catalog.click();
        builder.moveToElement(powerTool);
        builder.perform();
        perforators.click();

        return new PageOfPerforators();
    }

    public PageOfGrinders goToGrinders() {
        catalog.click();
        builder.moveToElement(powerTool);
        builder.perform();
        grinders.click();

        return new PageOfGrinders();
    }

    public PageOfScrewdriver goToScrewdrivers() {
        catalog.click();
        builder.moveToElement(powerTool);
        builder.perform();
        screwdrivers.click();
        return new PageOfScrewdriver();
    }


}


