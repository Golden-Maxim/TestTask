package io.kulibin.PageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class GridPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'js-product')]")
    private List<WebElement> productContainer;

    public GridPage() {
        super();
    }
}
