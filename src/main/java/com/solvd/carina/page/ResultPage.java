package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    @FindBy(xpath = "//h4[@class='nohits_title___2jjLy']")
    private ExtendedWebElement searchNoContentTitle;

    @FindBy(xpath = "//p[@class='gl-body--s']")
    private ExtendedWebElement searchNoContentDescription;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void closePopUp() {
        this.popupButton.click();
    }

    public List<String> getResultPricesAsStrings() {
        return this.productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getResultPricesAsNumbers() {
        return this.getResultPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean productListIsVisible() {
        return this.productPrices.isEmpty();
    }

    public boolean popupIsVisible() {
        return popupButton.isVisible();
    }

    public boolean searchNoContentTitleIsVisible() {
        return this.searchNoContentTitle.isVisible();
    }

    public boolean searchNoContentDescriptionIsVisible() {
        return this.searchNoContentDescription.isVisible();
    }

}