package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    public ProductListResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnClosePopUp() {
        popupButton.clickIfPresent(5);
    }

    public List<String> getResultPricesAsStrings() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getResultPricesAsNumbers() {
        return getResultPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }

    public boolean isProductListEmpty() {
        return productPrices.isEmpty();
    }

}
