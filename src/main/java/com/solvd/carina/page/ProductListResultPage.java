package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductListResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    public ProductListResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnClosePopUp() {
        popupButton.click();
    }

    public List<Integer> getResultPricesAsNumbers() {
        List<Integer> productPrice = new ArrayList<>();
        productPrices.stream()
                .map(extendedWebElement -> extendedWebElement.getText()
                        .replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .forEach(productPrice::add);
        return productPrice;
    }

    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }

    public boolean isProductListEmpty() {
        return productPrices.isEmpty();
    }

    public void scrollDownPage() throws InterruptedException {
        int from = 0;
        int to = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from + "," + to + ")");
            Thread.sleep(1000);
            from = from + 500;
            to = to + 500;
        }
    }

}
