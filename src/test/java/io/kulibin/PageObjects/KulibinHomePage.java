package io.kulibin.PageObjects;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.getDriver;


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


    public PageOfDrills goToDrills() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(powerTool);
        builder.perform();
        drills.click();

        return new PageOfDrills();
    }

    public PageOfPerforators goToPerforators() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(powerTool);
        builder.perform();
        perforators.click();

        return new PageOfPerforators();
    }

    public PageOfGrinders goToGrinders() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(powerTool);
        builder.perform();
        grinders.click();

        return new PageOfGrinders();
    }

    public PageOfScrewdriver goToScrewdrivers() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(powerTool);
        builder.perform();
        screwdrivers.click();
        return new PageOfScrewdriver();
    }


}


 /* public void openPageOfTool(String name){
        Actions builder = new Actions(BrowserFactory.getDriver());
        builder.moveToElement(powerTool);
        builder.perform();
        if ("Дрели".equals(name)) {
            drills.click();
        } else if ("Перфораторы".equals(name)) {
            perforators.click();
        } else if ("Болгарки".equals(name)) {
            grinders.click();
        } else if ("Шуруповерты".equals(name)) {
            screwdrivers.click();
            return new
        } else {
            System.out.println("error");
        }

        screwdrivers.click();
    }*/

